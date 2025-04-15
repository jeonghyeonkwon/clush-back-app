package com.clush.clushbackapp.service;

import com.clush.clushbackapp.domain.auth.UserRole;
import com.clush.clushbackapp.domain.auth.Users;
import com.clush.clushbackapp.domain.todo.TodoCategory;
import com.clush.clushbackapp.dto.request.TodoCategoryRequest;
import com.clush.clushbackapp.repository.TodoCategoryRepository;
import com.clush.clushbackapp.repository.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootApplication
@ExtendWith(MockitoExtension.class)
class TodoCategoryServiceTest {
    @Mock
    private UsersRepository usersRepository;

    @Mock
    private TodoCategoryRepository todoCategoryRepository;

    @InjectMocks
    private TodoCategoryService todoCategoryService;

    String username = "jeonghyeon";
    String password = "1234";

    @Test
    void create() {
        String title = "대분류 카테고리";
        Users users = new Users(1L, username, password, UserRole.BASIC);
        when(
                usersRepository.findById(1L)
        ).thenReturn(
                Optional.of(users)
        );
        when(
                todoCategoryRepository.save(any())
        ).thenReturn(
                new TodoCategory(3L, title, users)
        );

        Long savedTodoCategoryId = todoCategoryService.register(1L, new TodoCategoryRequest(title));
        assertThat(savedTodoCategoryId).isEqualTo(3L);
    }

    @Test
    @DisplayName("생성 시 없는 회원 일 경우 예외 처리")
    void create_Exception() {
        String title = "대분류 카테고리";

        when(
                usersRepository.findById(1L)
        ).thenReturn(
                Optional.empty()
        );

        Assertions.assertThatThrownBy(
                () -> todoCategoryService.register(1L, new TodoCategoryRequest(title))
        ).isInstanceOf(IllegalArgumentException.class);
    }

}