package com.clush.clushbackapp.service;

import com.clush.clushbackapp.domain.auth.UserRole;
import com.clush.clushbackapp.domain.auth.Users;
import com.clush.clushbackapp.dto.request.UsersRequest;
import com.clush.clushbackapp.repository.UsersRepository;
import org.assertj.core.api.Assertions;
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
class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    @Test
    void 중복_검증() {
        String username = "jeonghyeon";
        String password = "1234";
        UsersRequest request = new UsersRequest(username, password);
        when(
                usersRepository.findByUsername(username)
        ).thenReturn(
                Optional.of(new Users(1L, username, password, UserRole.BASIC))
        );

        Assertions.assertThatThrownBy(
                () -> usersService.register(request)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 유저_Id_반환() {
        String username = "jeonghyeon";
        String password = "1234";
        UsersRequest request = new UsersRequest(username, password);
        when(usersRepository.save(any()))
                .thenReturn(new Users(1L, username, password, UserRole.BASIC));

        Long usersId = usersService.register(request);

        assertThat(usersId).isEqualTo(1L);
    }


}