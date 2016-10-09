package jp.wicresoft.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(StuffSkill.StuffId.class)
public class StuffSkill {

	@Id
	int stuffId;
	
	@Id
	int skillId;
	
	static class StuffId {
		
		int stuffId;
		
		int skillId;
		
	}
}
