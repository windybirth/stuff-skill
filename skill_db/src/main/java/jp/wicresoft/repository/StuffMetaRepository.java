package jp.wicresoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.StuffMeta;

public interface StuffMetaRepository extends Repository<StuffMeta, Integer>{

	public List<StuffMeta> findAll();
	
	public List<StuffMeta> findByIsMemberTrue();
	
	public List<StuffMeta> findByIsMemberFalse();
	
	public void save(StuffMeta stuffMeta);
	
	public void saveAndFlush(StuffMeta stuffMeta);
	
	@Query(value = "select meta.* "
			+ "from skill_version_mst v inner join stuff_skill s inner join stuff_meta meta "
			+ "on v.skill_title in ?1 and v.skill_id = s.skill_id and s.stuff_id = meta.id;", nativeQuery = true)
	public List<StuffMeta> findByIds(List<Long> titleIds);
}
