package com.example.demo;

import com.example.demo.service.BookService;
import com.example.demo.service.ShopCartService;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.input.ShopCartCreateInputVO;
import com.example.demo.vo.output.BookOutputVO;
import com.example.demo.vo.output.ShopCartOutputVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ShopCartServiceTest {
    @Autowired
    private ShopCartService shopCartService;

    @Test
    void testSelectList() {
        List<ShopCartCreateInputVO> params = new ArrayList<>();
        ShopCartCreateInputVO param1 = new ShopCartCreateInputVO();
        param1.setBookId(1L);
        param1.setQty(new BigDecimal("1"));
        params.add(param1);
        ShopCartCreateInputVO param2 = new ShopCartCreateInputVO();
        param2.setBookId(2L);
        param2.setQty(new BigDecimal("2"));
        params.add(param2);
        List<ShopCartOutputVO> cartOutputVOList = shopCartService.create(params, "1");
        cartOutputVOList.forEach(System.out::println);
        Assert.isTrue(cartOutputVOList.size() == 2, "create success");
    }
}
