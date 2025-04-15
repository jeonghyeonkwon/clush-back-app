package com.clush.clushbackapp.domain.todo;

import com.clush.clushbackapp.domain.auth.Users;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TodoCategoryTest {

    @Test
    void 빈_값_검증() {
        Users users = Users.create("jeonghyeon", "1234");

        assertThatThrownBy(() -> TodoCategory.create("", users))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> TodoCategory.create(null, users))
                .isInstanceOf(IllegalArgumentException.class);
    }

}