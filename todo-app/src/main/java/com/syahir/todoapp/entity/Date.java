package com.syahir.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.List;


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

    //private LocalTime utilTime = LocalTime.now();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "date", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> task;
}

//    @Temporal(TemporalType.DATE)
//    private java.util.Date startDate = new java.util.Date() ;
//
//    @Temporal(TemporalType.TIME)
//    private java.util.Date utilTime = new java.util.Date();
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private java.util.Date utilTimeStamp = new java.util.Date();
