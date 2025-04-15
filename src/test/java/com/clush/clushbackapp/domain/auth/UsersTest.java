package com.clush.clushbackapp.domain.auth;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UsersTest {

    @Test
    void 빈_값_검증() {
        assertThatThrownBy(() -> Users.create("jeonghyeon", "")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Users.create("", "jeonghyeon")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Users.create(null, "jeonghyeon")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Users.create("jeonghyeon", null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 아이디_띄어쓰기_금지() {
        assertThatThrownBy(() -> Users.create("jeong hyeon", "jeonghyeon")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 아이디_한글_금지() {
        assertThatThrownBy(() -> Users.create("정현", "jeonghyeon")).isInstanceOf(IllegalArgumentException.class);
    }

}