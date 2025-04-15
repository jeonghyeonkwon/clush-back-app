package com.clush.clushbackapp.repository;

import com.clush.clushbackapp.domain.auth.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    void init() {
        usersRepository.save(Users.create("jeonghyeon", "1234"));
    }

    @Test
    void findByUsername() {
        String username = "jeonghyeon";
        String password = "1234";

        Users users = usersRepository.findByUsername(username).get();

        assertAll(
                () -> assertThat(users.getUsername()).isEqualTo(username),
                () -> assertThat(users.getPassword()).isEqualTo(password)
        );
    }


}