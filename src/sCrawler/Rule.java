package sCrawler;

class Rule {
	//链接
	private String url;
	
	//参数集合
	private String[] params;
	private String[] values;
	
	//针对第一次返回结果，过滤标签
	private String resultTagName;
	
	//请求类型,GET=0, POST=1，默认GET
	private int requestType = 0;
	
	public Rule() {
	}
	
	public Rule(String url, String[] params,String[] values, String resultTagName, int requestType ){
		super();
		this.url = url;
		this.params = params;
		this.values = values;
		this.resultTagName = resultTagName;
		this.requestType = requestType;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String[] getParams() {
		return params;
	}
	
	public void setParams(String[] params) {
		this.params = params;
	}
	
	public String[] getValues() {
		return values;
	}
	
	public void setValues(String[] values) {
		this.values = values;
	}
	
	public String getResultTagName() {
		return resultTagName;
	}
	
	public void setResultTagName(String resultTagName) {
		this.resultTagName = resultTagName;
	}
	
	public int getRequestType() {
		return requestType;
	}
	
	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}
	

}
