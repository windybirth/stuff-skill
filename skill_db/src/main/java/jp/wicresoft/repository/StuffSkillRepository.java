package jp.wicresoft.repository;

import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.StuffSkill;

public interface StuffSkillRepository extends Repository<StuffSkill, Integer> {

	public void saveAndFlush(StuffSkill stuffSkill);
}
