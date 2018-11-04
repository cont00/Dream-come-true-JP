package com.kb.org;

public class MemberDTO {
	private int member_idx;
	private String id;
	private String pw;
	private String pwc;
	private String name;
	private String cname;
	private String sex;
	private String ad;
	private String em;
	private String lang;
	
	@Override
	public String toString() {
		return "MemberDTO [ Member_idx : " + member_idx + "ID : " + id + ", Password : " + pw + ", Password Check : " + pwc
						+ ", Name : " + name + ", Character Name : " + cname + ", Sex : "
						+ sex + ", Address : " + ad + ", E-mail Address : " + em + "Language : " + lang + 
						"]";
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPwc() {
		return pwc;
	}
	public void setPwc(String pwc) {
		this.pwc = pwc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
}