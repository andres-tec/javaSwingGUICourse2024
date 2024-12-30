import java.util.EventObject;

public class FormEvent extends EventObject {
	private String name;
	private String occupation;
	private int ageCategory;
	private String occupationType;
	private String taxId;
	private boolean usCitizen;
	private String gender;
	
	public FormEvent(Object object) {
		super(object); 
		
	}
	public FormEvent(Object object, String name, String occupation, int ageCategory,String occupationType
			, String taxId, boolean usCitizen, String gender) {
		super(object);
		this.name= name;
		this.occupation= occupation;
		this.ageCategory= ageCategory;
		this.occupationType= occupationType;
		this.taxId= taxId;
		this.usCitizen= usCitizen;
		this.gender = gender;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(int ageCategory) {
		this.ageCategory = ageCategory;
	}
	public String getOccupationType() {
		return occupationType;
	}
	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public boolean isUsCitizen() {
		return usCitizen;
	}
	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
