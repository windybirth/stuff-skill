package jp.wicresoft.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.wicresoft.domain.StuffDb;
import jp.wicresoft.domain.StuffDevelopLanguage;
import jp.wicresoft.domain.StuffLicense;
import jp.wicresoft.domain.StuffMeta;
import jp.wicresoft.domain.StuffOs;
import jp.wicresoft.info.IndexSkillDetailInfo;
import jp.wicresoft.info.IndexViewInfo;
import jp.wicresoft.repository.StuffDbRepository;
import jp.wicresoft.repository.StuffDevelopLanguageRepository;
import jp.wicresoft.repository.StuffLicenseRepository;
import jp.wicresoft.repository.StuffMetaRepository;
import jp.wicresoft.repository.StuffOsRepository;

@Component
public class IndexImpl {

	@Autowired
	StuffMetaRepository stuffMetaRepository;
	
	@Autowired
	StuffLicenseRepository stuffLicenseRepository;
	
	@Autowired
	StuffOsRepository stuffOsRepository;
	
	@Autowired
	StuffDbRepository stuffDbRepository;
	
	@Autowired
	StuffDevelopLanguageRepository stuffDevelopLanguageRepository;
	
	public List<IndexViewInfo> getStuffMetaInfoAll() {
		List<StuffMeta> stuffMetas  = stuffMetaRepository.findAll();
		List<IndexViewInfo> indexViewInfos = new ArrayList<>();
		for (StuffMeta stuffMeta : stuffMetas) {
			indexViewInfos.add(new IndexViewInfo(stuffMeta));
		}
		return indexViewInfos;
	}
	
	public List<IndexViewInfo> getSelfStuffMetaInfoAll() {
		List<StuffMeta> stuffMetas  = stuffMetaRepository.findByIsMemberTrue();
		List<IndexViewInfo> indexViewInfos = new ArrayList<>();
		for (StuffMeta stuffMeta : stuffMetas) {
			indexViewInfos.add(new IndexViewInfo(stuffMeta));
		}
		return indexViewInfos;
	}
	
	public List<IndexViewInfo> getOtherStuffMetaInfoAll() {
		List<StuffMeta> stuffMetas  = stuffMetaRepository.findByIsMemberFalse();
		List<IndexViewInfo> indexViewInfos = new ArrayList<>();
		for (StuffMeta stuffMeta : stuffMetas) {
			indexViewInfos.add(new IndexViewInfo(stuffMeta));
		}
		return indexViewInfos;
	}
	
	public IndexSkillDetailInfo getIndexSkillDetailInfo(long stuffId) {
		IndexSkillDetailInfo indexSkillDetailInfo  = new IndexSkillDetailInfo();
		// set skill detail info
		indexSkillDetailInfo.setLicense(convertListObjectToString(getStuffLicenses(stuffId)));
		indexSkillDetailInfo.setOs(convertListObjectToString(getStuffOss(stuffId)));
		indexSkillDetailInfo.setDb(convertListObjectToString(getStuffDbs(stuffId)));
		indexSkillDetailInfo.setDevelopLanguage(convertListObjectToString(getStuffDevelopLanguages(stuffId)));
		
		return indexSkillDetailInfo;
	}
	
	private List<StuffLicense> getStuffLicenses(long stuffId) {
		List<StuffLicense> stuffLicenses = stuffLicenseRepository.findByStuffId(stuffId);
		return stuffLicenses;
	}

	private List<StuffOs> getStuffOss(long stuffId) {
		List<StuffOs> stuffOss = stuffOsRepository.findByStuffId(stuffId);
		return stuffOss;
	}
	
	private List<StuffDb> getStuffDbs(long stuffId) {
		List<StuffDb> stuffDbs = stuffDbRepository.findByStuffId(stuffId);
		return stuffDbs;
	}
	
	private List<StuffDevelopLanguage> getStuffDevelopLanguages(long stuffId) {
		List<StuffDevelopLanguage> stuffDevelopLanguages = stuffDevelopLanguageRepository.findByStuffId(stuffId);
		return stuffDevelopLanguages;
	}
	
	private String convertListObjectToString(List<?> objectList) {
		String methodName = "";
		// 文字列の組み込み設定
		StringJoiner skillNameJoiner = new StringJoiner("], [", "[", "]");
		if (objectList.size() > 0) {
			// get method name
			String className = objectList.get(0).getClass().getSimpleName();
			if (className.startsWith("Stuff")) {
				methodName = "get" + className.substring(5) + "Name";
			} else {
				return "";
			}
			// get method
			try {
				Method method = objectList.get(0).getClass().getDeclaredMethod(methodName);
				// convertListObjectToString
				for (Object object : objectList) {
					String name = (String) method.invoke(object);
					skillNameJoiner.add(name);
				}
				// success
				return skillNameJoiner.toString();
			} catch (Exception e) {
				return "";
			}
		} else {
			return "なし";
		}
	}
}
