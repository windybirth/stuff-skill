package jp.wicresoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.wicresoft.impl.SearchImpl;

@Controller
public class SearchController {

	@Autowired
	SearchImpl searchImpl;
	
	@RequestMapping(value={"/search"})
	public String loadPage(Model model) {
		model.addAttribute("page", "search");
		return "search";
	}
}
