package com.valcos98.todoappspring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.valcos98.todoappspring.models.Task;
import com.valcos98.todoappspring.services.TaskService;


@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @GetMapping("/")
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAll();
        List<Task> finishedTasks = new ArrayList<Task>();
        List<Task> unfinishedTasks = new ArrayList<Task>();
        if (tasks.size()>0) {
            for (Task task : tasks) {
                if (task.getIsItDone()) {
                    finishedTasks.add(task);
                }else{
                    unfinishedTasks.add(task);
                }
            }
            model.addAttribute("unfinishedtasks", unfinishedTasks);
            model.addAttribute("finishedtasks", finishedTasks);
        }
        return "index";
    }

    @GetMapping("/new")
    public String newTask(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "new_task";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute Task task){
        if (!task.getTitle().equals("")) {
            taskService.saveTask(task);
        }
        return "redirect:/";
    }

    @GetMapping("/taskdone/{id}")
    public String taskDone(@PathVariable Long id){
        Optional<Task> optionalTask = taskService.getById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setIsItDone(true);
            taskService.saveTask(task);
        }
        return "redirect:/";
    }
}
