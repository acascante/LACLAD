package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.SystemUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/systemusers")
@Controller
@RooWebScaffold(path = "systemusers", formBackingObject = SystemUser.class)
public class SystemUserController {
}
