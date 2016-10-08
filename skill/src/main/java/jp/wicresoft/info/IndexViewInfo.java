package jp.wicresoft.info;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;

import jp.wicresoft.domain.StuffMeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexViewInfo {

	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
    @Digits(integer=2, fraction=0)
	private String age;
	
	@NotBlank
	private String sex;
	
	@NotBlank
	private String nationality;
	
	@NotBlank
	@Digits(integer=2, fraction=0)
	private String experienceYear;
	
	@NotBlank
	@Digits(integer=10, fraction=0)
	private String price;
	
	private boolean member;
	
	/**
	 * load StuffMeta domain info
	 * @param stuffMeta
	 */
	public IndexViewInfo(StuffMeta stuffMeta) {
		
		setId(String.valueOf(stuffMeta.getId()));
		
		setName(stuffMeta.getName());
		
		setAge(String.valueOf(stuffMeta.getAge()));
		
		setSex(stuffMeta.isSex() ? "true" : "false");
		
		setNationality(stuffMeta.getNationality());
		
		setExperienceYear(stuffMeta.getExperienceYear() + "年");
		
		setPrice(stuffMeta.getPrice() + "万");
		
		setMember(stuffMeta.isMember());
	}
	
	/**
	 * translate to StuffMeta domain
	 * @return
	 */
	public StuffMeta toStuffMeta() {
		StuffMeta stuffMeta = new StuffMeta();
		
		stuffMeta.setName(getName());
		stuffMeta.setAge(Integer.parseInt(getAge()));
		// TODO
		stuffMeta.setSex(false);
		stuffMeta.setExperienceYear(Integer.parseInt(getExperienceYear()));
		stuffMeta.setPrice(Integer.parseInt(getPrice()));
		stuffMeta.setNationality(getNationality());
		stuffMeta.setMember(isMember());
		
		return stuffMeta;
	}
}
