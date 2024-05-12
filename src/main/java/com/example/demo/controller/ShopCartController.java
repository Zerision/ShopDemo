package com.example.demo.controller;

import com.example.demo.service.ShopCartService;
import com.example.demo.utils.R;
import com.example.demo.vo.input.ShopCartCreateInputVO;
import com.example.demo.vo.input.ShopCartQuery;
import com.example.demo.vo.output.BookOutputVO;
import com.example.demo.vo.output.ShopCartOutputVO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(description = "shop cart controller", name = "shop cart controller")
@RestController
@RequestMapping("/shopCart")
public class ShopCartController {
    @Resource
    private ShopCartService shopCartService;

    /**
     * create shop cart data
     * @param param
     * @return
     */
    @Schema(description = "create shop cart data")
    @PostMapping("/create")
    public R<List<ShopCartOutputVO>> create(@Valid @RequestBody ShopCartCreateInputVO param) {
        // Demo userID = 1
        List<ShopCartOutputVO> list = shopCartService.create(param.getList(), "1");
        return R.success(list);
    }

    /**
     * get shop cart data by id
     * @return
     */
    @Schema(description = "get shop cart data by id")
    @GetMapping("/{id}")
    public R<ShopCartOutputVO> get(@PathVariable("id") Long id) {
        return R.success(shopCartService.selectById(id));
    }

    /**
     * select shop cart list
     * @param query
     * @return
     */
    @Schema(description = "select shop cart list")
    @GetMapping("/list")
    public R<List<ShopCartOutputVO>> list(ShopCartQuery query) {
        List<ShopCartOutputVO> list = shopCartService.selectList(query);
        return R.success(list);
    }

    /**
     * get shop cart total amount
     * @param query
     * @return
     */
    @Schema(description = "select shop cart total amount")
    @GetMapping("/getTotalAmount")
    public R<BigDecimal> getTotalAmount(ShopCartQuery query) {
        return R.success(shopCartService.getTotalAmount(query));
    }
}
