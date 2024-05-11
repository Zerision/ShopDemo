package com.example.demo.vo.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "book list query results")
@Data
public class BookOutputVO {
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
}
