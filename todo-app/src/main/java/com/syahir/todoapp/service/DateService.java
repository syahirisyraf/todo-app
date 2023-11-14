package com.syahir.todoapp.service;

import com.syahir.todoapp.entity.Date;

import java.util.List;
import java.util.Optional;

public interface DateService {
    Date saveDate(Date date);

    List<Date> findAll();

    Optional<Date> findById(Long id);
}
