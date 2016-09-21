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

	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
    @Digits(integer=3, fraction=0)
	private Long age;
	
	@NotBlank
	private String sex;
	
	@NotBlank
	private String nationality;
	
	@NotBlank
	private String experienceYear;
	
	@NotBlank
	private String price;
	
	public IndexViewInfo(StuffMeta stuffMeta) {
		
		setId(stuffMeta.getId());
		
		setName(stuffMeta.getName());
		
		setAge(stuffMeta.getAge());
		
		setSex(stuffMeta.isSex() ? "女" : "男");
		
		setNationality(stuffMeta.getNationality());
		
		setExperienceYear(stuffMeta.getExperienceYear() + "年");
		
		setPrice(stuffMeta.getPrice() + "万");
	}
}
