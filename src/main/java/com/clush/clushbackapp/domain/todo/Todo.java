package com.clush.clushbackapp.domain.todo;

import com.clush.clushbackapp.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo extends BaseTimeEntity {

    @Id
    @Column(name = "todo_id")
    private Long todoId;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TodoStatus todoStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private TodoPriority todoPriority;

    public Todo(Long todoId, String title, String content, TodoStatus todoStatus, TodoPriority todoPriority) {
        this.todoId = todoId;
        this.title = title;
        this.content = content;
        this.todoStatus = todoStatus;
        this.todoPriority = todoPriority;
    }

    public static Todo create(String title, String content, TodoStatus todoStatus, TodoPriority todoPriority) {
        validate(title, content);
        return new Todo(1L, title, content, todoStatus, todoPriority);

    }

    private static void validate(String title, String content) {
        notBlank(title);
        notBlank(content);
    }

    private static void notBlank(String text) {
        if (text == null || text.isBlank()) throw new IllegalArgumentException("빈 값을 넣을 수 없습니다.");
    }
}
