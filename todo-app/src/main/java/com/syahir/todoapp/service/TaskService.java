package com.syahir.todoapp.service;

import com.syahir.todoapp.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    boolean isExists(Long id);

    Task createUpdateTask(Long id, Task task);

    Task saveTask(Task task);

    Task partialUpdate(Long id, Task task);

    List<Task> findAll();

    Optional<Task> findById(Long id);

    void deleteById(Long id);

    Page<Task> findAllPagable(Pageable pageable);
}
