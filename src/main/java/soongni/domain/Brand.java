package soongni.domain;

public class Brand {
	int comno;
	String brname;
	String logo;
	
	
	public int getComno() {
		return comno;
	}
	public void setComno(int comno) {
		this.comno = comno;
	}
	public String getBrname() {
		return brname;
	}
	public void setBrname(String brname) {
		this.brname = brname;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Override
	public String toString() {
		return "Brand [comno=" + comno + ", brname=" + brname + ", logo=" + logo + "]";
	}
	
	
	
}
