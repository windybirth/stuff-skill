package jp.wicresoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.wicresoft.impl.IndexImpl;

@Controller
public class IndexController {

	@Autowired
	IndexImpl indexImpl;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("stuffMetas", indexImpl.getStuffMetaInfoAll());
		return "index";
	}
	
	@RequestMapping(value = "/stuffDetail/{id}")
	public String stuffDetailInfo(@PathVariable long id , Model model) {
		model.addAttribute("skillDetail", indexImpl.getIndexSkillDetailInfo(id));
		return "index_subrow";
	}
}
