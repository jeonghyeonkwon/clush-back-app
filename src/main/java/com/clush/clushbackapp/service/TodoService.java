package com.clush.clushbackapp.service;

import com.clush.clushbackapp.domain.todo.Todo;
import com.clush.clushbackapp.domain.todo.TodoCategory;
import com.clush.clushbackapp.dto.request.TodoRequest;
import com.clush.clushbackapp.repository.TodoCategoryRepository;
import com.clush.clushbackapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoCategoryRepository todoCategoryRepository;
    private final TodoRepository todoRepository;


    @Transactional
    public Long register(Long usersId, Long todoCategoryId, TodoRequest todoRequest) {

        TodoCategory todoCategory = todoCategoryRepository.findByUsersIdAndTodoCategoryId(usersId, todoCategoryId).orElseThrow(
                () -> new IllegalArgumentException("잘못된 접근 입니다.")
        );

        Todo saved = todoRepository.save(
                Todo.create(
                        todoRequest.getTitle(), todoRequest.getContent(),
                        todoRequest.getTodoStatus(), todoRequest.getTodoPriority(), todoCategory)
        );

        return saved.getTodoId();
    }
}
