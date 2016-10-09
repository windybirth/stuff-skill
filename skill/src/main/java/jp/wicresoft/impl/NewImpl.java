package jp.wicresoft.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.wicresoft.domain.StuffMeta;
import jp.wicresoft.domain.StuffSkill;
import jp.wicresoft.info.IndexViewInfo;
import jp.wicresoft.repository.StuffMetaRepository;
import jp.wicresoft.repository.StuffSkillRepository;

@Component
public class NewImpl {

	@Autowired
	StuffMetaRepository stuffMetaRepository;
	
	@Autowired
	StuffSkillRepository stuffSkillRepository;
	
	@Transactional
	public void addOneStuff(IndexViewInfo indexViewInfo, List<Integer> skillIdList) {
		StuffMeta stuffMeta = indexViewInfo.toStuffMeta();
		StuffMeta result = stuffMetaRepository.saveAndFlush(stuffMeta);
		int stuffId = result.getId();
		for (Integer skillId : skillIdList) {
			stuffSkillRepository.saveAndFlush(new StuffSkill(stuffId, skillId));
		}
	}
}
