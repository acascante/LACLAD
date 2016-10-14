package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Student;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasRole('ROLE_TEACHER')")
@RequestMapping("/students")
@Controller
@RooWebScaffold(path = "students", formBackingObject = Student.class)
public class StudentController {
}
