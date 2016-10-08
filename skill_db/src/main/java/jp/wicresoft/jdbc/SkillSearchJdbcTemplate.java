package jp.wicresoft.jdbc;

import java.util.ArrayList;
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
	
	final private int INDEX_START = 1;
	
	public List<StuffMeta> findByIds(List<Integer> titleIds) {
		if (titleIds.isEmpty()) {
			return new ArrayList<StuffMeta>();
		}
		
		StringBuffer joinBuffer = new StringBuffer();
		StringBuffer andBuffer = new StringBuffer();
		StringBuffer paramBuffer = new StringBuffer();
		for (int currentIndex = INDEX_START; currentIndex <= titleIds.size(); currentIndex++) {
			joinBuffer.append(" inner join stuff_skill s");
			joinBuffer.append(currentIndex);
			
			if (currentIndex > INDEX_START) {
				andBuffer.append(" and s");
				andBuffer.append(currentIndex - 1);
				andBuffer.append(".stuff_id = s");
				andBuffer.append(currentIndex);
				andBuffer.append(".stuff_id");
			}
			
			paramBuffer.append(" and s");
			paramBuffer.append(currentIndex);
			paramBuffer.append(".skill_id = ?");
		}
		String queryStr = "select meta.* from stuff_meta meta "
				+ joinBuffer.toString()
				+ " on meta.id = s"
				+ INDEX_START
				+ ".stuff_id "
				+ andBuffer.toString()
				+ paramBuffer.toString();
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(queryStr, titleIds.toArray());
		return convertJdbcMapToBean(mapList, StuffMeta.class);
	}
}
