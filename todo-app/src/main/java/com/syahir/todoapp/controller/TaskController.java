package com.syahir.todoapp.controller;

import com.syahir.todoapp.dto.TaskDto;
import com.syahir.todoapp.entity.Task;
import com.syahir.todoapp.exception.ResourceNotFoundException;
import com.syahir.todoapp.mapper.Mapper;
import com.syahir.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // Update task
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

    // partial update task
    @PatchMapping("/{id}")
    public ResponseEntity<TaskDto> partialUpdateBook(@PathVariable("id") Long id, @RequestBody TaskDto taskDto){
        if(!taskService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Task task = taskMapper.mapFrom(taskDto);
        Task updatedTask = taskService.partialUpdate(id, task);
        return new ResponseEntity<>(taskMapper.mapTo(updatedTask), HttpStatus.OK);
    }

    // get all task
    @GetMapping
    public List<TaskDto> listTasks(){
        List<Task> tasks = taskService.findAll();
        return tasks.stream()
                .map(taskMapper::mapTo)
                .collect(Collectors.toList());
    }

    // get task by id
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long id){

        // without exception handling
//        Optional<Task> foundTask = taskService.findById(id);
//        return foundTask.map(task -> {
//            TaskDto taskDto = taskMapper.mapTo(task);
//            return new ResponseEntity<>(taskDto, HttpStatus.OK);
//        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

//        Optional<Task> foundTask = taskService.findById(id);
//        if(!foundTask.isPresent()){
//            throw new RuntimeException(String.format("Task with ID %s not found", id));
//        }
//        return

        // with exception handling
        Optional<Task> foundTask = taskService.findById(id);
        return foundTask.map(task -> {
            TaskDto taskDto = taskMapper.mapTo(task);
            return new ResponseEntity<>(taskDto, HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException(String.format("Task with ID %s not found", id)));

    }

    // delete task by id
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteTask(@PathVariable("id") Long id){
//        taskService.deleteById(id);
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> deleteTaskById(@PathVariable("id") Long id){
        Optional<Task> foundTask = taskService.findById(id);
        if (!foundTask.isPresent()){
            throw new ResourceNotFoundException(String.format("Task with Id %s not found and cannot be deleted", id));
        }else {
            taskService.deleteById(id);
            return new ResponseEntity("Task with Id " + id +  " successfully delete",HttpStatus.NOT_FOUND);
        }
    }

}
