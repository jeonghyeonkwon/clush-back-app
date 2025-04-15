package com.clush.clushbackapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersRequest {
    private String username;
    private String password;
}
