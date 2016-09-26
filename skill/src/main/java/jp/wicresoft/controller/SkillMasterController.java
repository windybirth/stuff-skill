package jp.wicresoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.wicresoft.impl.SkillMasterImpl;

@Controller
public class SkillMasterController {

	@Autowired
	SkillMasterImpl skillMasterImpl;
	
	@RequestMapping(value="/skill")
	public String skillView(Model model) {
		model.addAttribute("page", "master");
		
		return "skill_view";
	}
}
