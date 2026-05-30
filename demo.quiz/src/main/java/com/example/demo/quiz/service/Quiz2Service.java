package com.example.demo.quiz.service;

import java.util.Optional;

import com.example.demo.quiz.entity.Quiz2;

/* Quizサービス処理：Service */
public interface Quiz2Service {

    /* クイズの情報を全件取得する */
    Iterable<Quiz2> selectAllQuiz2();

    /** クイズ情報をidをキーにして1件取得する */
    Optional<Quiz2> selectOneById(Integer id);

    /** クイズ情報をランダムに1件取得する */
    Optional<Quiz2> selectOneRandomQuiz2();

    /** クイズの正解・不正解を判定する */
    Boolean checkQuiz(Integer id, Boolean myAnswer);

    /** クイズを登録する */
    void insertQuiz(Quiz2 quiz2);

    /** クイズを更新する */
    void updateQuiz(Quiz2 quiz2);

    /** クイズを削除する */
    void deleteQuizById(Integer id);

    /** クイズをランダムに10件取得する */
    Iterable<Quiz2> findRandom10Quiz2();
}