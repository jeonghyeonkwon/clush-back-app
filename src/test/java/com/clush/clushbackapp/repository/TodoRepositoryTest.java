package com.clush.clushbackapp.repository;

import com.clush.clushbackapp.domain.auth.Users;
import com.clush.clushbackapp.domain.todo.Todo;
import com.clush.clushbackapp.domain.todo.TodoCategory;
import com.clush.clushbackapp.domain.todo.TodoPriority;
import com.clush.clushbackapp.domain.todo.TodoStatus;
import com.clush.clushbackapp.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class TodoRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TodoCategoryRepository todoCategoryRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    String username = "jeonghyeon";
    String password = "1234";

    @BeforeEach
    void create() {
        Users savedUser = usersRepository.save(Users.create(username, password));

        TodoCategory todoCategory = todoCategoryRepository.save(TodoCategory.create("대분류 카테고리", savedUser));

        List<Todo> todos = List.of(
                Todo.create("제목1", "내용1", TodoStatus.PENDING, TodoPriority.HIGH, todoCategory),
                Todo.create("제목2", "내용2", TodoStatus.PENDING, TodoPriority.HIGH, todoCategory),
                Todo.create("제목3", "내용3", TodoStatus.PENDING, TodoPriority.HIGH, todoCategory),
                Todo.create("제목4", "내용4", TodoStatus.PENDING, TodoPriority.HIGH, todoCategory)
        );

        todoRepository.saveAll(todos);
    }

    @Test
    @DisplayName("유저로 생성한 Todo 리스트 조회")
    void getTodoCategoryList() {
        Users users = usersRepository.findByUsername(username).get();
        List<Todo> todos = users.getTodoCategories().get(0).getTodos();
        assertThat(todos).hasSize(4);
    }

}