package com.barnaclaebit.project.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.barnaclaebit.project.entity.dto.ReturnResponse;
import com.barnaclaebit.project.repository.UserRepository;
import com.barnaclaebit.project.security.service.TokenService;
import com.barnaclaebit.project.utils.EndPoints;
import com.barnaclaebit.project.utils.Utils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        try {
            if (token != null) {
                //if the token is empty, it passes to the endpoints without the need for a token
                var username = tokenService.validateToken(token);
                UserDetails userDetails = userRepository.findByUsername(username);
                var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); //important to return the authentication
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
            //if the request is not directed to login, authentication is mandatory
           else if(!EndPoints.PUBLIC_POST.contains(request.getRequestURI())){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json");
                response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.FORBIDDEN, "Authentication is necessary.")));
                return;
            }

            filterChain.doFilter(request, response);

           //I'm handling exceptions related to user authentication, returning a json to whoever is consuming it
        }catch (JWTDecodeException e){
            // return error for invalid or malformed token
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.FORBIDDEN, "Invalid Token: " + e.getMessage())));

        } catch (SignatureVerificationException e) {
            // return error for invalid token
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.FORBIDDEN, "Invalid Token: " + e.getMessage())));

        } catch (AccessDeniedException e) {
            // return error for invalid access role
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.FORBIDDEN, e.getMessage())));

        }catch (TokenExpiredException e){
            //return error for expired token
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.FORBIDDEN, e.getMessage())));

        }

    }

    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null) {
            return null;
        }

        return authorizationHeader.replace("Bearer ", ""); //dismiss the token type

    }
}
