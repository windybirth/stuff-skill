package jp.wicresoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.wicresoft.impl.NewImpl;
import jp.wicresoft.impl.SkillSelectImpl;
import jp.wicresoft.info.IndexViewInfo;
import jp.wicresoft.info.SkillSelectInfo;

@Controller
public class NewController {

	@Autowired
	NewImpl newImpl;
	
	@Autowired
	SkillSelectImpl skillSelectImpl;
	
	Logger logger = LoggerFactory.getLogger(NewController.class);
	
	@RequestMapping(value={"/new"})
	public String loadPage(Model model) {
		IndexViewInfo indexViewInfo = new IndexViewInfo();
		model.addAttribute("indexViewInfo", indexViewInfo);
		model.addAttribute("page", "new");
		// add skill select
		SkillSelectInfo skill = new SkillSelectInfo();
		skill.setLsSkill(new ArrayList<String>());
		skill.getLsSkill().add("0");
		model.addAttribute("skillSelectInfo", skill);
		model.addAttribute("skillOptions", skillSelectImpl.getSkillNameList());
		return "new";
	}
	
	@RequestMapping(value = {"/new_add"}, method = RequestMethod.POST)
	public String addInfo(@Valid IndexViewInfo indexViewInfo, BindingResult bindingResult, @Valid SkillSelectInfo skillSelectInfo, Model model) {
		if (!bindingResult.hasErrors()) {
			logger.info("Add skill : " + skillSelectInfo.getLsSkill());
			try {
				// convert skill id to integer
				List<Integer> skillIdList = new ArrayList<Integer>();
				for (String skillIdStr : skillSelectInfo.getLsSkill()) {
					skillIdList.add(Integer.parseInt(skillIdStr));
				}
				logger.info("Add stuff: " + indexViewInfo.getName());
				newImpl.addOneStuff(indexViewInfo, skillIdList);
				return "redirect:all_stuff";
			} catch (Exception e) {
				logger.info(e.getLocalizedMessage());
			}
			
        }
		
		model.addAttribute("indexViewInfo", indexViewInfo);
		model.addAttribute("page", "new");
		// add skill select
		model.addAttribute("skillSelectInfo", skillSelectInfo);
		model.addAttribute("skillOptions", skillSelectImpl.getSkillNameList());
		return "new";
	}
}
