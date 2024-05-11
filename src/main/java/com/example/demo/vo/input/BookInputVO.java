package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "book data parameters")
public class BookInputVO {
    @Schema(description = "title")
    @NotBlank(message = "title cannot be blank")
    private String title;
    @Schema(description = "author")
    @NotBlank(message = "author cannot be blank")
    private String author;
    @Schema(description = "price")
    @NotNull(message = "price cannot be null")
    @DecimalMin(value = "0", message = "price must be greater than or equal to 0")
    private BigDecimal price;
    @Schema(description = "type")
    @NotNull(message = "type cannot be null")
    private Integer type;
}
