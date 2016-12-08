package sCrawler;

import java.util.ArrayList;

class Demo{
	public static void main(String[] args) {
		String RFile = "D:\\JavaL\\WorkSpace\\Practice\\src\\sCrawler\\1.txt";

//		String[] p = {"a"};
//		String[] v = {"奋"};
//		
//		Rule r = new Rule("https://www.zhihu.com/question/27062686", p, v , "", 0);
//		
//////		ExtractService extracts = new ExtractService();
//////		ResultRecord record = new ResultRecord();
//////		record.record(extracts.extract(r), RFile);
//		
//		ExtractService extracts = new ExtractService();
//		ArrayList<LinkData> newlinks = extracts.extract(r);
//		ExistingLinks existingLinks = new ExistingLinks();
//		WriteService writeService = new WriteService();
//		
//		int i=0;
//		int j=1;
//		
//		for(;(i<j&&j<10);i++){
//			writeService.writeFile(newlinks, existingLinks.getExistingLinks(RFile), RFile);
//			
//			r.setUrl(existingLinks.getExistingLinks(RFile).get(i));
//			newlinks = extracts.extract(r);
//			j = existingLinks.getExistingLinks(RFile).size();
//		}
//		
//		if(i==j||j>10)
//			System.out.println("Done!");
//		
		ArrayList<String> aStrings = new ArrayList<String>();
		ExistingLinks eLinks = new ExistingLinks();
		aStrings = eLinks.getExistingLinks(RFile);
		
		for(int i=0;i<aStrings.size();i++){
			System.out.println(aStrings.get(i));
			System.out.println();
		}
		

	}
}
