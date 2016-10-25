package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Email;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/emails")
@Controller
@RooWebScaffold(path = "emails", formBackingObject = Email.class)
public class EmailController {
}
