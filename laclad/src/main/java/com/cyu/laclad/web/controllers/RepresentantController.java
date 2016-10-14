package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Representant;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/representants")
@Controller
@RooWebScaffold(path = "representants", formBackingObject = Representant.class)
public class RepresentantController {
}
