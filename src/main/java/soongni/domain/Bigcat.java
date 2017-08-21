package soongni.domain;

import java.util.ArrayList;

public class Bigcat {
	int bigno;
	String bigcat;
	ArrayList<Midcat> midcatList;
	
	
	public int getBigno() {
		return bigno;
	}
	public void setBigno(int bigno) {
		this.bigno = bigno;
	}
	public String getBigcat() {
		return bigcat;
	}
	public void setBigcat(String bigcat) {
		this.bigcat = bigcat;
	}
	public ArrayList<Midcat> getMidcatList() {
		return midcatList;
	}
	public void setMidcatList(ArrayList<Midcat> midcatList) {
		this.midcatList = midcatList;
	}
	@Override
	public String toString() {
		return "Bigcat [bigno=" + bigno + ", bigcat=" + bigcat + ", midcatList=" + midcatList + "]";
	}
	
	
}
