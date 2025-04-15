package com.clush.clushbackapp.repository;

import com.clush.clushbackapp.domain.auth.Users;
import com.clush.clushbackapp.domain.todo.TodoCategory;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class TodoCategoryRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TodoCategoryRepository todoCategoryRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    Users savedUser;
    TodoCategory todoCategory;

    String username = "jeonghyeon";
    String password = "1234";


    @BeforeEach
    void init() {
        savedUser = usersRepository.save(Users.create(username, password));
        List<TodoCategory> todoCategories = List.of(
                TodoCategory.create("대분류 카테고리", savedUser),
                TodoCategory.create("대분류 카테고리2", savedUser)
        );

        todoCategoryRepository.saveAll(todoCategories);
        testEntityManager.clear();
    }


    @Test
    @DisplayName("유저로 생성한 TodoCategory 리스트 조회")
    void getTodoCategoryList() {
        Users users = usersRepository.findByUsername(username).get();

        assertThat(users.getTodoCategories()).hasSize(2);
    }


}