package com.example.demo.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.quiz.entity.Quiz;
import com.example.demo.quiz.repository.QuizRepository;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
   /**Repositoryの注入*/
	@Autowired
	QuizRepository repository;
	@Override
	public Iterable<Quiz> selectAll() {
		return repository.findAll();
	}
	@Override
	public Optional<Quiz> selectOneById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findById(id);
	}

	@Override
	public Optional<Quiz> selectOneRandomQuiz() {
		//ランダムでidの値を取得する
		Integer randId = repository.getRandomId();
		//問題が無い場合
		if(randId == null) {
			return Optional.empty();
		}
		// TODO 自動生成されたメソッド・スタブ
		return repository.findById(randId);
	}
	

	@Override
	public Boolean checkQuiz(Integer id, Boolean myAnswer) {
		Boolean check = false;
		Optional<Quiz> optQuiz = repository.findById(id);
		if(optQuiz.isPresent()) {
			Quiz quiz = optQuiz.get();
			if(quiz.getAnswer().equals(myAnswer)) {
				check = true;
			}
		}
		// TODO 自動生成されたメソッド・スタブ
		return check;
	}

	@Override
	public void insertQuiz(Quiz quiz) {
		// TODO 自動生成されたメソッド・スタブ
		repository.save(quiz);

	}

	@Override
	public void updateQuiz(Quiz quiz) {
		// TODO 自動生成されたメソッド・スタブ
        repository.save(quiz);
	}

	@Override
	public void deleteQuizById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
  	  repository.deleteById(id);
	}

}
