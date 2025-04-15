package com.clush.clushbackapp.controller;

import com.clush.clushbackapp.dto.request.UsersRequest;
import com.clush.clushbackapp.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    @PostMapping({"", "/"})
    public ResponseEntity register(@RequestBody UsersRequest usersRequest) {
        String usersId = usersService.register(usersRequest).toString();
        return new ResponseEntity(usersId, HttpStatus.CREATED);
    }
}
