package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapping.BookMapping;
import com.example.demo.model.BookDO;
import com.example.demo.service.BookService;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.output.BookOutputVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookDO> implements BookService {
    private final BookMapping bookMapping;

    public BookServiceImpl(BookMapping bookMapping) {
        this.bookMapping = bookMapping;
    }

    /**
     * 查询列表
     * @param query
     * @return
     */
    @Override
    public List<BookOutputVO> selectList(BookQuery query) {
        LambdaQueryWrapper<BookDO> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.hasText(query.getTitle()), BookDO::getTitle, query.getTitle());
        wrapper.like(StringUtils.hasText(query.getAuthor()), BookDO::getAuthor, query.getAuthor());
        wrapper.eq(query.getType() != null, BookDO::getType, query.getType());
        wrapper.ge(query.getMinPrice() != null, BookDO::getPrice, query.getMinPrice());
        wrapper.lt(query.getMaxPrice() != null, BookDO::getPrice, query.getMaxPrice());
        List<BookDO> bookDOList = baseMapper.selectList(wrapper);
        return bookMapping.toBookOutputVOList(bookDOList);
    }
}
