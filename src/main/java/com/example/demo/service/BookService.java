package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.BookDO;
import com.example.demo.vo.input.BookInputVO;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.input.BookUpdateInputVO;
import com.example.demo.vo.output.BookOutputVO;

import java.util.List;

public interface BookService extends IService<BookDO> {
    /**
     * select book list
     * @param query
     * @return
     */
    List<BookOutputVO> selectList(BookQuery query);

    /**
     * select book by id
     * @param id
     * @return
     */
    BookOutputVO selectById(Long id);

    /**
     * create book data
     * @param param
     * @return
     */
    BookOutputVO create(BookInputVO param);

    /**
     * update book data
     * @param param
     */
    void update(BookUpdateInputVO param);
}
