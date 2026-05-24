package com.example.demo.quiz.service;

import java.util.Optional;

import com.example.demo.quiz.entity.Quiz4;

public interface Quiz4Service {

    Iterable<Quiz4> selectAllQuiz4();

    Optional<Quiz4> selectOneById(Integer id);

    Quiz4 selectOneRandomQuiz4();

    Boolean checkQuiz4(Integer id, Integer myAnswer);

    void insertQuiz4(Quiz4 quiz4);

    void updateQuiz4(Quiz4 quiz4);

    void deleteQuiz4ById(Integer id);
}