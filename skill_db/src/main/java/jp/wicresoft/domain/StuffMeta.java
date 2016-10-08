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
	private int id;
	
	private String name;
	
	private int age;
	
	private boolean sex;
	
	private String nationality;
	
	private int experienceYear;
	
	private int price;
	
	private boolean isMember;
	
}
