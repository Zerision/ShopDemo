package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "书籍列表查询参数")
@Data
public class BookQuery {
    @Schema(description = "标题")
    private String title;
    @Schema(description = "作者")
    private String author;
    @Schema(description = "最小单价")
    private BigDecimal minPrice;
    @Schema(description = "最大单价")
    private BigDecimal maxPrice;
    @Schema(description = "类型")
    private Integer type;
}
