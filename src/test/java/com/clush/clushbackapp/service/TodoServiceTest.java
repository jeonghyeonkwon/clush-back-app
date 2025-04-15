package com.clush.clushbackapp.service;

import com.clush.clushbackapp.domain.todo.Todo;
import com.clush.clushbackapp.domain.todo.TodoCategory;
import com.clush.clushbackapp.domain.todo.TodoPriority;
import com.clush.clushbackapp.domain.todo.TodoStatus;
import com.clush.clushbackapp.dto.request.TodoRequest;
import com.clush.clushbackapp.repository.TodoCategoryRepository;
import com.clush.clushbackapp.repository.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootApplication
@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private TodoCategoryRepository todoCategoryRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void create() {
        TodoCategory todoCategory = new TodoCategory(1L, "test", null);

        when(
                todoCategoryRepository.findByUsersIdAndTodoCategoryId(1L, 1L)
        ).thenReturn(
                Optional.of(todoCategory)
        );

        when(
                todoRepository.save(any())
        ).thenReturn(
                new Todo(4L, "test", "test", TodoStatus.PENDING, TodoPriority.HIGH, todoCategory)
        );

        Long savedId = todoService.register(1L, 1L, new TodoRequest("test", "test", TodoStatus.PENDING, TodoPriority.HIGH));
        assertThat(savedId).isEqualTo(4L);
    }


    @Test
    @DisplayName("생성 시 TodoCategory 또는 유저가 없을 경우 예외")
    void create_exception() {
        when(
                todoCategoryRepository.findByUsersIdAndTodoCategoryId(1L, 1L)
        ).thenReturn(
                Optional.empty()
        );

        Assertions.assertThatThrownBy(
                () -> todoService.register(1L, 1L, new TodoRequest("test", "test", TodoStatus.PENDING, TodoPriority.HIGH))
        ).isInstanceOf(IllegalArgumentException.class);

    }

}