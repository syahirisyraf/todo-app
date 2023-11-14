package com.syahir.todoapp.controller;

import com.syahir.todoapp.dto.TaskDto;
import com.syahir.todoapp.entity.Task;
import com.syahir.todoapp.mapper.Mapper;
import com.syahir.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private Mapper<Task, TaskDto> taskMapper;
    @Autowired
    private TaskService taskService;

    // Create task
    @PostMapping
    public ResponseEntity<TaskDto> createUpdateTask(@RequestBody TaskDto taskDto){
            Task task = taskMapper.mapFrom(taskDto);
            Task saveTask = taskService.saveTask(task);
            return new ResponseEntity<>(taskMapper.mapTo(saveTask), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> createUpdateTask(@PathVariable("id") Long id, @RequestBody TaskDto taskDto){
        Task task = taskMapper.mapFrom(taskDto);
        boolean taskExists = taskService.isExists(id);
        Task saveTask = taskService.createUpdateTask(id, task);
        TaskDto savedTaskDto = taskMapper.mapTo(saveTask);

        if (taskExists){
            // update
            return new ResponseEntity<>(savedTaskDto, HttpStatus.OK);
        }else {
            // create new
            return new ResponseEntity<>(savedTaskDto, HttpStatus.CREATED);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDto> partialUpdateBook(@PathVariable("id") Long id, @RequestBody TaskDto taskDto){
        if(!taskService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Task task = taskMapper.mapFrom(taskDto);
        Task updatedTask = taskService.partialUpdate(id, task);
        return new ResponseEntity<>(taskMapper.mapTo(updatedTask), HttpStatus.OK);
    }

}
