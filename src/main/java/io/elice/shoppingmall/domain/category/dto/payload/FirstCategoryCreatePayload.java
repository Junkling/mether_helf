package io.elice.shoppingmall.domain.category.dto.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FirstCategoryCreatePayload {

    @NotEmpty
    private String name;

    @NotEmpty
    private String role;
}
