package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("shop_cart")
public class ShopCartDO {
    /**
     * id
     */
    private Long id;
    /**
     * bookId
     */
    private Long bookId;
    /**
     * userId
     */
    private String userId;
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
     * qty
     */
    private BigDecimal qty;
    /**
     * amt
     */
    private BigDecimal amt;
    /**
     * type
     */
    private Integer type;
}
