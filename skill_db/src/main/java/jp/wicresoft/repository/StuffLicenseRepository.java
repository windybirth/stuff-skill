package jp.wicresoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.StuffLicense;

public interface StuffLicenseRepository extends Repository<StuffLicense, Long>{
	
	public List<StuffLicense> findByStuffId(Long stuffId);
}
