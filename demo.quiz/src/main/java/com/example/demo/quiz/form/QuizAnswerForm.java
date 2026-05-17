package com.example.demo.quiz.form;

import lombok.Data;

@Data
//1問分の回答を入れるクラスを作成。
public class QuizAnswerForm {
    //問題のid
    private Integer id;
    //回答者の回答
    private Boolean myAnswer;
    //正解・不正解の結果
    private Boolean correct;
	public Integer getId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}