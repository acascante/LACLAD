package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Response;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/responses")
@Controller
@RooWebScaffold(path = "responses", formBackingObject = Response.class)
public class ResponseController {
}
