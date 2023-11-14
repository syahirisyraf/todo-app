package com.syahir.todoapp.controller;

import com.syahir.todoapp.dto.DateDto;
import com.syahir.todoapp.entity.Date;
import com.syahir.todoapp.mapper.Mapper;
import com.syahir.todoapp.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/date")
public class DateController {

    @Autowired
    private DateService dateService;
    @Autowired
    private Mapper<Date, DateDto> dateMapper;

    @PostMapping
    public ResponseEntity<DateDto> createDate(@RequestBody DateDto dateDto){

        Date date = dateMapper.mapFrom(dateDto);
        Date saveDate = dateService.saveDate(date);
        return new ResponseEntity<>(dateMapper.mapTo(saveDate), HttpStatus.CREATED);
    }

    
}
