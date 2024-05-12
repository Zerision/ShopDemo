package com.example.demo.vo.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "book list query results")
@Data
public class BookOutputVO {
    @Schema(description = "id")
    private Long id;

    @Schema(description = "book title")
    private String title;

    @Schema(description = "book author")
    private String author;

    @Schema(description = "book price")
    private BigDecimal price;

    @Schema(description = "1-history; 2-education")
    private Integer type;
}
