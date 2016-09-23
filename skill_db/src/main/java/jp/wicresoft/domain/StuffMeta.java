package jp.wicresoft.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StuffMeta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Long age;
	
	private boolean sex;
	
	private String nationality;
	
	private Long experienceYear;
	
	private Long price;
	
	private boolean isMember;
}
