package com.syahir.todoapp.repository;

import com.syahir.todoapp.entity.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<Date,Long> {
}
