package jp.wicresoft.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class SkillTitleMst {

	@Id
	private Long skillTitleId;
	
	private String titleName;
	
	private Long skillCategory;
}
