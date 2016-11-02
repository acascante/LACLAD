package com.cyu.laclad.web.controllers;
import com.cyu.laclad.domain.Quiz;
import com.cyu.laclad.domain.QuizQuestion;
import java.io.UnsupportedEncodingException;
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

@RequestMapping("/quizquestions")
@Controller
@RooWebScaffold(path = "quizquestions", formBackingObject = QuizQuestion.class)
public class QuizQuestionController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid QuizQuestion quizQuestion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, quizQuestion);
            return "quizquestions/create";
        }
        uiModel.asMap().clear();
        quizQuestion.persist();
        return "redirect:/quizquestions/" + encodeUrlPathSegment(quizQuestion.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new QuizQuestion());
        return "quizquestions/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("quizquestion", QuizQuestion.findQuizQuestion(id));
        uiModel.addAttribute("itemId", id);
        return "quizquestions/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("quizquestions", QuizQuestion.findQuizQuestionEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) QuizQuestion.countQuizQuestions() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("quizquestions", QuizQuestion.findAllQuizQuestions(sortFieldName, sortOrder));
        }
        return "quizquestions/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid QuizQuestion quizQuestion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, quizQuestion);
            return "quizquestions/update";
        }
        uiModel.asMap().clear();
        quizQuestion.merge();
        return "redirect:/quizquestions/" + encodeUrlPathSegment(quizQuestion.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, QuizQuestion.findQuizQuestion(id));
        return "quizquestions/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        QuizQuestion quizQuestion = QuizQuestion.findQuizQuestion(id);
        quizQuestion.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/quizquestions";
    }

	void populateEditForm(Model uiModel, QuizQuestion quizQuestion) {
        uiModel.addAttribute("quizQuestion", quizQuestion);
        uiModel.addAttribute("quizes", Quiz.findAllQuizes());
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
