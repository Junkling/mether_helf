package io.elice.shoppingmall.domain.common.dto.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RoleResult {
    private Long id;
    private String name;
}
