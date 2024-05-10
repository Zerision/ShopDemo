package com.example.demo.vo.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "书籍列表查询结果")
@Data
public class BookOutputVO {
    /**
     * id
     */
    @Schema(description = "id")
    private Long id;
    /**
     * 标题
     */
    @Schema(description = "标题")
    private String title;
    /**
     * 作者
     */
    @Schema(description = "作者")
    private String author;
    /**
     * 单价
     */
    @Schema(description = "单价")
    private BigDecimal price;
    /**
     * 类型
     */
    @Schema(description = "类型")
    private Integer type;
}
