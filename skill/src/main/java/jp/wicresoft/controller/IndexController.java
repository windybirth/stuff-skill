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
	
	@RequestMapping(value={"", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("page", "home");
		return "index";
	}
	
	@RequestMapping("/self_stuff")
	public String self_stuff(Model model) {
		model.addAttribute("stuffMetas", indexImpl.getSelfStuffMetaInfoAll());
		model.addAttribute("page", "view");
		model.addAttribute("category", "自社社員");
		return "stuff_info";
	}
	
	@RequestMapping("/other_stuff")
	public String other_stuff(Model model) {
		model.addAttribute("stuffMetas", indexImpl.getOtherStuffMetaInfoAll());
		model.addAttribute("page", "view");
		model.addAttribute("category", "他社社員");
		return "stuff_info";
	}
	
	@RequestMapping("/all_stuff")
	public String all_stuff(Model model) {
		model.addAttribute("stuffMetas", indexImpl.getStuffMetaInfoAll());
		model.addAttribute("page", "view");
		model.addAttribute("category", "全員");
		return "stuff_info";
	}
	
	/**
	 * 画面からajaxで詳細スキル情報取得用
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stuffDetail/{id}")
	public String stuffDetailInfo(@PathVariable long id , Model model) {
		model.addAttribute("skillDetail", indexImpl.getIndexSkillDetailInfo(id));
		return "stuff_subrow";
	}
}
