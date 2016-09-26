package jp.wicresoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.wicresoft.impl.SearchImpl;
import jp.wicresoft.info.IndexViewInfo;
import jp.wicresoft.info.SkillSearchInfo;

@Controller
public class SearchController {

	@Autowired
	SearchImpl searchImpl;
	
	Logger logger = LoggerFactory.getLogger(NewController.class);
	
	@RequestMapping(value={"/search"})
	public String loadPage(Model model) {
		model.addAttribute("page", "search");
		model.addAttribute("skillSearchInfo", new SkillSearchInfo());
		model.addAttribute("skillOptions", searchImpl.getSkillNameList());
		return "search";
	}
	
	@RequestMapping(value={"/search_result"})
	public String loadPage(@Valid SkillSearchInfo skillSearchInfo, Model model) {
		logger.info("Search for: " + skillSearchInfo.getLsSkill());
		model.addAttribute("page", "search");
		
		Long condition = Long.parseLong(skillSearchInfo.getLsSkill());
		List<IndexViewInfo> indexViewInfos = searchImpl.getSearchResultBySkill(condition);
		if (!indexViewInfos.isEmpty()) {
			model.addAttribute("stuffMetas", indexViewInfos);
			model.addAttribute("category", "検索結果　");
			return "stuff_info";
		}
		model.addAttribute("skillSearchInfo", skillSearchInfo);
		model.addAttribute("skillOptions", searchImpl.getSkillNameList());
		
		return "search";
	}
}
