package sCrawler;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;


class ExtractService {
	public LinkData extract(Rule rule){
		validateRule(rule);
		
		LinkData data = null;
		
		try{
			//analyzing rule
			URL url2 = new URL(rule.getUrl());
			String[] params = rule.getParams();
			String[] values = rule.getValues();
			String resultTagName = rule.getResultTagName();
			int requestType = rule.getRequestType();
			
			Connection con =  url2.openConnection();
			
			con.setReadTimeout(20*1000);
			con.connect();
			
			if(params != null){
				for(int i =0; i< params.length;i++){
					//
				}
			}
			
			Document doc = null;
			doc = con.getURL();
			
			//read the output
//			BufferedReader rd = null;
//			FileWriter fw = null;
//			
//			if(con.getResponseCode() == 200)
//				rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"),1 * 1024 * 1024);
//			else
//				System.out.println("No response from Server.");
//			
////			fw = new BufferedWriter(new OutputStreamWriter(RFile),1 * 1024 * 1024);
//			fw = new FileWriter(RFile);
//			
//			String line = null;
//	    	line = rd.readLine();
//			
//		    while (line != null){
//		    	fw.append(line+"\r\n");
////		    	fw.write(line+"\r\n");
//		    	
//		    	line = rd.readLine();
//		    }		
//		    
//		    fw.flush();
			


		}catch (IOException e){
			e.printStackTrace();
		}
				
		return data;
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
