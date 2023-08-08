package com.valcos98.todoappspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valcos98.todoappspring.models.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
    
}
