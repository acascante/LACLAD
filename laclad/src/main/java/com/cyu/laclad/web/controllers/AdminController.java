package com.cyu.laclad.web.controllers;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

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

import com.cyu.laclad.domain.Admin;
import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.web.commands.AdminCommand;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admins")
@Controller
@RooWebScaffold(path = "admins", formBackingObject = Admin.class)
public class AdminController {


	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid AdminCommand adminCommand, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	Admin admin = adminCommand.initAdmin();
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, adminCommand);
            return "admins/create";
        }
        uiModel.asMap().clear();
        admin.persist();
        //Utils.sendEmail(admin.getSystemUser().getUserName(), admin.getName() + " " + admin.getLastName(), admin.getSystemUser().getPassword());
        return "redirect:/admins/" + encodeUrlPathSegment(admin.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new AdminCommand());
        return "admins/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("admin", Admin.findAdmin(id));
        uiModel.addAttribute("itemId", id);
        return "admins/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("admins", Admin.findAdminEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Admin.countAdmins() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("admins", Admin.findAllAdmins(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "admins/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid AdminCommand adminCommand, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	Admin admin = Admin.findAdmin(adminCommand.getId());
    	if(!admin.equals(adminCommand)) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, adminCommand);
	            return "admins/update";
	        }
    		admin.updateAdmin(adminCommand);
	        uiModel.asMap().clear();
	        admin.merge();
    	}
        return "redirect:/admins/" + encodeUrlPathSegment(admin.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
    	Admin admin = Admin.findAdmin(id);
    	
        populateEditForm(uiModel, new AdminCommand(admin));
        return "admins/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Admin admin = Admin.findAdmin(id);
        admin.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/admins";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
		uiModel.addAttribute("admin_birthday_date_pattern", "dd-MM-yyyy");
		uiModel.addAttribute("admin_birthday_date_format", DateTimeFormat.patternForStyle("S-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("admin_enrolddate_date_format", DateTimeFormat.patternForStyle("S-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, AdminCommand admin) {
        uiModel.addAttribute("admin", admin);
        addDateTimeFormatPatterns(uiModel);
        //uiModel.addAttribute("directions", Direction.findAllDirections());
        //uiModel.addAttribute("emails", Email.findAllEmails());
        //uiModel.addAttribute("phones", Phone.findAllPhones());
        //uiModel.addAttribute("systemusers", SystemUser.findAllSystemUsers());
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