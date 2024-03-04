package io.elice.shoppingmall.domain.statuscode.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusCodeCreatePayload {
    private Long id;
    private String name;
}
