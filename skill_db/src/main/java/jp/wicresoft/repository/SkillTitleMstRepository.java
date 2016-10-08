package jp.wicresoft.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import jp.wicresoft.domain.SkillTitleMst;

public interface SkillTitleMstRepository extends Repository<SkillTitleMst, Integer> {

	public List<SkillTitleMst> findAll();
}
