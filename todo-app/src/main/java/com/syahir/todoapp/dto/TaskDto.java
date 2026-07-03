package com.syahir.todoapp.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.syahir.todoapp.entity.Date;
import com.syahir.todoapp.entity.TaskStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    @JsonBackReference
    private DateDto date;
}
