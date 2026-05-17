package com.example.demo.quiz.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.quiz.entity.Quiz;

/*Quizテーブル：RepositoryImpl*/
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    
	//2択クイズを1問ランダムで取得する。
	@Query("SELECT id FROM quiz ORDER BY RANDOM() LIMIT 1")
	Integer getRandomId();
	
	//2択クイズを10問ランダムで取得する。
	@Query("SELECT * FROM quiz ORDER BY RANDOM() LIMIT 10")
	Iterable<Quiz> findRandom10Quiz();

}
