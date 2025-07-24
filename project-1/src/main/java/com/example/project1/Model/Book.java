package com.example.project1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {

    @NotEmpty(message = "ID must be not null")
    private String id ;

    @NotEmpty(message = "name must be not empty ")
    private String name ;

    @NotNull(message = "number of pages must be not null")
    private double number_of_pages;

    @NotNull(message = "price must be not null")
    private double price;

    @NotEmpty(message = "category must be not empty ")
    @Pattern(regexp = "novel|academic")
    private String category;

    @NotEmpty(message = "isAvailable must be not empty")
    private boolean isAvailable;
}
