package com.clush.clushbackapp.domain.todo;

import com.clush.clushbackapp.domain.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoCategory extends BaseTimeEntity {
    @Id
    @Column(name = "todo_category_id")
    private Long todoCategoryId;

    private String title;

    public TodoCategory(Long todoCategoryId, String title) {
        this.todoCategoryId = todoCategoryId;
        this.title = title;
    }

    public static TodoCategory create(String title) {
        notBlank(title);
        return new TodoCategory(1L, title);
    }

    private static void notBlank(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("타이틀은 빈 값을 넣을 수 없습니다");
    }


}
