package io.elice.shoppingmall.domain.user.entity;


import io.elice.shoppingmall.domain.common.BassEntity;
import io.elice.shoppingmall.domain.common.Role;
import io.elice.shoppingmall.domain.user.dto.payload.UserUpdatePayload;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserRole> roles = new ArrayList<>();

    private String role;

    private String job;

    private String company;

    public void updateRole(UserRole role) {
        roles.add(role);
        this.role = role.getRole().getName();
    }

    public void addRole(UserRole role) {
        List<UserRole> list = new ArrayList<>();
        list.add(role);
        this.roles = list;
        this.role = role.getRole().getName();
    }

    public void editUserInfo(UserUpdatePayload payload) {
        this.nickname = payload.getNickname();
    }

}
