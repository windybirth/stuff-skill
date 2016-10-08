package jp.wicresoft.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.wicresoft.domain.SkillTitleMst;
import jp.wicresoft.domain.StuffMeta;
import jp.wicresoft.info.IndexViewInfo;
import jp.wicresoft.jdbc.SkillSearchJdbcTemplate;
import jp.wicresoft.repository.SkillTitleMstRepository;
import jp.wicresoft.repository.StuffMetaRepository;

@Component
public class SearchImpl {

	@Autowired
	SkillTitleMstRepository skillTitleMstRepository;
	
	@Autowired
	StuffMetaRepository stuffMetaRepository;
	
	@Autowired
	SkillSearchJdbcTemplate skillSearchJdbcTemplate;
	
	public List<SkillTitleMst> getSkillNameList() {
		return skillTitleMstRepository.findAll();
	}
	
	public List<IndexViewInfo> getSearchResultBySkill(List<Integer> titleIds) {
		List<StuffMeta> stuffMetas  = skillSearchJdbcTemplate.findByIds(titleIds);
		List<IndexViewInfo> indexViewInfos = new ArrayList<>();
		for (StuffMeta stuffMeta : stuffMetas) {
			indexViewInfos.add(new IndexViewInfo(stuffMeta));
		}
		return indexViewInfos;
	}
}
