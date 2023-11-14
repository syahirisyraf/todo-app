package com.syahir.todoapp.service.implemantation;

import com.syahir.todoapp.entity.Date;
import com.syahir.todoapp.repository.DateRepository;
import com.syahir.todoapp.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateServiceImpl implements DateService {

    @Autowired
    private DateRepository dateRepository;

    @Override
    public Date saveDate(Date date) {
        return dateRepository.save(date);
    }
}
