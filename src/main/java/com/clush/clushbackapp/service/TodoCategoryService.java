package com.clush.clushbackapp.service;

import com.clush.clushbackapp.domain.auth.Users;
import com.clush.clushbackapp.domain.todo.TodoCategory;
import com.clush.clushbackapp.dto.request.TodoCategoryRequest;
import com.clush.clushbackapp.repository.TodoCategoryRepository;
import com.clush.clushbackapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoCategoryService {
    private final UsersRepository usersRepository;
    private final TodoCategoryRepository todoCategoryRepository;

    @Transactional
    public Long register(Long usersId, TodoCategoryRequest todoCategoryRequest){

        Users users = usersRepository.findById(usersId).orElseThrow(
                () -> new IllegalArgumentException("잘못된 접근 입니다.")
        );

        TodoCategory saved = todoCategoryRepository.save(
                TodoCategory.create(todoCategoryRequest.getTitle(), users)
        );

        return saved.getTodoCategoryId();
    }
}
