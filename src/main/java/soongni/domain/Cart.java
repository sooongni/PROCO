package soongni.domain;
public class Cart extends Code{
	int cartno;
	String goodyn;
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public String getGoodyn() {
		return goodyn;
	}
	public void setGoodyn(String goodyn) {
		this.goodyn = goodyn;
	}
	@Override
	public String toString() {
		return "Cart [cartno=" + cartno + ", goodyn=" + goodyn + ", postno=" + postno + ", mno=" + mno + ", midno="
				+ midno + ", titl=" + titl + ", comno=" + comno + ", dscp=" + dscp + ", sdt=" + sdt + ", edt=" + edt
				+ ", podate=" + podate + ", potime=" + potime + ", link=" + link + ", good=" + good + ", view=" + view
				+ ", stat=" + stat + ", code=" + code + ", type=" + type + ", brname=" + brname + ", used=" + used
				+ ", logo=" + logo + "]";
	}
	
}