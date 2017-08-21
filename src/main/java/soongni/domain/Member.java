package soongni.domain;

	public class Member {
		int mno;
		String email;
		String pwd;
		String alias;
		String type;
		String pic;
		
		
		public int getMno() {
			return mno;
		}
		public void setMno(int mno) {
			this.mno = mno;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		@Override
		public String toString() {
			return "Member [mno=" + mno + ", email=" + email + ", pwd=" + pwd + ", alias=" + alias + ", type=" + type
					+ ", pic=" + pic + "]";
		}
		
		

}
