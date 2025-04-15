package com.clush.clushbackapp.domain.todo;

import com.clush.clushbackapp.domain.auth.UserRole;
import com.clush.clushbackapp.domain.auth.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TodoTest {

    @Test
    void 빈_값_검증() {
        TodoCategory todoCategory = new TodoCategory(
                1L, "test",
                new Users(1L, "test", "test", UserRole.BASIC)
        );


        assertThatThrownBy(
                () -> Todo.create("", "content", TodoStatus.PENDING, TodoPriority.LOW, todoCategory)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> Todo.create(null, "content", TodoStatus.PENDING, TodoPriority.LOW, todoCategory)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> Todo.create("title", "", TodoStatus.PENDING, TodoPriority.LOW, todoCategory)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> Todo.create("title", null, TodoStatus.PENDING, TodoPriority.LOW, todoCategory)
        ).isInstanceOf(IllegalArgumentException.class);

    }
}