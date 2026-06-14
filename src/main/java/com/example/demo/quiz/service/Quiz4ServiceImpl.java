package com.example.demo.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.quiz.entity.Quiz4;
import com.example.demo.quiz.repository.Quiz4Repository;

@Service
public class Quiz4ServiceImpl implements Quiz4Service {

    @Autowired
    Quiz4Repository repository;

    @Override
    public Iterable<Quiz4> selectAllQuiz4() {
        return repository.findAll();
    }

    @Override
    public Optional<Quiz4> selectOneById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Quiz4 selectOneRandomQuiz4() {
        return repository.findRandomQuiz4();
    }

    @Override
    public Boolean checkQuiz4(Integer id, Integer myAnswer) {
        Optional<Quiz4> quiz4Opt = repository.findById(id);

        if (quiz4Opt.isPresent()) {
            Quiz4 quiz4 = quiz4Opt.get();
            return quiz4.getAnswer().equals(myAnswer);
        }

        return false;
    }

    @Override
    public void insertQuiz4(Quiz4 quiz4) {
        repository.save(quiz4);
    }

    @Override
    public void updateQuiz4(Quiz4 quiz4) {
        repository.save(quiz4);
    }

    @Override
    public void deleteQuiz4ById(Integer id) {
        repository.deleteById(id);
    }
}