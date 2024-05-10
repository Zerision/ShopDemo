package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.demo.utils.R;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.output.BookOutputVO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * book controller
 */
@Tag(description = "书籍控制器", name = "book controller")
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * select book list
     * @param query
     * @return
     */
    @Schema(description = "查询书籍列表")
    @PostMapping("/list")
    public R<List<BookOutputVO>> list(@RequestBody BookQuery query) {
        List<BookOutputVO> list = bookService.selectList(query);
        return R.success(list);
    }
}
