package com.example.demo.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    /**
     * クイズメニュー画面を表示する
     */
    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }

    /**
     * 2択問題メニュー画面を表示する
     */
    @GetMapping("/menu/quiz2")
    public String showQuiz2Menu() {
        return "quiz2/menu2";
    }

    /**
     * 2択問題を1問ずつプレイする画面へ移動する
     */
    @GetMapping("/menu/quiz2/play2")
    public String redirectToQuiz2Play() {
        return "redirect:/quiz2/play2";
    }

    /**
     * 2択問題を10問ずつプレイする画面へ移動する
     */
    @GetMapping("/menu/quiz2/play10")
    public String redirectToQuiz2Play10() {
        return "redirect:/quiz2/play10";
    }

    /**
     * 2択問題を1問ずつ登録する画面へ移動する
     */
    @GetMapping("/menu/quiz2/quiz")
    public String redirectToQuiz2Crud() {
        return "redirect:/quiz2";
    }

    /**
     * 2択問題CSV登録画面へ移動する
     */
    @GetMapping("/menu/quiz2/csv-upload")
    public String redirectToQuiz2CsvUpload() {
        return "redirect:/quiz2/csv-upload2";
    }

    /**
     * 4択問題メニュー画面を表示する
     */
    @GetMapping("/menu/quiz4")
    public String showQuiz4Menu() {
        return "quiz4/menu4";
    }
}