package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.demo.utils.R;
import com.example.demo.vo.input.BookInputVO;
import com.example.demo.vo.input.BookQuery;
import com.example.demo.vo.input.BookUpdateInputVO;
import com.example.demo.vo.output.BookOutputVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "book endpoints", description = "Implement RESTFUL endpoints to allow adding books to the store and retrieving the list of available books.")
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
    @GetMapping("/list")
    @Operation(summary = "select book list")
    public R<List<BookOutputVO>> list(@ParameterObject BookQuery query) {
        List<BookOutputVO> list = bookService.selectList(query);
        return R.success(list);
    }

    /**
     * select book by id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "select book by id")
    public R<BookOutputVO> get(@PathVariable("id") Long id) {
        return R.success(bookService.selectById(id));
    }

    /**
     * create book data
     * @param param
     * @return
     */
    @Operation(summary = "create book data")
    @PostMapping
    public R<BookOutputVO> create(@Valid @RequestBody BookInputVO param) {
        return R.success(bookService.create(param));
    }

    /**
     * update book data
     * @param param
     * @return
     */
    @Operation(summary = "update book data")
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
    @Operation(summary = "delete book data by id")
    public R<Boolean> delete(@PathVariable("id") Long id) {
        bookService.removeById(id);
        return R.success(Boolean.TRUE);
    }
}
