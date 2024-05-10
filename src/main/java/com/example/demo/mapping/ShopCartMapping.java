package com.example.demo.mapping;


import com.example.demo.model.BookDO;
import com.example.demo.model.ShopCartDO;
import com.example.demo.vo.input.ShopCartCreateInputVO;
import com.example.demo.vo.output.ShopCartOutputVO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopCartMapping {
    List<ShopCartDO> fromShopCartCreateInputVOList(List<ShopCartCreateInputVO> params);

    default void fromBookDO(ShopCartDO shopCartDO, BookDO bookDO) {
        shopCartDO.setAuthor(bookDO.getAuthor());
        shopCartDO.setTitle(bookDO.getTitle());
        shopCartDO.setPrice(bookDO.getPrice());
        shopCartDO.setType(bookDO.getType());
        shopCartDO.setAmt(shopCartDO.getQty().multiply(shopCartDO.getPrice()));
    };

    List<ShopCartOutputVO> toShopCartOutputVOList(List<ShopCartDO> shopList);
}
