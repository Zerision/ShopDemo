package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.ShopCartDO;
import com.example.demo.vo.input.ShopCartCreateInputVO;
import com.example.demo.vo.input.ShopCartInputVO;
import com.example.demo.vo.input.ShopCartQuery;
import com.example.demo.vo.output.ShopCartOutputVO;

import java.math.BigDecimal;
import java.util.List;

public interface ShopCartService extends IService<ShopCartDO> {
    /**
     * create shop cart data
     * @param params
     * @param userId
     * @return
     */
    List<ShopCartOutputVO> create(List<ShopCartInputVO> params, String userId);

    /**
     * get shop cart data by id
     * @param id
     * @return
     */
    ShopCartOutputVO selectById(Long id);

    /**
     * select shop cart lis
     * @param query
     * @return
     */
    List<ShopCartOutputVO> selectList(ShopCartQuery query);

    /**
     * get shop cart total amount
     * @param query
     * @return
     */
    BigDecimal getTotalAmount(ShopCartQuery query);
}
