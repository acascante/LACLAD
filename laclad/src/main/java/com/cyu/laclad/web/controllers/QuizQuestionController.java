package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.QuizQuestion;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/quizquestions")
@Controller
@RooWebScaffold(path = "quizquestions", formBackingObject = QuizQuestion.class)
public class QuizQuestionController {
}
