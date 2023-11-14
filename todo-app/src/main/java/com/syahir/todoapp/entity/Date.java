package com.syahir.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
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

    private LocalDate startDate = LocalDate.now();

    private LocalTime utilTime = LocalTime.now();

//    @Temporal(TemporalType.DATE)
//    private java.util.Date startDate = new java.util.Date() ;
//
//    @Temporal(TemporalType.TIME)
//    private java.util.Date utilTime = new java.util.Date();
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private java.util.Date utilTimeStamp = new java.util.Date();

}
