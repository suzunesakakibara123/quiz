package com.example.demo.quiz.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.quiz.entity.Quiz4;

public interface Quiz4Repository extends CrudRepository<Quiz4, Integer> {

    @Query("SELECT * FROM quiz4 ORDER BY RANDOM() LIMIT 1")
    Quiz4 findRandomQuiz4();
}