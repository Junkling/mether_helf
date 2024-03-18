package io.elice.shoppingmall.domain.common;

import io.elice.shoppingmall.domain.common.dto.result.RoleResult;
import io.elice.shoppingmall.domain.common.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<RoleResult> findAll() {
        return roleRepository.findAll().stream().map(r -> RoleResult.builder().id(r.getId()).name(r.getName()).build()).toList();
    }

}
