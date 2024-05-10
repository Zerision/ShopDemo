package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "购物车创建参数")
@Data
public class ShopCartCreateInputVO {
    @Schema(description = "书籍ID")
    @NotNull(message = "bookId不能为空")
    private Long bookId;
    @Schema(description = "数量")
    @NotNull(message = "数量不能为空")
    private BigDecimal qty;
}
