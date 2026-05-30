package com.example.demo.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.quiz.entity.Quiz2;
import com.example.demo.quiz.repository.Quiz2Repository;

@Service
@Transactional
public class Quiz2ServiceImpl implements Quiz2Service {

    /** Repositoryの注入 */
    @Autowired
    Quiz2Repository repository;

    @Override
    public Iterable<Quiz2> selectAllQuiz2() {
        return repository.findAll();
    }

    @Override
    public Optional<Quiz2> selectOneById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Quiz2> selectOneRandomQuiz2() {

        // ランダムでidの値を取得する
        Integer randId = repository.getRandomId();

        // 問題が無い場合
        if (randId == null) {
            return Optional.empty();
        }

        return repository.findById(randId);
    }

    @Override
    public Boolean checkQuiz(Integer id, Boolean myAnswer) {

        Boolean check = false;

        Optional<Quiz2> quiz2Opt = repository.findById(id);

        if (quiz2Opt.isPresent()) {
            Quiz2 quiz2 = quiz2Opt.get();

            if (quiz2.getAnswer().equals(myAnswer)) {
                check = true;
            }
        }

        return check;
    }

    @Override
    public void insertQuiz(Quiz2 quiz2) {
        repository.save(quiz2
        		);
    }

    @Override
    public void updateQuiz(Quiz2 quiz2) {
        repository.save(quiz2);
    }

    @Override
    public void deleteQuizById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Quiz2> findRandom10Quiz2() {
        return repository.findRandom10Quiz2();
    }
}