package soongni.domain;

public class Midcat extends Bigcat {
	
	int midno;
	String midcat;
	
	
	public int getMidno() {
		return midno;
	}
	public void setMidno(int midno) {
		this.midno = midno;
	}
	public String getMidcat() {
		return midcat;
	}
	public void setMidcat(String midcat) {
		this.midcat = midcat;
	}
	
	
	@Override
	public String toString() {
		return "Midcat [midno=" + midno + ", midcat=" + midcat + ", bigno=" + bigno + "]";
	}
	
	
}
