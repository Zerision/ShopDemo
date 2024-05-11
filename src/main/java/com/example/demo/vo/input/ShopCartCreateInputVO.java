package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Schema(description = "create shop cart data parameters")
@Data
public class ShopCartCreateInputVO {
    @Schema(description = "data list")
    @Valid
    @NotEmpty(message = "data list cannot be empty")
    private List<ShopCartInputVO> list;
}
