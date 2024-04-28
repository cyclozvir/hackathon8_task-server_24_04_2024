package org.yaremax.hackathon8_task_24_04_2024.models.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private  final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        if (userEntity.getRole() == Role.HELPER) {
            authorities.add(new SimpleGrantedAuthority("ROLE_HELPER"));
        } else if (userEntity.getRole() == Role.IN_NEED) {
            authorities.add(new SimpleGrantedAuthority("ROLE_IN_NEED"));
        } else {
            throw new IllegalArgumentException("Invalid role for user: " + userEntity.getRole());
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
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
