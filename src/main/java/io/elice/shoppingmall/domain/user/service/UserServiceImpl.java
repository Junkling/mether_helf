package io.elice.shoppingmall.domain.user.service;

import io.elice.shoppingmall.domain.common.Role;
import io.elice.shoppingmall.domain.common.repository.RoleRepository;
import io.elice.shoppingmall.domain.user.dto.payload.*;
import io.elice.shoppingmall.domain.user.dto.result.UserResult;
import io.elice.shoppingmall.domain.user.entity.User;
import io.elice.shoppingmall.domain.user.entity.UserRole;
import io.elice.shoppingmall.domain.user.repository.UserRepository;
import io.elice.shoppingmall.domain.user.repository.UserRoleRepository;
import io.elice.shoppingmall.security.JwtUtil;
import io.elice.shoppingmall.security.MyTokenPayload;
import io.elice.shoppingmall.util.mapsturct.UserResultMapper;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserResultMapper userResultMapper;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Transactional
    @Override
    public Long save(SignUpPayload payload) {
        if (userRepository.existsByUsername(payload.getUsername()))
            throw new EntityExistsException("아이디 중복입니다.");

        if (userRepository.existsByEmail(payload.getEmail()))
            throw new EntityExistsException("이메일 중복입니다.");

        payload.setRoleId(1L);
        User save = userRepository.save(
                User.builder()
                        .username(payload.getUsername())
                        .password(passwordEncoder.encode(payload.getPassword()))
                        .nickname(payload.getNickname())
                        .company(payload.getCompany())
                        .email(payload.getEmail())
                        .job(payload.getJob())
                        .build()
        );
        save.addRole(UserRole.builder().user(save).role(roleRepository.findById(payload.getRoleId()).orElseThrow()).build());
        return save.getId();
    }

    @Transactional
    @Override
    public Long updateUser(Long userId, UserUpdatePayload payload) {
        User user = userRepository.findById(userId).orElseThrow();
        user.editUserInfo(payload);
        return user.getId();
    }
    @Override
    public String signIn(SignInPayload payload) {
        User user = userRepository.findByUsername(payload.getUsername());
        if (user == null || !passwordEncoder.matches(payload.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("입력된 정보를 확인해 주세요.");
        }

        return jwtUtil.generate(new MyTokenPayload(user.getId(), user.getUsername(), user.getRoles().stream().map(ur -> ur.getRole().getName()).toList()));
    }

    @Override
    public Page<UserResult> findAllUserByPage(String nickname , String role, Pageable pageable) {
        if (StringUtils.hasText(role)) {
            return userRepository.findAllByRole(role, pageable).map(userResultMapper::toDto);
        } else if (StringUtils.hasText(nickname)) {
            return userRepository.findAllByNicknameContaining(nickname, pageable).map(userResultMapper::toDto);
        }
        return userRepository.findAll(pageable).map(userResultMapper::toDto);
    }

    @Override
    public UserResult findOneById(Long id) {
        return userResultMapper.toDto(
                userRepository.findById(id).orElseThrow());
    }

    @Transactional
    @Override
    public Long updateUserRole(Long userId, UserRoleEditPayload payload) {
        Role role = roleRepository.findByName(payload.getRoleName()).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        userRoleRepository.findAllByUserId(userId).forEach(userRoleRepository::delete);
        user.updateRole(UserRole.builder().user(user).role(role).build());

        return user.getId();
    }

    @Override
    public Boolean checkDuplicate(DuplicateCheckDto dto) {
        if (StringUtils.hasText(dto.getUsername())) {
            if (userRepository.existsByUsername(dto.getUsername()))
                throw new EntityExistsException("이미 존재하는 아이디입니다.");
        } else if (StringUtils.hasText(dto.getEmail())) {
            if (userRepository.existsByEmail(dto.getEmail()))
                throw new EntityExistsException("이미 존재하는 이메일입니다.");
        } else if (StringUtils.hasText(dto.getNickname())) {
            if (userRepository.existsByNickname(dto.getNickname()))
                throw new EntityExistsException("이미 존재하는 닉네임입니다.");
        }
        return true;
    }
}
