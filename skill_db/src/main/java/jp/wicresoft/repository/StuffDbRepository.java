package jp.wicresoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.StuffDb;

public interface StuffDbRepository extends Repository<StuffDb, Long>{
	
	public List<StuffDb> findByStuffId(Long stuffId);
}
