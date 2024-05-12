package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(title = "book list query parameters", description = "book list query parameters")
@Data
public class BookQuery {
    @Schema(description = "book title query parameter", example = "book")
    private String title;
    @Schema(description = "book author query parameter", example = "Jone")
    private String author;
    @Schema(description = "greater than or equal to minPrice", example = "0")
    private BigDecimal minPrice;
    @Schema(description = "less than maxPrice", example = "100")
    private BigDecimal maxPrice;
    @Schema(description = "1-history; 2-education", example = "1")
    private Integer type;
}
