package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.ShopCartDO;
import com.example.demo.vo.input.ShopCartCreateInputVO;
import com.example.demo.vo.output.ShopCartOutputVO;

import java.util.List;

public interface ShopCartService extends IService<ShopCartDO> {
    /**
     * 创建购物车数据
     * @param params
     * @param userId
     * @return
     */
    List<ShopCartOutputVO> create(List<ShopCartCreateInputVO> params, String userId);
}
