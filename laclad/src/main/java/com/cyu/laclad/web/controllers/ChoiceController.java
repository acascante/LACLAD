package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Choice;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/choices")
@Controller
@RooWebScaffold(path = "choices", formBackingObject = Choice.class)
public class ChoiceController {
}
