package com.syahir.todoapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_sequence")
    private Long id;

    @NotBlank(message = "Title may not be blank")
    private String title;

    @NotBlank(message = "description may not be blank")
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "date_id")
    private Date date;

}
