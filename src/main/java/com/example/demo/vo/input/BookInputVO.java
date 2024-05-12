package com.example.demo.vo.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@Schema(description = "book data parameters")
public class BookInputVO {
    @Schema(description = "book title", example = "my book")
    @NotBlank(message = "title cannot be blank")
    private String title;
    @Schema(description = "book author", example = "Jone")
    @NotBlank(message = "author cannot be blank")
    private String author;
    @Schema(description = "book price", example = "1")
    @NotNull(message = "price cannot be null")
    @DecimalMin(value = "0", message = "price must be greater than or equal to 0")
    private BigDecimal price;
    @Schema(description = "1-history; 2-education", example = "1")
    @NotNull(message = "type cannot be null")
    @Range(min = 1, max = 2, message = "type must be 1 or 2")
    private Integer type;
}
