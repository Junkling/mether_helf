package io.elice.shoppingmall.domain.user.service;

import io.elice.shoppingmall.domain.user.entity.User;
import io.elice.shoppingmall.domain.user.repository.UserRepository;
import io.elice.shoppingmall.security.JwtUtil;
import io.elice.shoppingmall.security.MyTokenPayload;
import io.elice.shoppingmall.web.payload.user.SignInPayload;
import io.elice.shoppingmall.web.payload.user.SignUpPayload;
import io.elice.shoppingmall.web.payload.user.UserEditPayload;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    @Override
    public Long save(SignUpPayload payload) {
        if (userRepository.existsByUsername(payload.getUsername()))
            throw new EntityExistsException("아이디 중복입니다.");

        if (userRepository.existsByEmail(payload.getEmail()))
            throw new EntityExistsException("이메일 중복입니다.");

        return userRepository.save(
                User.builder()
                        .username(payload.getUsername())
                        .password(passwordEncoder.encode(payload.getPassword()))
                        .nickname(payload.getNickname())
                        .company(payload.getCompany())
                        .email(payload.getEmail())
                        .job(payload.getJob())
                        .roles(Stream.of(payload.getRole()).toList())
                        .build()
        ).getId();
    }

    //TODO: 당장 어떤게 수정될지 확실치 않아 만들지 않았음 의사 결정 후 수정 예정
    @Override
    public Long updateUser(UserEditPayload payload) {
        return null;
    }

    @Override
    public String signIn(SignInPayload payload) {
        User user = userRepository.findByUsername(payload.getUsername());
        if (user == null || !passwordEncoder.matches(payload.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("입력된 정보를 확인해 주세요.");
        }

        return jwtUtil.generate(new MyTokenPayload(user.getId(), user.getUsername(), user.getRoles()));
    }

    @Override
    public Boolean duplicateIdCheck(String payload) {
        if (userRepository.existsByUsername(payload))
            throw new EntityExistsException("이미 존재하는 아이디입니다.");
        else
            return true;
    }

    @Override
    public Boolean duplicateEmailCheck(String payload) {
        if (userRepository.existsByEmail(payload))
            throw new EntityExistsException("이미 존재하는 이메일입니다.");
        else
            return true;
    }

    @Override
    public Boolean duplicateNicknameCheck(String payload) {
        if (userRepository.existsByNickname(payload))
            throw new EntityExistsException("이미 존재하는 닉네임입니다.");
        else
            return true;
    }
}
