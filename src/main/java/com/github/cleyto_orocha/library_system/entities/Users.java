package com.github.cleyto_orocha.library_system.entities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.cleyto_orocha.library_system.enums.UserRole;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "The field login is required")
    @Schema(
        example = "Cleyton",
        description = "User"
    )
    private String login;

    @Schema(
        example = "admin",
        description = "User"
    )
    @NotEmpty(message = "The field password is required")
    private String password;

    @Schema(
        example = "ADMIN",
        description = "ROLE of user"
    )
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Hidden
    @Builder.Default
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.systemDefault());

    @Hidden
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at", nullable = true)
    private ZonedDateTime updateAt;

    // É para o spring security consultar as listas de roles do usuário;
    public Users(String login, String encryptedPassword, UserRole role) {
        this.login = login;
        this.password = encryptedPassword;
        this.role = role;
    }

    @Hidden
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority(UserRole.ADMIN.getDescription()),
                    new SimpleGrantedAuthority(
                            UserRole.USER.getDescription()));
        else
            return List.of(
                    new SimpleGrantedAuthority(UserRole.USER.getDescription()));
    }

    @Hidden
    @Override
    public String getUsername() {
        return login;
    }

    @Hidden
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Hidden
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Hidden
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Hidden
    @Override
    public boolean isEnabled() {
        return true;
    }


}
