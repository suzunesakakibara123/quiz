package com.example.demo.quiz.service;

import java.util.Optional;

import com.example.demo.quiz.entity.Quiz;

/*Quizサービス処理：Servicw*/
public interface QuizService {
    /*クイズの情報を全件取得する*/
	Iterable<Quiz> selectAll();
	/**クイズ情報をidをキーにして1件取得する*/
	Optional<Quiz> selectOneById(Integer id);
	/**クイズ情報をランダムに1件取得する*/
	Optional<Quiz> selectOneRandomQuiz();
	/**クイズの正解・不正解を判定する*/
	Boolean checkQuiz(Integer id, Boolean myAnswer);
	/**クイズを登録する*/
	void insertQuiz(Quiz quiz);
	/**クイズを更新する*/
	void updateQuiz(Quiz quiz);
	/**クイズを削除する*/
	void deleteQuizById(Integer id);
	
}
