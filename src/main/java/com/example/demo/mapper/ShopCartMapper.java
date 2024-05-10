package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.ShopCartDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopCartMapper extends BaseMapper<ShopCartDO> {
}
