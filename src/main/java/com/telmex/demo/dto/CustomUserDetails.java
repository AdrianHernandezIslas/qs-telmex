package com.telmex.demo.dto;

import com.telmex.demo.entity.UserInfo;
import com.telmex.demo.entity.UserRole;
import com.telmex.demo.entity.UserSession;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends UserInfo implements UserDetails {

    Collection<? extends GrantedAuthority> authorities;
    @Getter
    @Setter
    private UserSession session;

    public CustomUserDetails(UserInfo byUsername) {
        this.setUsername(byUsername.getUsername());
        this.setPassword(byUsername.getPassword());
        this.setIdUser(byUsername.getIdUser());
        this.setRoles(byUsername.getRoles());
        List<GrantedAuthority> auths = new ArrayList<>();

        for(UserRole role : byUsername.getRoles()){
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }

        this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
