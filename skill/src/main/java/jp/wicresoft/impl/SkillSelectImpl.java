package jp.wicresoft.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.wicresoft.domain.SkillTitleMst;
import jp.wicresoft.repository.SkillTitleMstRepository;

@Component
public class SkillSelectImpl {

	@Autowired
	SkillTitleMstRepository skillTitleMstRepository;
	
	public List<SkillTitleMst> getSkillNameList() {
		return skillTitleMstRepository.findAll();
	}
}
