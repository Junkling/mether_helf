package io.elice.shoppingmall.domain.statuscode.repository;

import io.elice.shoppingmall.domain.statuscode.entity.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StatusCodeRepository extends JpaRepository<StatusCode, Long> {
}
