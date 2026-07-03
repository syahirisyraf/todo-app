package com.syahir.todoapp.mapper;

import com.syahir.todoapp.dto.DateDto;
import com.syahir.todoapp.entity.Date;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateMapperImpl implements Mapper<Date, DateDto> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DateDto mapTo(Date date) {
        return modelMapper.map(date, DateDto.class);
    }

    @Override
    public Date mapFrom(DateDto dateDto) {
        return modelMapper.map(dateDto, Date.class);
    }
}
