package com.example.demo.quiz.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.quiz.entity.Quiz4;
import com.example.demo.quiz.service.Quiz4Service;

@Controller
@RequestMapping("/quiz4")
public class Quiz4Controller {

    @Autowired
    Quiz4Service service;

    @GetMapping("/play4")
    public String showPlay(Model model) {

        Quiz4 quiz4 = service.selectOneRandomQuiz4();

        if (quiz4 == null) {
            model.addAttribute("msg", "問題がありません。");
            return "quiz4/play4";
        }

        model.addAttribute("quiz4", quiz4);

        return "quiz4/play4";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("quiz4", new Quiz4());

        return "quiz4/crud4";
    }

    @PostMapping("/insert")
    public String insertQuiz4(@ModelAttribute Quiz4 quiz4) {

        service.insertQuiz4(quiz4);

        return "redirect:/quiz4/play4";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Integer id,
            Model model) {

        Optional<Quiz4> quiz4Opt = service.selectOneById(id);

        if (quiz4Opt.isPresent()) {
            model.addAttribute("quiz4", quiz4Opt.get());
            return "quiz4/crud4";
        }

        return "redirect:/quiz4/play4";
    }

    @PostMapping("/update")
    public String updateQuiz4(@ModelAttribute Quiz4 quiz4) {

        service.updateQuiz4(quiz4);

        return "redirect:/quiz4/play4";
    }

    @PostMapping("/delete/{id}")
    public String deleteQuiz4(@PathVariable Integer id) {

        service.deleteQuiz4ById(id);

        return "redirect:/quiz4/play4";
    }

    @PostMapping("/result")
    public String showResult(
            Integer id,
            Integer myAnswer,
            Model model) {

        Boolean result = service.checkQuiz4(id, myAnswer);

        Optional<Quiz4> quiz4Opt = service.selectOneById(id);

        if (quiz4Opt.isPresent()) {
            model.addAttribute("quiz4", quiz4Opt.get());
        }

        model.addAttribute("result", result);
        model.addAttribute("myAnswer", myAnswer);

        return "quiz4/result4";
    }
}