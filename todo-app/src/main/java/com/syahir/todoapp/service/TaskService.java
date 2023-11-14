package com.syahir.todoapp.service;

import com.syahir.todoapp.entity.Task;

public interface TaskService {
    boolean isExists(Long id);

    Task createUpdateTask(Long id, Task task);

    Task saveTask(Task task);
}
