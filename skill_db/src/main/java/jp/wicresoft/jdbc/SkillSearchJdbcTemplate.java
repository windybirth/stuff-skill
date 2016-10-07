package jp.wicresoft.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jp.wicresoft.domain.StuffMeta;

@Component
public class SkillSearchJdbcTemplate extends BasicJdbc{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<StuffMeta> findByIds(List<Long> titleIds) {
		String queryStr = "select meta.* "
				+ "from skill_version_mst v inner join stuff_skill s inner join stuff_meta meta "
				+ "on v.skill_title in (1) and v.skill_id = s.skill_id and s.stuff_id = meta.id;";
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(queryStr);
		return convertJdbcMapToBean(mapList, StuffMeta.class);
	}
}
