package soongni.domain;

public class BusiMember extends Member{
	
	String ceotel;
	String busino;
	int comno;
	
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
	String brname;
	public String getCeotel() {
		return ceotel;
	}
	public void setCeotel(String ceotel) {
		this.ceotel = ceotel;
	}
	public String getBusino() {
		return busino;
	}
	public void setBusino(String busino) {
		this.busino = busino;
	}
	@Override
	public String toString() {
		return "BusiMember [ceotel=" + ceotel + ", busino=" + busino + ", comno=" + comno + ", brname=" + brname
				+ ", mno=" + mno + ", email=" + email + ", pwd=" + pwd + ", alias=" + alias + ", type=" + type
				+ ", pic=" + pic + "]";
	}
	


}
