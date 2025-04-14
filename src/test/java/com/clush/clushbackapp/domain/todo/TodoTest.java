package com.clush.clushbackapp.domain.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    @Test
    void 빈_값_검증() {
        Assertions.assertThatThrownBy(() -> Todo.create("", "content", TodoStatus.PENDING, TodoPriority.LOW)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Todo.create(null, "content", TodoStatus.PENDING, TodoPriority.LOW)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Todo.create("title", "", TodoStatus.PENDING, TodoPriority.LOW)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Todo.create("title", null, TodoStatus.PENDING, TodoPriority.LOW)).isInstanceOf(IllegalArgumentException.class);

    }
}