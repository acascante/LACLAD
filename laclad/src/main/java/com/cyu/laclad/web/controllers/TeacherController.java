package com.cyu.laclad.web.controllers;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.domain.Teacher;
import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.utils.Utils;
import com.cyu.laclad.web.commands.TeacherCommand;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/teachers")
@Controller
@RooWebScaffold(path = "teachers", formBackingObject = Teacher.class, update=false)
public class TeacherController {

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid TeacherCommand teacherCommand, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	Teacher teacher = teacherCommand.initTeacher();
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, teacherCommand);
            return "teachers/create";
        }
        uiModel.asMap().clear();
       	teacher.persist();
        Utils.sendEmail(teacher.getSystemUser().getUserName(), teacher.getName() + " " + teacher.getLastName(), teacher.getSystemUser().getPassword());
        return "redirect:/teachers/" + encodeUrlPathSegment(teacher.getId().toString(), httpServletRequest);
    }

    @RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new TeacherCommand());
        return "teachers/create";
    }

    @RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("teacher", Teacher.findTeacher(id));
        uiModel.addAttribute("itemId", id);
        return "teachers/show";
    }

    @RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("teachers", Teacher.findTeacherEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Teacher.countTeachers() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("teachers", Teacher.findAllTeachers(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "teachers/list";
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid TeacherCommand teacherCommand, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	Teacher teacher = Teacher.findTeacher(teacherCommand.getId());
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, teacherCommand);
            return "teachers/update";
        }
        teacher.updateTeacher(teacherCommand);
        uiModel.asMap().clear();
        teacher.merge();
        return "redirect:/teachers/" + encodeUrlPathSegment(teacher.getId().toString(), httpServletRequest);
    }

    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
    	Teacher teacher = Teacher.findTeacher(id);
        populateEditForm(uiModel, new TeacherCommand(teacher));
        return "teachers/update";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Teacher teacher = Teacher.findTeacher(id);
        teacher.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/teachers";
    }

    void addDateTimeFormatPatterns(Model uiModel) {
    	uiModel.addAttribute("admin_birthday_date_pattern", "dd-MM-yyyy");
    }

    void populateEditForm(Model uiModel, TeacherCommand teacher) {
        uiModel.addAttribute("teacher", teacher);
        addDateTimeFormatPatterns(uiModel);
//        uiModel.addAttribute("directions", Direction.findAllDirections());
//      uiModel.addAttribute("phones", Phone.findAllPhones());
        uiModel.addAttribute("idioms", Idiom.findAllIdioms());
        uiModel.addAttribute("genders", Arrays.asList(Gender.values()));
        uiModel.addAttribute("statuses", Arrays.asList(Status.values()));
    }

    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {
        }
        return pathSegment;
    }
}
