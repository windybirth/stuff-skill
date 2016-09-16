package jp.wicresoft.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StuffDb {

	@Id
	private Long id;
	
	private Long stuffId;
	
	private String dbName;
}
