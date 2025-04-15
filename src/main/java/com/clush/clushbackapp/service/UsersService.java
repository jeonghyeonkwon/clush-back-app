package com.clush.clushbackapp.service;

import com.clush.clushbackapp.domain.auth.Users;
import com.clush.clushbackapp.dto.request.UsersRequest;
import com.clush.clushbackapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public Long register(UsersRequest usersRequest) {
        usersRepository.findByUsername(usersRequest.getUsername())
                .ifPresent(
                        notUsed -> {
                            throw new IllegalArgumentException("이미 가입한 회원이 있습니다.");
                        }
                );

        Users saved = usersRepository.save(
                Users.create(usersRequest.getUsername(), usersRequest.getPassword())
        );

        return saved.getUsersId();
    }
}
