package com.aldob.app.RestAPI.controller;

import com.aldob.app.RestAPI.model.Task;
import com.aldob.app.RestAPI.repository.toDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class toDoController {
    @Autowired
    private toDoRepository toDoRepository;

    @GetMapping(value = "/")
    public String information(){
        return "Welcome to the API";
    }

    @GetMapping(value= "/tasks")
    public List<Task> getTasks(){

        return toDoRepository.findAll();
    }

    @PostMapping(value="/savetask")
    public String saveTask(@RequestBody Task task) {
        if (task.getName().isEmpty() && task.getDescription().isEmpty()) {
            return "Name and description are required";
        } else if (task.getName().isEmpty()) {
            return "Name is required";
        } else if (task.getDescription().isEmpty()) {
            return "Description is required";
        } else {
            toDoRepository.save(task);
            return "Saved task";
        }
    }


    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){

        if(task.getName().isEmpty() && task.getDescription().isEmpty()) {
            return "Name and description are required";
        } else if(task.getName().isEmpty()) {
            return "Name is required";
        } else if(task.getDescription().isEmpty()) {
            return "Description is required";
        }else{
            Task updateTask = toDoRepository.findById(id).get();
            updateTask.setName(task.getName());
            updateTask.setDescription(task.getDescription());
            toDoRepository.save(updateTask);
            return "Updated task";
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteTask(@PathVariable long id , @RequestBody Task task){
        Task deleteTask = toDoRepository.findById(id).get();
        toDoRepository.delete(deleteTask);
        return "Deleted task";
    }




}




