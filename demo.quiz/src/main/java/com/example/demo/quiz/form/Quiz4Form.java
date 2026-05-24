package com.example.demo.quiz.form;

import lombok.Data;

@Data
public class Quiz4Form {

    private Integer id;

    private String question;

    private String choice1;

    private String choice2;

    private String choice3;

    private String choice4;

    private Integer correctAnswer;

    private String author;

    private Boolean newQuizChoice;
}