package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Idiom;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/idioms")
@Controller
@RooWebScaffold(path = "idioms", formBackingObject = Idiom.class)
public class IdiomController {
}
