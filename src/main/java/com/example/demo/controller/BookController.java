package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.demo.utils.R;
import com.example.demo.vo.input.BookInputVO;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.input.BookUpdateInputVO;
import com.example.demo.vo.output.BookOutputVO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(description = "book controller", name = "book controller")
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    /**
     * select book list
     * @param query
     * @return
     */
    @Schema(description = "select book list")
    @GetMapping("/list")
    public R<List<BookOutputVO>> list(BookQuery query) {
        List<BookOutputVO> list = bookService.selectList(query);
        return R.success(list);
    }

    /**
     * select book by id
     * @return
     */
    @Schema(description = "select book by id")
    @GetMapping("/{id}")
    public R<BookOutputVO> get(@PathVariable("id") Long id) {
        return R.success(bookService.selectById(id));
    }

    /**
     * create book data
     * @param param
     * @return
     */
    @Schema(description = "create book data")
    @PostMapping
    public R<BookOutputVO> create(@Valid @RequestBody BookInputVO param) {
        return R.success(bookService.create(param));
    }

    /**
     * update book data
     * @param param
     * @return
     */
    @Schema(description = "update book data")
    @PutMapping
    public R<Boolean> update(@Valid @RequestBody BookUpdateInputVO param) {
        bookService.update(param);
        return R.success(Boolean.TRUE);
    }

    /**
     * delete book data by id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        bookService.removeById(id);
        return R.success(Boolean.TRUE);
    }
}
