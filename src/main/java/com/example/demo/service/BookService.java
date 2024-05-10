package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.BookDO;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.output.BookOutputVO;

import java.util.List;

public interface BookService extends IService<BookDO> {
    /**
     * 查询列表
     * @param query
     * @return
     */
    List<BookOutputVO> selectList(BookQuery query);
}
