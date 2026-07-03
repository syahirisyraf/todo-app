package com.syahir.todoapp.repository;

import com.syahir.todoapp.entity.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DateRepository extends JpaRepository<Date,Long> {
    List<Date> findByStartDate(LocalDate startDate);
}
