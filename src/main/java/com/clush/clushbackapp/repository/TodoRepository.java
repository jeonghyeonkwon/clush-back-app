package com.clush.clushbackapp.repository;

import com.clush.clushbackapp.domain.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
