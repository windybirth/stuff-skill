package jp.wicresoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jp.wicresoft.impl.SearchImpl;
import jp.wicresoft.impl.SkillSelectImpl;
import jp.wicresoft.info.IndexViewInfo;
import jp.wicresoft.info.SkillSelectInfo;

@Controller
public class SearchController {

	@Autowired
	SearchImpl searchImpl;
	
	@Autowired
	SkillSelectImpl skillSelectImpl;
	
	Logger logger = LoggerFactory.getLogger(NewController.class);
	
	@RequestMapping(value={"/search"}, method=RequestMethod.GET)
	public String loadPage(Model model) {
		model.addAttribute("page", "search");
		SkillSelectInfo skill = new SkillSelectInfo();
		skill.setLsSkill(new ArrayList<String>());
		skill.getLsSkill().add("0");
		model.addAttribute("skillSelectInfo", skill);
		model.addAttribute("skillOptions", skillSelectImpl.getSkillNameList());
		return "search";
	}
	
	@RequestMapping(value={"/search"}, method=RequestMethod.POST)
	public String loadPage(@Valid SkillSelectInfo skillSelectInfo, Model model) {
		logger.info("Search for: " + skillSelectInfo.getLsSkill());
		model.addAttribute("page", "search");
		if (skillSelectInfo.getLsSkill().isEmpty()) {
			// 検索条件がない場合
			model.addAttribute("skillSelectInfo", skillSelectInfo);
			model.addAttribute("skillOptions", skillSelectImpl.getSkillNameList());
			return "search";
		}
		
		try {
			List<Integer> conditionList = new ArrayList<Integer>();
			for (String skillIdStr : skillSelectInfo.getLsSkill()) {
				conditionList.add(Integer.parseInt(skillIdStr));
			}
			List<IndexViewInfo> indexViewInfos = searchImpl.getSearchResultBySkill(conditionList);
			// 結果を出す
			model.addAttribute("stuffMetas", indexViewInfos);
			model.addAttribute("category", "検索結果　");
			return "stuff_info";
		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
		}
		model.addAttribute("skillSelectInfo", skillSelectInfo);
		model.addAttribute("skillOptions", skillSelectImpl.getSkillNameList());
		
		return "search";
	}
	
	@RequestMapping(value={"/search_addSelect"}, method=RequestMethod.POST)
	public String addSelect(@RequestParam(value = "index", required = false) int index, Model model) {
		logger.info("Selector have now: " + String.valueOf(index));
		SkillSelectInfo skill = new SkillSelectInfo();
		
		skill.setLsSkill(new ArrayList<String>());
		skill.getLsSkill().add("0");
		model.addAttribute("skillSelectInfo", skill);
		// set dynamic index
		model.addAttribute("index", index);
		model.addAttribute("skillOptions", skillSelectImpl.getSkillNameList());
		return "skill_select";
	}
}
