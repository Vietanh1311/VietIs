package com.example.baitapvietis.model.entity;

import com.example.baitapvietis.constants.RolesEnum;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
<<<<<<< HEAD
    @Column(name = "username",nullable = true, unique = true)
    private String userName ;
=======
    @Column(name = "username",nullable = false, unique = true)
    private String userName;
>>>>>>> origin/main
    @Column(name = "position")
    private String position;
    @Column(name = "name")
    private String name;
    @Column(name = "dateofbirth")
    private String DateOfBirth;
    @Column(name = "password", nullable = true)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
<<<<<<< HEAD
        return Collections.singleton(new SimpleGrantedAuthority("user"));
=======
        return Collections.singleton(new SimpleGrantedAuthority(this.position));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
>>>>>>> origin/main
    }


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
<<<<<<< HEAD
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }


=======
>>>>>>> origin/main
}
