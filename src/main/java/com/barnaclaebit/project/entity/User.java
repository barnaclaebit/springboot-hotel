package com.barnaclaebit.project.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="tb_user")
public class User implements UserDetails {
    
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

    public User (){
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(name, user.name) && Objects.equals(secondName, user.secondName) && Objects.equals(fullName, user.fullName) && Objects.equals(contact, user.contact) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, secondName, fullName, role, contact, password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override //role validation if user is a normal or admin by db role column
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(this.role == Role.ADMIN) return List.of(new SimpleGrantedAuthority( "ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getUsername() {
        return username;
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
