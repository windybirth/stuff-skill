package jp.wicresoft.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.wicresoft.impl.NewImpl;
import jp.wicresoft.info.IndexViewInfo;

@Controller
public class NewController {

	@Autowired
	NewImpl newImpl;
	
	Logger logger = LoggerFactory.getLogger(NewController.class);
	
	@RequestMapping(value={"/new"})
	public String loadPage(Model model) {
		IndexViewInfo indexViewInfo = new IndexViewInfo();
		model.addAttribute("indexViewInfo", indexViewInfo);
		model.addAttribute("page", "new");
		return "new";
	}
	
	@RequestMapping(value={"/new_add"})
	public String addInfo(@Valid IndexViewInfo indexViewInfo, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("indexViewInfo", indexViewInfo);
			model.addAttribute("page", "new");
            return "new";
        }
		logger.info("Add stuff: " + indexViewInfo.getName());
		newImpl.addOneStuff(indexViewInfo);
		return "redirect:all_stuff";
	}
}
