package io.elice.shoppingmall.domain.category.dto.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
public class FirstCategoryCreatePayload {

    @NotEmpty
    private String name;

    @NotEmpty
    private String role;
}
