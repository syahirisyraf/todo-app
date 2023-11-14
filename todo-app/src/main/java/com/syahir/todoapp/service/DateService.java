package com.syahir.todoapp.service;

import com.syahir.todoapp.entity.Date;

import java.util.List;

public interface DateService {
    Date saveDate(Date date);

    List<Date> findAll();
}
