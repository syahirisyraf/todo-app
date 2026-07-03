package com.syahir.todoapp.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateDto {
    private Long id;
    private LocalDate startDate = LocalDate.now();
    //private LocalTime utilTime = LocalTime.now();
    @JsonManagedReference
    private List<TaskDto> task;
}
