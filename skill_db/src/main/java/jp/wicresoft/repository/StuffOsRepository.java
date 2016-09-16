package jp.wicresoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.StuffOs;

public interface StuffOsRepository extends Repository<StuffOs, Long>{
	
	public List<StuffOs> findByStuffId(Long stuffId);
}