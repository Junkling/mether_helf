package io.elice.shoppingmall.util.aspect.exception.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {
    private String location;

    private List<String> params = new ArrayList<>();

}
