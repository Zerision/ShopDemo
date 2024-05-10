package com.example.demo.controller;

import com.example.demo.service.ShopCartService;
import com.example.demo.utils.R;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.input.ShopCartCreateInputVO;
import com.example.demo.vo.output.BookOutputVO;
import com.example.demo.vo.output.ShopCartOutputVO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * shop cart controller
 */
@Tag(description = "购物车控制器", name = "shop cart controller")
@RestController
@RequestMapping("/shopCart")
public class ShopCartController {
    private final ShopCartService shopCartService;

    public ShopCartController(ShopCartService shopCartService) {
        this.shopCartService = shopCartService;
    }

    /**
     * create shop cart data
     * @param params
     * @return
     */
    @Schema(description = "创建购物车数据")
    @PostMapping("/create")
    public R<List<ShopCartOutputVO>> create(@Valid @RequestBody List<ShopCartCreateInputVO> params) {
        // 没有权限功能,默认给用户ID
        List<ShopCartOutputVO> list = shopCartService.create(params, "1");
        return R.success(list);
    }
}
