package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.ShopCartMapper;
import com.example.demo.mapping.ShopCartMapping;
import com.example.demo.model.BookDO;
import com.example.demo.model.ShopCartDO;
import com.example.demo.service.ShopCartService;
import com.example.demo.utils.exception.ServiceException;
import com.example.demo.vo.input.ShopCartInputVO;
import com.example.demo.vo.input.ShopCartQuery;
import com.example.demo.vo.output.ShopCartOutputVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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
     * create shop cart data
     * @param params
     * @param userId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ShopCartOutputVO> create(List<ShopCartInputVO> params, String userId) {
        Set<Long> bookIds = params.stream().map(ShopCartInputVO::getBookId).collect(Collectors.toSet());
        List<BookDO> bookDOList = bookMapper.selectBatchIds(bookIds);
        List<ShopCartDO> shopCartDOList = shopCartMapping.fromShopCartInputVOList(params);
        //Demo generates IDs using simple methods
        long id = System.currentTimeMillis();
        Set<Long> ids = new HashSet<>();
        for (ShopCartDO shopCartDO : shopCartDOList) {
            Optional<BookDO> optional = bookDOList.stream().filter(f -> f.getId().equals(shopCartDO.getBookId())).findFirst();
            if (!optional.isPresent()) {
                throw new ServiceException("book id[" + shopCartDO.getBookId() + "] not exist");
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

    /**
     * get shop cart data by id
     * @param id
     * @return
     */
    @Override
    public ShopCartOutputVO selectById(Long id) {
        ShopCartDO shopCartDO = baseMapper.selectById(id);
        if (shopCartDO == null) {
            throw new ServiceException("shop cart data is not exist id[" + id  + "]");
        }
        return shopCartMapping.toShopCartOutputVO(shopCartDO);
    }

    /**
     * select shop cart lis
     * @param query
     * @return
     */
    @Override
    public List<ShopCartOutputVO> selectList(ShopCartQuery query) {
        LambdaQueryWrapper<ShopCartDO> wrapper = this.toWrapper(query);
        List<ShopCartDO> shopCartDOList = baseMapper.selectList(wrapper);
        return shopCartMapping.toShopCartOutputVOList(shopCartDOList);
    }

    /**
     * get shop cart total amount
     * @param query
     * @return
     */
    @Override
    public BigDecimal getTotalAmount(ShopCartQuery query) {
        LambdaQueryWrapper<ShopCartDO> wrapper = this.toWrapper(query);
        List<ShopCartDO> shopCartDOList = baseMapper.selectList(wrapper);
        return shopCartDOList.stream().map(ShopCartDO::getAmt).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private LambdaQueryWrapper<ShopCartDO> toWrapper(ShopCartQuery query) {
        LambdaQueryWrapper<ShopCartDO> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.hasText(query.getTitle()), ShopCartDO::getTitle, query.getTitle());
        wrapper.like(StringUtils.hasText(query.getAuthor()), ShopCartDO::getAuthor, query.getAuthor());
        wrapper.eq(query.getType() != null, ShopCartDO::getType, query.getType());
        wrapper.ge(query.getMinPrice() != null, ShopCartDO::getPrice, query.getMinPrice());
        wrapper.lt(query.getMaxPrice() != null, ShopCartDO::getPrice, query.getMaxPrice());
        // Demo userID = 1
        wrapper.eq(ShopCartDO::getUserId, "1");
        return wrapper;
    }
}
