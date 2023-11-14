package com.syahir.todoapp.service.implemantation;

import com.syahir.todoapp.entity.Task;
import com.syahir.todoapp.repository.TaskRepository;
import com.syahir.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public boolean isExists(Long id) {
        return taskRepository.existsById(id);
    }

    @Override
    public Task createUpdateTask(Long id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task partialUpdate(Long id, Task task) {
        task.setId(id);
        return taskRepository.findById(id).map(existingTask ->{
            Optional.ofNullable(task.getTitle()).ifPresent(existingTask::setTitle);
            Optional.ofNullable(task.getDescription()).ifPresent(existingTask::setDescription);
            Optional.ofNullable(task.getStatus()).ifPresent(existingTask::setStatus);
            return taskRepository.save(existingTask);
        }).orElseThrow(() -> new RuntimeException("Task does not exists"));
    }
}
