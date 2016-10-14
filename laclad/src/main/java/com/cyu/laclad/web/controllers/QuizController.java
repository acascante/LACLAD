package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Quiz;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/quizes")
@Controller
@RooWebScaffold(path = "quizes", formBackingObject = Quiz.class)
public class QuizController {
}
