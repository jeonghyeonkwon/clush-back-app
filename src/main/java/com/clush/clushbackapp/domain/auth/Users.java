package com.clush.clushbackapp.domain.auth;

import com.clush.clushbackapp.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Entity
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users extends BaseTimeEntity {
    @Id
    @Column(name = "users_id")
    private Long usersId;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    public Users(Long usersId, String username, String password, UserRole userRole) {
        this.usersId = usersId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public static Users create(String username, String password) {
        validate(username, password);
        return new Users(1L, username, password, UserRole.BASIC);
    }

    private static void validate(String username, String password) {
        notBlank(username);
        notBlank(password);
        validateUsername(username);
    }

    private static void validateUsername(String username) {
        String regex = "^[a-zA-Z0-9]+$";
        if (!Pattern.matches(regex, username)) throw new IllegalArgumentException("아이디 패턴이 맞지 않습니다");
    }

    private static void notBlank(String text) {
        if (text == null || text.isBlank()) throw new IllegalArgumentException("회원 정보에는 빈 값을 넣을 수 없습니다.");
    }
}
