package com.kb.org;

public class FreeboardDTO {
	private	int freeboard_idx;
	private String title;
	private String cname;
	private String content;
	private String writetime;
	private int group_idx;
	private int group_idx_fk;
	private int level_idx;

	@Override
	public String toString() {
		return "FreeboardDTO [ freeboar_idx = " + freeboard_idx + ", title = " + title + ", cname = " + cname
				+ ", content = " + content + "writetime = " + writetime + ", group_idx = " + group_idx
				+ ", group_idx_fk = " + group_idx_fk + ", level_idx = " + level_idx + " ]";
	}
	public int getFreeboard_idx() {
		return freeboard_idx;
	}
	public void setFreeboard_idx(int freeboard_idx) {
		this.freeboard_idx = freeboard_idx;
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
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	public int getGroup_idx() {
		return group_idx;
	}
	public void setGroup_idx(int group_idx) {
		this.group_idx = group_idx;
	}
	public int getGroup_idx_fk() {
		return group_idx_fk;
	}
	public void setGroup_idx_fk(int getgroup_idx_fk) {
		this.group_idx_fk = getgroup_idx_fk;
	}
	public int getLevel_idx() {
		return level_idx;
	}
	public void setLevel_idx(int level_idx) {
		this.level_idx = level_idx;
	}
}