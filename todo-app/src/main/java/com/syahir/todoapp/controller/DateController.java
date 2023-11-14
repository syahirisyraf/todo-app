package com.syahir.todoapp.controller;

import com.syahir.todoapp.dto.DateDto;
import com.syahir.todoapp.entity.Date;
import com.syahir.todoapp.mapper.Mapper;
import com.syahir.todoapp.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/date")
public class DateController {

    @Autowired
    private DateService dateService;
    @Autowired
    private Mapper<Date, DateDto> dateMapper;

    // Create Date
    @PostMapping
    public ResponseEntity<DateDto> createDate(@RequestBody DateDto dateDto){

        Date date = dateMapper.mapFrom(dateDto);
        Date saveDate = dateService.saveDate(date);
        return new ResponseEntity<>(dateMapper.mapTo(saveDate), HttpStatus.CREATED);
    }

    // Get all Date
    @GetMapping
    public List<DateDto> listDate(){
        List<Date> dates = dateService.findAll();
        return dates.stream()
                .map(dateMapper::mapTo)
                .collect(Collectors.toList());
    }


}
