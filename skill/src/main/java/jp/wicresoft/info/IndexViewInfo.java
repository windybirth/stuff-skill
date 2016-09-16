package jp.wicresoft.info;

import jp.wicresoft.domain.StuffMeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexViewInfo {

	private Long id;
	
	private String name;
	
	private Long age;
	
	private String sex;
	
	private String nationality;
	
	private String experienceYear;
	
	private String price;
	
	private String license;
	
	private String os;
	
	private String db;
	
	private String developLanguage;
	
	public IndexViewInfo(StuffMeta stuffMeta) {
		
		setId(stuffMeta.getId());
		
		setName(stuffMeta.getName());
		
		setAge(stuffMeta.getAge());
		
		setSex(stuffMeta.isSex() ? "女" : "男");
		
		setNationality(stuffMeta.getNationality());
		
		setExperienceYear(stuffMeta.getExperienceYear() + "年");
		
		setPrice(stuffMeta.getPrice() + "万");
		
		setLicense(stuffMeta.getLicense());
		
		setOs(stuffMeta.getOs());
		
		setDb(stuffMeta.getDb());
		
		setDevelopLanguage(stuffMeta.getDevelopLanguage());
	}
}
