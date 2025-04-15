package com.clush.clushbackapp.dto.request;

import com.clush.clushbackapp.domain.todo.TodoPriority;
import com.clush.clushbackapp.domain.todo.TodoStatus;
import lombok.Data;

@Data
public class TodoRequest {
    private String title;
    private String content;
    private TodoStatus todoStatus;
    private TodoPriority todoPriority;

    public TodoRequest(String title, String content, TodoStatus todoStatus, TodoPriority todoPriority) {
        this.title = title;
        this.content = content;
        this.todoStatus = todoStatus;
        this.todoPriority = todoPriority;
    }
}
