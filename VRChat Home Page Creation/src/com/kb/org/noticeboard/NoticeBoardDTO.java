package com.kb.org.noticeboard;

public class NoticeBoardDTO {
	private int idx;
	private String title;
	private String cname;
	private String content;
	private String regdate;
	private int cnt;

//	public NoticeBoardDTO() {
//		super();
//		this.idx = idx;
//		this.title = title;
//		this.cname = cname;
//		this.content = content;
//		this.regdate = regdate;
//		this.cnt = cnt;
//	}

	@Override
	public String toString() {
		return "NoticeBoard [ idx = " + idx + ", title = " + title + ", cname = " + cname + ", content = " + content
				+ ", regdate = " + regdate + ", cnt = " + cnt + " ]";
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}