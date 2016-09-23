package jp.wicresoft.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.wicresoft.domain.StuffMeta;
import jp.wicresoft.info.IndexViewInfo;
import jp.wicresoft.repository.StuffMetaRepository;

@Component
public class NewImpl {

	@Autowired
	StuffMetaRepository stuffMetaRepository;
	
	public void addOneStuff(IndexViewInfo indexViewInfo) {
		StuffMeta stuffMeta = indexViewInfo.toStuffMeta();
		stuffMetaRepository.saveAndFlush(stuffMeta);
	}
}
