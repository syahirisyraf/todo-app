package com.syahir.todoapp.service.implemantation;

import com.syahir.todoapp.entity.Date;
import com.syahir.todoapp.repository.DateRepository;
import com.syahir.todoapp.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DateServiceImpl implements DateService {

    @Autowired
    private DateRepository dateRepository;

    @Override
    public Date saveDate(Date date) {
        return dateRepository.save(date);
    }

    @Override
    public List<Date> findAll() {
        return StreamSupport.stream(
                dateRepository.findAll()
                        .spliterator(), false
        ).collect(Collectors.toList());
    }
}
