package com.clush.clushbackapp.domain.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoCategoryTest {

    @Test
    void 빈_값_검증() {
        Assertions.assertThatThrownBy(() -> TodoCategory.create("")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> TodoCategory.create(null)).isInstanceOf(IllegalArgumentException.class);
    }

}