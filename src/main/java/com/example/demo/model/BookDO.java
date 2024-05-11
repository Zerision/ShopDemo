package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("book")
public class BookDO {
    /**
     * id
     */
    private Long id;
    /**
     * title
     */
    private String title;
    /**
     * author
     */
    private String author;
    /**
     * price
     */
    private BigDecimal price;
    /**
     * type
     */
    private Integer type;
}
