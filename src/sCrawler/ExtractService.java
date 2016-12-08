package sCrawler;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class ExtractService {
	public ArrayList<LinkData> extract(Rule rule){
		ArrayList<LinkData> links = new ArrayList<LinkData>();

		try{
			
			validateRule(rule);
			
//			LinkData data = new LinkData();
			
			LinkData data = null;
			
//			//HttpClient
//			URI u = new URI(rule.getUrl());
//			DefaultHttpClient httpclient = new DefaultHttpClient();
//			HttpGet httpget = new HttpGet(u);
//			ResponseHandler<String> responseHandler = new BasicResponseHandler();
//			String content = httpclient.execute(httpget, responseHandler);
//			content = new String(content.getBytes("ISO-8859-1"),"UTF-8");
//			return content;
			
			//analyzing rule
			URL url2 = new URL(rule.getUrl());
//			String[] params = rule.getParams();
			String[] values = rule.getValues();
//			String resultTagName = rule.getResultTagName();
//			int requestType = rule.getRequestType();
			
			URLConnection con =  url2.openConnection();
			
			con.setReadTimeout(20*1000);
			con.connect();
			
			//read the output
			BufferedReader rd = null;
			
			//TODO catch error from http links 	
			rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"),1 * 1024 * 1024); 
			
			String html = "";
			String line = null;
			
		    while ((line = rd.readLine()) != null){
		    	html = html + line;
		    }
		    System.out.print(html);
		    System.out.println();
		    
		    //process output of the link
		    String reg = "<a class=\"question_link\" href=\"(.+?)\" data-id=\".+?\">(.+?)</a>";
			Pattern P = Pattern.compile(reg);
			Matcher m = P.matcher(html);
			  
			while(m.find()){
//				System.out.println(m.group(0));
				data = new LinkData();  //why can't new it out of while
				
				if(m.group(2).contains(values[0])){
					  data.setId(links.size()+1);
					  data.setLinkHref("https://www.zhihu.com"+m.group(1));
					  data.setLinkTitle(m.group(2));

					  links.add(data);
					  
//					  for(int i=0;i<links.size();i++)
//							System.out.println(links.get(i).getLinkTitle());
//					  System.out.println();
				}
				
			}
			if(links.size() == 0)
				System.out.println("Not found matches");
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
//		for(LinkData link:links)
//			System.out.println(link.getLinkTitle());
	
//		for(int i=0;i<links.size();i++)
//			System.out.println(links.get(i).getLinkTitle());
//		
//		System.out.println(links.get(0).getLinkTitle());
//		System.out.println(links.get(1).getLinkTitle());

		
		return links;
	}
	
	//verify url and its parameters
	public static void validateRule(Rule rule){
		String url = null;
		url = rule.getUrl();
		
		if(url.isEmpty()){
			throw new RuleException("url can not be empty!");			
		}
		if(!url.startsWith("http://")&&!url.startsWith("https://")){
			throw new RuleException("The format of the url is wrong.");
		}
		
		if(rule.getParams() != null && rule.getValues() != null){
			if(rule.getParams().length != rule.getValues().length){
				throw new RuleException("The key-values of parameters are not matched.");
			}
		}
		
	}

}
