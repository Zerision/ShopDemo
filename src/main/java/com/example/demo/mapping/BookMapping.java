package com.example.demo.mapping;


import com.example.demo.model.BookDO;
import com.example.demo.vo.input.BookInputVO;
import com.example.demo.vo.input.BookUpdateInputVO;
import com.example.demo.vo.output.BookOutputVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapping {
    List<BookOutputVO> toBookOutputVOList(List<BookDO> bookDOList);

    BookOutputVO toBookOutputVO(BookDO bookDO);

    BookDO fromBookInputVO(BookInputVO param);

    BookDO fromBookUpdateInputVO(BookUpdateInputVO param);
}
