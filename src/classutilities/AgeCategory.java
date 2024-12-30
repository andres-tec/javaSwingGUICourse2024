package classutilities;

public class AgeCategory{
	private int ageIdx;
	private String ageRange;
	
	public AgeCategory(int ageIndex, String ageRange) {
		this.ageIdx = ageIndex;
		this.ageRange = ageRange;
	}

	public int getAgeIdx() {
		return ageIdx;
	}

	public void setAgeIdx(int ageIdx) {
		this.ageIdx = ageIdx;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	
	public String toString() {
		return this.ageRange;
	}
}