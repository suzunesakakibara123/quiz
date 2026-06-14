package com.example.demo.quiz.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("quiz2")
public class Quiz2 {
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
