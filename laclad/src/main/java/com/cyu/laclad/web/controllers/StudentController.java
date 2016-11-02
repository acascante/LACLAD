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
import com.cyu.laclad.domain.ClassGroup;
import com.cyu.laclad.domain.Student;
import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.utils.Utils;
import com.cyu.laclad.web.commands.StudentCommand;

@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TEACHER')")
@RequestMapping("/students")
@Controller
@RooWebScaffold(path = "students", formBackingObject = Student.class)
public class StudentController {

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid StudentCommand studentCommand, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        Student student = studentCommand.initStudent();
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, studentCommand);
            return "students/create";
        }
        uiModel.asMap().clear();
        student.persist();
        Utils.sendEmail(student.getSystemUser().getUserName(), student.getName() + " " + student.getLastName(), student.getSystemUser().getPassword());
        return "redirect:/students/" + encodeUrlPathSegment(student.getId().toString(), httpServletRequest);
    }

    @RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new StudentCommand());
        return "students/create";
    }

    @RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("student", Student.findStudent(id));
        uiModel.addAttribute("itemId", id);
        return "students/show";
    }

    @RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("students", Student.findStudentEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Student.countStudents() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("students", Student.findAllStudents(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "students/list";
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid StudentCommand studentCommand, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        Student student = Student.findStudent(studentCommand.getId());
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, studentCommand);
            return "students/update";
        }
        student.updateStudent(studentCommand);
        uiModel.asMap().clear();
        student.merge();
        return "redirect:/students/" + encodeUrlPathSegment(student.getId().toString(), httpServletRequest);
    }

    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        Student student = Student.findStudent(id);
        populateEditForm(uiModel, new StudentCommand(student));
        return "students/update";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Student student = Student.findStudent(id);
        student.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/students";
    }

    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("student_birthday_date_pattern", "dd-MM-yyyy");
    }

    void populateEditForm(Model uiModel, StudentCommand student) {
        uiModel.addAttribute("student", student);
        addDateTimeFormatPatterns(uiModel);
        //	        uiModel.addAttribute("directions", Direction.findAllDirections());
        //	      uiModel.addAttribute("phones", Phone.findAllPhones());
        uiModel.addAttribute("classgroups", ClassGroup.findAllClassGroups());
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
