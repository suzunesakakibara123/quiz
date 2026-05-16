package com.example.demo.quiz.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
	/*識別ID*/
	@Id
	public Integer id;
	/*クイズの問題文*/
	public String question;
	/*クイズのの答え*/
	public Boolean answer;
	/*作成者*/
	public String author;
}
