package com.example.demo;

import com.example.demo.service.BookService;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.output.BookOutputVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testSelectList() {
        BookQuery query = new BookQuery();
        query.setType(1);
        List<BookOutputVO> list = bookService.selectList(query);
        list.forEach(System.out::println);
        Assert.isTrue(list.size() == 3, "selectList success");
    }
}
