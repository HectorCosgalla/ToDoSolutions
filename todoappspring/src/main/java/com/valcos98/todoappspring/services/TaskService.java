package com.valcos98.todoappspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.valcos98.todoappspring.models.Task;
import com.valcos98.todoappspring.repositories.TaskRepository;

@Service
public class TaskService {
    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Optional<Task> getById(Long id){
        return taskRepository.findById(id);
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }
}
