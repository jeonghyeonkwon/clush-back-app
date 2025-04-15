package com.clush.clushbackapp.domain.todo;

import com.clush.clushbackapp.domain.BaseTimeEntity;
import com.clush.clushbackapp.domain.auth.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_category_id")
    private Long todoCategoryId;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    public TodoCategory(Long todoCategoryId, String title, Users users) {
        this.todoCategoryId = todoCategoryId;
        this.title = title;
        this.users = users;

    }

    private TodoCategory(String title, Users users) {
        this(null, title, users);
        users.getTodoCategories().add(this);
    }

    public static TodoCategory create(String title, Users users) {
        notBlank(title);
        return new TodoCategory(title, users);
    }

    private static void notBlank(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("타이틀은 빈 값을 넣을 수 없습니다");
    }


}
