package jp.wicresoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.StuffDevelopLanguage;

public interface StuffDevelopLanguageRepository extends Repository<StuffDevelopLanguage, Long> {

	public List<StuffDevelopLanguage> findByStuffId(Long stuffId);
}
