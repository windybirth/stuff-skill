package jp.wicresoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.wicresoft.impl.EditImpl;

@Controller
public class EditController {

	@Autowired
	EditImpl editImpl;
	
	@RequestMapping("/edit/{id}")
	public String editPage(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		return "edit";
	}
}
