package com.syahir.todoapp.mapper;

import com.syahir.todoapp.dto.TaskDto;
import com.syahir.todoapp.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements Mapper<Task, TaskDto> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TaskDto mapTo(Task task) {
        return modelMapper.map(task,TaskDto.class);
    }

    @Override
    public Task mapFrom(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }
}
