package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Direction;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/directions")
@Controller
@RooWebScaffold(path = "directions", formBackingObject = Direction.class)
public class DirectionController {
}
