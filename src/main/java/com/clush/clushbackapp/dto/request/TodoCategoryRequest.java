package com.clush.clushbackapp.dto.request;

import lombok.Data;

@Data
public class TodoCategoryRequest {
    private String title;

    public TodoCategoryRequest(String title) {
        this.title = title;
    }
}
