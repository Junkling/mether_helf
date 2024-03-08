package io.elice.shoppingmall.domain.user.entity;


import io.elice.shoppingmall.domain.common.BassEntity;
import io.elice.shoppingmall.domain.common.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Role> roles;

    private String role;

    private String job;

    private String company;

    public void updateRole(Role role) {
        roles.clear();
        roles.add(role);
        this.role = role.getName();
    }

}
