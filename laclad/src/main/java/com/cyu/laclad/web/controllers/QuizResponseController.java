package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.QuizResponse;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/quizresponses")
@Controller
@RooWebScaffold(path = "quizresponses", formBackingObject = QuizResponse.class)
public class QuizResponseController {
}
