package com.example.demo;

import com.example.demo.service.ShopCartService;
import com.example.demo.vo.input.ShopCartInputVO;
import com.example.demo.vo.input.ShopCartQuery;
import com.example.demo.vo.output.ShopCartOutputVO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ShopCartServiceTest {
    @Resource
    private ShopCartService shopCartService;

    @Test
    void testSelectList() {
        List<ShopCartInputVO> params = new ArrayList<>();
        ShopCartInputVO param1 = new ShopCartInputVO();
        param1.setBookId(1L);
        param1.setQty(new BigDecimal("1"));
        params.add(param1);
        ShopCartInputVO param2 = new ShopCartInputVO();
        param2.setBookId(2L);
        param2.setQty(new BigDecimal("2"));
        params.add(param2);
        List<ShopCartOutputVO> cartOutputVOList = shopCartService.create(params, "1");
        cartOutputVOList.forEach(System.out::println);
        Assert.isTrue(cartOutputVOList.size() == 2, "create success");
    }

    @Test
    void testGetTotalAmount() {
        ShopCartQuery query = new ShopCartQuery();
        query.setTitle("book");
        BigDecimal totalAmount = shopCartService.getTotalAmount(query);
        System.out.println(totalAmount);
        Assert.isTrue(totalAmount.compareTo(new BigDecimal("5")) == 0, "get total amount success");
    }
}
