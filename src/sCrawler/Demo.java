package sCrawler;

class Demo{
	public static void main(String[] args) {
		String[] p = {"a"};
		String[] v = {"评价"};
		
		String RFile = "D:\\JavaL\\WorkSpace\\Practice\\src\\sCrawler\\1.txt";
		
		Rule r = new Rule("https://www.zhihu.com/question/52063225", p, v , "", 0);
		ExtractService extracts = new ExtractService();
		ResultRecord record = new ResultRecord();
		
		record.record(extracts.extract(r), RFile);
	}
}
