package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "shop cart data parameters")
@Data
public class ShopCartInputVO {
    @Schema(description = "bookId")
    @NotNull(message = "bookId cannot be null")
    private Long bookId;
    @Schema(description = "qty")
    @NotNull(message = "qty cannot be null")
    @DecimalMin(inclusive = false, value = "0", message = "qty must be greater than 0")
    private BigDecimal qty;
}
