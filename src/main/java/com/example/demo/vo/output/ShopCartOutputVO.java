package com.example.demo.vo.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "shop cart list query results")
@Data
public class ShopCartOutputVO {
    /**
     * id
     */
    @Schema(description = "id")
    private Long id;
    /**
     * title
     */
    @Schema(description = "title")
    private String title;
    /**
     * author
     */
    @Schema(description = "author")
    private String author;
    /**
     * price
     */
    @Schema(description = "price")
    private BigDecimal price;
    /**
     * type
     */
    @Schema(description = "type")
    private Integer type;
    /**
     * bookId
     */
    @Schema(description = "bookId")
    private Long bookId;
    /**
     * qty
     */
    @Schema(description = "qty")
    private Integer qty;
    /**
     * amt
     */
    @Schema(description = "amt")
    private BigDecimal amt;

    @Schema(description = "userId")
    private String userId;
}
