package com.app.flip.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.awt.font.ShapeGraphicAttribute;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(new HashSet<>(Arrays.asList(Permission.USERS_READ))),
    ADMIN(new HashSet<>(Arrays.asList(Permission.USERS_READ, Permission.USERS_WRITE)));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions () {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities () {
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
