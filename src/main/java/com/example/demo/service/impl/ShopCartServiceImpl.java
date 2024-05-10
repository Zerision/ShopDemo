package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.ShopCartMapper;
import com.example.demo.mapping.ShopCartMapping;
import com.example.demo.model.BookDO;
import com.example.demo.model.ShopCartDO;
import com.example.demo.service.ShopCartService;
import com.example.demo.utils.exception.MyDeniedException;
import com.example.demo.vo.input.ShopCartCreateInputVO;
import com.example.demo.vo.output.ShopCartOutputVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCartDO> implements ShopCartService {
    private final BookMapper bookMapper;
    private final ShopCartMapping shopCartMapping;

    public ShopCartServiceImpl(BookMapper bookMapper, ShopCartMapping shopCartMapping) {
        this.bookMapper = bookMapper;
        this.shopCartMapping = shopCartMapping;
    }


    /**
     * 创建购物车数据
     * @param params
     * @param userId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ShopCartOutputVO> create(List<ShopCartCreateInputVO> params, String userId) {
        Set<Long> bookIds = params.stream().map(ShopCartCreateInputVO::getBookId).collect(Collectors.toSet());
        List<BookDO> bookDOList = bookMapper.selectBatchIds(bookIds);
        List<ShopCartDO> shopCartDOList = shopCartMapping.fromShopCartCreateInputVOList(params);
        // 因为没有主键服务,demo使用简单方法生成注解
        long id = System.currentTimeMillis();
        Set<Long> ids = new HashSet<>();
        for (ShopCartDO shopCartDO : shopCartDOList) {
            Optional<BookDO> optional = bookDOList.stream().filter(f -> f.getId().equals(shopCartDO.getBookId())).findFirst();
            if (!optional.isPresent()) {
                throw new MyDeniedException("书籍信息找不到");
            }
            BookDO bookDO = optional.get();
            shopCartMapping.fromBookDO(shopCartDO, bookDO);
            shopCartDO.setUserId(userId);
            id++;
            shopCartDO.setId(id);
            ids.add(id);
            getBaseMapper().insert(shopCartDO);
        }
        List<ShopCartDO> shopList = getBaseMapper().selectBatchIds(ids);
        return shopCartMapping.toShopCartOutputVOList(shopList);
    }
}
