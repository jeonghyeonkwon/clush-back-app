package com.clush.clushbackapp.controller;

import com.clush.clushbackapp.dto.request.TodoCategoryRequest;
import com.clush.clushbackapp.dto.request.TodoRequest;
import com.clush.clushbackapp.service.TodoCategoryService;
import com.clush.clushbackapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoController {
    private final TodoCategoryService todoCategoryService;
    private final TodoService todoService;

    @PostMapping("/users/{usersId}/todo-categories")
    public ResponseEntity todoCategoryRegister(
            @PathVariable("usersId") Long usersId, @RequestBody TodoCategoryRequest todoCategoryRequest
    ) {
        String todoCategoryId = todoCategoryService.register(usersId, todoCategoryRequest).toString();
        return new ResponseEntity(todoCategoryId, HttpStatus.CREATED);
    }

    @PostMapping("/users/{usersId}/todo-categories/{todoCategoryId}/todos")
    public ResponseEntity todoRegister(
            @PathVariable("usersId") Long usersId,
            @PathVariable("todoCategoryId") Long todoCategoryId,
            @RequestBody TodoRequest todoRequest
    ) {
        String todoId = todoService.register(usersId, todoCategoryId, todoRequest).toString();
        return new ResponseEntity(todoId, HttpStatus.CREATED);
    }
}
