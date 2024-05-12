package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "shop cart list query parameters")
@Data
public class ShopCartQuery {
    @Schema(description = "book title", example = "book")
    private String title;
    @Schema(description = "book author", example = "Jone")
    private String author;
    @Schema(description = "greater than or equal to minPrice", example = "0")
    private BigDecimal minPrice;
    @Schema(description = "less than maxPrice", example = "100")
    private BigDecimal maxPrice;
    @Schema(description = "1-history; 2-education", example = "1")
    private Integer type;
}
