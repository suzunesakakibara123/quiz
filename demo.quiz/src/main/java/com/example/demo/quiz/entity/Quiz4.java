package com.example.demo.quiz.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("quiz4")
public class Quiz4 {

    @Id
    private Integer id;

    private String question;

    private String choice1;

    private String choice2;

    private String choice3;

    private String choice4;

    private Integer answer;

    private String explanation;
    
    private String author;
}