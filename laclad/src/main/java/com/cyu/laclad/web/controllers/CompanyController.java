package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Company;
import com.cyu.laclad.domain.Direction;
import com.cyu.laclad.domain.Phone;
import com.cyu.laclad.domain.Representant;
import com.cyu.laclad.enums.Status;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/companys")
@Controller
@RooWebScaffold(path = "companys", formBackingObject = Company.class)
public class CompanyController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Company company, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, company);
            return "companys/create";
        }
        uiModel.asMap().clear();
        company.persist();
        return "redirect:/companys/" + encodeUrlPathSegment(company.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Company());
        return "companys/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("company", Company.findCompany(id));
        uiModel.addAttribute("itemId", id);
        return "companys/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("companys", Company.findCompanyEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Company.countCompanys() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("companys", Company.findAllCompanys(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "companys/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Company company, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, company);
            return "companys/update";
        }
        uiModel.asMap().clear();
        company.merge();
        return "redirect:/companys/" + encodeUrlPathSegment(company.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Company.findCompany(id));
        return "companys/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Company company = Company.findCompany(id);
        company.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/companys";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
		uiModel.addAttribute("company_enrolddate_date_pattern", "dd-MM-yyyy");
    }

	void populateEditForm(Model uiModel, Company company) {
        uiModel.addAttribute("company", company);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("directions", Direction.findAllDirections());
        uiModel.addAttribute("phones", Phone.findAllPhones());
        uiModel.addAttribute("representants", Representant.findAllRepresentants());
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
