package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "update book data parameters")
public class BookUpdateInputVO extends BookInputVO{
    @NotNull(message = "id cannot be null")
    private Long id;
}
