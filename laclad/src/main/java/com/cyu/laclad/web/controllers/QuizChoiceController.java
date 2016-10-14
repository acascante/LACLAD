package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.QuizChoice;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/quizchoices")
@Controller
@RooWebScaffold(path = "quizchoices", formBackingObject = QuizChoice.class)
public class QuizChoiceController {
}
