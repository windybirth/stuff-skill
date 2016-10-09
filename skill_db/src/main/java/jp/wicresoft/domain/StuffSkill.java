package jp.wicresoft.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@IdClass(StuffSkill.StuffId.class)
public class StuffSkill {

	@EmbeddedId
    private PkMapping pk;
	
	public StuffSkill(int stuffId, int skillId) {
		this.pk = new PkMapping(stuffId, skillId);
	}
}

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
class PkMapping implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -523753799587581317L;

	private int stuffId;
	
	private int skillId;
	
}