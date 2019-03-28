package com.asia.pay.model;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Dang Dim
 * Date     : 3/20/2019, 5:10 PM
 * Email    : d.dim@gl-f.com
 */

@Table(name = "tbl_user")
@Entity
public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private boolean activated;
    private Set<Role> authorities;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 0, max = 500)
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordEncoder().encode(password);
    }

    @Column(name = "email", nullable = true, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "activated", nullable = true)
    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "table_user_role", joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = true)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = true)})
    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
