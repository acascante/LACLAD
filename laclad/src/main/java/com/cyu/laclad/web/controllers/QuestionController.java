package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Question;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/questions")
@Controller
@RooWebScaffold(path = "questions", formBackingObject = Question.class)
public class QuestionController {
}
