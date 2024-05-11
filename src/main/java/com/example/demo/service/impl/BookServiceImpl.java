package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapping.BookMapping;
import com.example.demo.model.BookDO;
import com.example.demo.model.ShopCartDO;
import com.example.demo.service.BookService;
import com.example.demo.utils.exception.ServiceException;
import com.example.demo.vo.input.BookInputVO;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.input.BookUpdateInputVO;
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
     * select book list
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

    /**
     * select book by id
     * @param id
     * @return
     */
    @Override
    public BookOutputVO selectById(Long id) {
        BookDO bookDO = baseMapper.selectById(id);
        if (bookDO == null) {
            throw new ServiceException("book data is not exist id[" + id  + "]");
        }
        return bookMapping.toBookOutputVO(bookDO);
    }

    /**
     * create book data
     * @param param
     * @return
     */
    @Override
    public BookOutputVO create(BookInputVO param) {
        BookDO bookDO = bookMapping.fromBookInputVO(param);
        //Demo generates IDs using simple methods
        long id = System.currentTimeMillis();
        bookDO.setId(id);
        baseMapper.insert(bookDO);
        BookDO ret = baseMapper.selectById(id);
        return bookMapping.toBookOutputVO(ret);
    }

    /**
     *  update book data
     * @param param
     */
    @Override
    public void update(BookUpdateInputVO param) {
        Long id = param.getId();
        BookDO bookDO = baseMapper.selectById(id);
        if (bookDO == null) {
            throw new ServiceException("book data is not exist id[" + id  + "]");
        }
        BookDO entity = bookMapping.fromBookUpdateInputVO(param);
        baseMapper.update(entity, null);
    }
}
