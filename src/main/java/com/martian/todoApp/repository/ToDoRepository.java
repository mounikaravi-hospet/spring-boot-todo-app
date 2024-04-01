package com.martian.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.martian.todoApp.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

}
