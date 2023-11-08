package com.syahir.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Dates")
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Date_id_sequence")
    private Long id;

    @NotBlank(message = "Start date may not be blank")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotBlank(message = "Start time may not be blank")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
}
