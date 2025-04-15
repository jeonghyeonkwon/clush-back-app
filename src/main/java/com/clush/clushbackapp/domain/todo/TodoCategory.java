package com.clush.clushbackapp.domain.todo;

import com.clush.clushbackapp.domain.BaseTimeEntity;
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

    public TodoCategory(Long todoCategoryId, String title) {
        this.todoCategoryId = todoCategoryId;
        this.title = title;
    }

    private TodoCategory(String title) {
        this(null, title);
    }

    public static TodoCategory create(String title) {
        notBlank(title);
        return new TodoCategory(title);
    }

    private static void notBlank(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("타이틀은 빈 값을 넣을 수 없습니다");
    }


}
