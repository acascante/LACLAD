package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Quiz;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasRole('ROLE_TEACHER')")
@RequestMapping("/quizes")
@Controller
@RooWebScaffold(path = "quizes", formBackingObject = Quiz.class)
public class QuizController {
}
