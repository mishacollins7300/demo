package com.example.demo.model;

import com.example.demo.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usr")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Familiya")
    private String familiya;

    @Column(name = "Imya")
    private String imya;

    @Column(name = "Otchestvo")
    private String otchestvo;

    @Column(name = "DataRogdeniya")
    private Date dataRogdeniya;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "Avatar")
    private String avatar;

    @Column(name = "username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Nickname")
    private String nickname;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_event",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "event_id") }
    )
    private List<Event> events;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
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
}
