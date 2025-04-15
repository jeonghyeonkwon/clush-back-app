package com.clush.clushbackapp.repository;

import com.clush.clushbackapp.domain.todo.TodoCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoCategoryRepository extends JpaRepository<TodoCategory, Long> {

    @Query("SELECT c FROM TodoCategory c JOIN FETCH c.users u WHERE c.todoCategoryId = :todoCategoryId AND u.usersId = :usersId")
    Optional<TodoCategory> findByUsersIdAndTodoCategoryId(@Param("usersId") Long usersId, @Param("todoCategoryId") Long todoCategoryId);

}
