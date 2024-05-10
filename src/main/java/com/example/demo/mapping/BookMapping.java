package com.example.demo.mapping;


import com.example.demo.model.BookDO;
import com.example.demo.vo.output.BookOutputVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapping {
    List<BookOutputVO> toBookOutputVOList(List<BookDO> bookDOList);
}
