package sCrawler;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataSource;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.xml.ws.Response;

import org.omg.CORBA.portable.ResponseHandler;


class ExtractService {
	public LinkData extract(Rule rule){
		validateRule(rule);
		
		LinkData data = null;
		
		try{
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
			String[] params = rule.getParams();
			String[] values = rule.getValues();
			String resultTagName = rule.getResultTagName();
			int requestType = rule.getRequestType();
			
			URLConnection con =  url2.openConnection();
			
			con.setReadTimeout(20*1000);
			con.connect();
			
			//read the output
			BufferedReader rd = null;
		
			rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"),1 * 1024 * 1024);
			
			String html = "";
			String line = rd.readLine();
			int i = 1;
			
		    while (line != null){
		    	html = html + line;
		    }
		    
		    //process output of the link
		    String reg = "<a.*href=/"(.+?)/" data-id=/".*/">(.+?)</a>";
			Pattern P = Pattern.compile(reg);
			Matcher m = P.matcher(html);
			  
			while(m.find()){
			  if(m.group(2).contains(values[0])){
				  String s = "http://daily.zhihu.com"+m.group(1);
				  data.setId(i);
				  data.setLinkHref(s);
				  data.setLinkTitle(m.group(2));
				  }
			}

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
