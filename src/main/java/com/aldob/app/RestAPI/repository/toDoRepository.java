package com.aldob.app.RestAPI.repository;

import com.aldob.app.RestAPI.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface toDoRepository extends JpaRepository<Task, Long> {



}
