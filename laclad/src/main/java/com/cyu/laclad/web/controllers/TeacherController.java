package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Direction;
import com.cyu.laclad.domain.Email;
import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.domain.Phone;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.domain.Teacher;
import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.Utils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
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

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/teachers")
@Controller
@RooWebScaffold(path = "teachers", formBackingObject = Teacher.class)
public class TeacherController {
	
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Teacher teacher, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, teacher);
            return "teachers/create";
        }
        uiModel.asMap().clear();

        teacher.getSystemUser().setPassword(Utils.generateRandomPassword());
        teacher.getSystemUser().setType(UserType.ROLE_TEACHER);
        teacher.getSystemUser().setStatus(teacher.getStatus());
    	teacher.setEnroldDate(new Date());
    	
        teacher.persist();
        return "redirect:/teachers/" + encodeUrlPathSegment(teacher.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Teacher());
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
    public String update(@Valid Teacher teacher, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, teacher);
            return "teachers/update";
        }
        
        Teacher oldTeacher = Teacher.findTeacher(teacher.getId());
        teacher.getSystemUser().setPassword(oldTeacher.getSystemUser().getPassword());
        teacher.getSystemUser().setType(UserType.ROLE_TEACHER);
        teacher.getSystemUser().setStatus(teacher.getSystemUser().getStatus());
    	
        uiModel.asMap().clear();
        teacher.merge();
        return "redirect:/teachers/" + encodeUrlPathSegment(teacher.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Teacher.findTeacher(id));
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
        uiModel.addAttribute("teacher_birthday_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("teacher_enrolddate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Teacher teacher) {
        uiModel.addAttribute("teacher", teacher);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("directions", Direction.findAllDirections());
        uiModel.addAttribute("emails", Email.findAllEmails());
        uiModel.addAttribute("idioms", Idiom.findAllIdioms());
        uiModel.addAttribute("phones", Phone.findAllPhones());
        uiModel.addAttribute("systemusers", SystemUser.findAllSystemUsers());
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
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
