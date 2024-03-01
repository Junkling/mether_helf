package io.elice.shoppingmall.domain.category.dto.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirstCategoryUpdatePayload {

    @NotEmpty
    private String role;

    @NotEmpty
    private String name;
}
