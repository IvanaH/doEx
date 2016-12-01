package sCrawler;

class LinkData {
	private int id;
	
	//link
	private String linkHref;
	
	//title of link
	private String linkTitle;
	
	//summary of link
	private String summary;
	
	//Content of link
	private String content;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String  getLinkHref() {
		return linkHref;
	}
	
	public void setLinkHref(String linkHref) {
		this.linkHref = linkHref;
	}
	
	public String  getLinkTitle() {
		return linkTitle;
	}
	
	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}
	
	public String  getLinkSummary() {
		return summary;
	}
	
	public void setSumarry(String summary) {
		this.summary = summary;
	}
	
	public String  getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
