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
     * 书籍ID
     */
    private Long bookId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private BigDecimal qty;
    /**
     * 总额
     */
    private BigDecimal amt;
    /**
     * 类型
     */
    private Integer type;
}
