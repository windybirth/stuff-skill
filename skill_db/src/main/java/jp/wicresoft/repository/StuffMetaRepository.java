package jp.wicresoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.StuffMeta;

public interface StuffMetaRepository extends Repository<StuffMeta, Long>{

	public List<StuffMeta> findAll();
	
	public List<StuffMeta> findByIsMemberTrue();
	
	public List<StuffMeta> findByIsMemberFalse();
}
