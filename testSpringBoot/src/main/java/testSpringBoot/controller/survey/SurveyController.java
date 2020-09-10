package testSpringBoot.controller.survey;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import testSpringBoot.command.SurveyCommend;
import testSpringBoot.service.survey.SurveyInsertService;

@Controller
@RequestMapping("survey")
public class SurveyController {
	@Autowired
	SurveyInsertService surveyInsertService;
	@RequestMapping("surveyForm")
	public  String surveyForm() {
		return "thymeleaf/survey/surveyInsert";
	}
	@RequestMapping("surveyInsert")
	public String surveyInsert(SurveyCommend surveyCommend,
			HttpSession session) throws Exception{
		surveyInsertService.surveyInsert(surveyCommend, session);
		return "redirect:/survey/surveyForm";
	}
}
