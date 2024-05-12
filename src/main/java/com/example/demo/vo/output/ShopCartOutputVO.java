package com.example.demo.vo.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "shop cart list query results")
@Data
public class ShopCartOutputVO {
    @Schema(description = "shop cart id")
    private Long id;

    @Schema(description = "book title")
    private String title;

    @Schema(description = "book author")
    private String author;

    @Schema(description = "book price")
    private BigDecimal price;

    @Schema(description = "1-history; 2-education")
    private Integer type;

    @Schema(description = "bookId")
    private Long bookId;

    @Schema(description = "qty")
    private Integer qty;

    @Schema(description = "amt")
    private BigDecimal amt;

    @Schema(description = "userId")
    private String userId;
}
