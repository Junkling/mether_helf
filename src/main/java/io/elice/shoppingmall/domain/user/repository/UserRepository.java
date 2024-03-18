package io.elice.shoppingmall.domain.user.repository;

import io.elice.shoppingmall.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllByRole(String role, Pageable pageable);

    Page<User> findAllByNicknameContaining(String nickname, Pageable pageable);

    User findByUsername(String userName);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);
}
