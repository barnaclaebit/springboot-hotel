package com.barnaclaebit.project.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="tb_user")
@Getter
@Setter
@EqualsAndHashCode
public class User implements UserDetails {
    
	private static final long serialVersionUID = 6621550917365958759L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private long id;
    @Column(name = "cl_user_name")
    private String username;
    @Column(name = "cl_name")
    private String name;
    @Column(name = "cl_second_name")
    private String secondName;
    @Column(name = "cl_full_name")
    private String fullName;
    @Column(name = "cl_role")
    private Role role;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Contact contact;
    @Column(name = "cl_password")
    private String password;

    public User(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public User(Long id, String username, String password, Role role) {
    	this.id = id;
    	this.username = username;
        this.password = password;
        this.role = role;
    }

    public User (){
    }

    @Override //role validation if user is a normal or admin by db role column
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(this.role == Role.ADMIN) return List.of(new SimpleGrantedAuthority( "ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    // i'll add new features for user logins
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
