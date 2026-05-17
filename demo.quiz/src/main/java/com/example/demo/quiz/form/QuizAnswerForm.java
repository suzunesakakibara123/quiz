package com.example.demo.quiz.form;

import lombok.Data;

@Data
public class QuizAnswerForm {

    // 問題のid
    private Integer id;

    // 回答者の回答
    private Boolean myAnswer;

    // 正解・不正解の結果
    private Boolean correct;
}