package com.example.project1.Controller;

import com.example.project1.Api.ApiResponse;
import com.example.project1.Model.Book;
import com.example.project1.Service.ServiceBook;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/book")
public class ControllerBook {

    private final ServiceBook serviceBook;

    @RequestMapping("/get")
    public ResponseEntity<?> getAll(Book book) {
      ArrayList<Book> b =serviceBook.getAll(book);
        return ResponseEntity.status(200).body(b);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid ServiceBook serviceBook,@RequestBody Book book, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(404).body(errors.getFieldError().getDefaultMessage());
        }
         serviceBook.add(book);
        return ResponseEntity.status(200).body(new ApiResponse("add"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        boolean isDelete = serviceBook.delete(id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("Book deleted "));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Book not found"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable String id, @RequestBody Book book, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(404).body(new ApiResponse("Book not found"));
        }
        boolean isUpdate = serviceBook.update(id);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("Book isUpdate "));
        }
        return null;
    }
}




