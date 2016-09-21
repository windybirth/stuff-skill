package jp.wicresoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.wicresoft.impl.NewImpl;
import jp.wicresoft.info.IndexViewInfo;

@Controller
public class NewController {

	@Autowired
	NewImpl newImpl;
	
	@RequestMapping(value={"/new"})
	public String loadPage(Model model) {
		model.addAttribute("stuffInfo", new IndexViewInfo());
		model.addAttribute("page", "new");
		return "new";
	}
	
	@RequestMapping(value={"/new_add"})
	public String addInfo(@Validated IndexViewInfo stuffInfo, Model model, BindingResult bindingResult) {
		System.out.println(stuffInfo.getName());
		model.addAttribute("stuffInfo", stuffInfo);
		return "new";
	}
}
