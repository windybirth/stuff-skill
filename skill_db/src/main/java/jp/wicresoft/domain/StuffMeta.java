package jp.wicresoft.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StuffMeta {
	
	@Id
	private Long id;
	
	private String name;
	
	private Long age;
	
	private boolean sex;
	
	private String nationality;
	
	private Long experienceYear;
	
	private Long price;
	
	private String license;
	
	private String os;
	
	private String db;
	
	private String developLanguage;
}
