package io.elice.shoppingmall.domain.user.entity;


import io.elice.shoppingmall.domain.code.Role;
import io.elice.shoppingmall.common.BassEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection
    private List<String> roles = new ArrayList<>();

    private String job;

    private String company;

}
