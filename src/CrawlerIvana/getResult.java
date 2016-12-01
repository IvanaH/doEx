package CrawlerIvana;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class getResult {	
	void getResponce(String sLink, char sType, String RFile){
		BufferedReader rd = null;
		FileWriter fw = null;
				
		try{
			URL url = new URL("http://"+sLink);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
//			if(sType == 'g')
//				con.setRequestMethod("GET");
//			else
//				con.setRequestMethod("POST");
			
			con.setReadTimeout(20*1000);
			con.connect();
			
			//read the output
			if(con.getResponseCode() == 200)
				rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"),1 * 1024 * 1024);
//			    rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			else
				System.out.println("No response from Server.");
			
//			fw = new BufferedWriter(new OutputStreamWriter(RFile),1 * 1024 * 1024);
			fw = new FileWriter(RFile);
			
			String line = null;
	    	line = rd.readLine();
			
		    while (line != null){
		    	fw.append(line+"\r\n");
//		    	fw.write(line+"\r\n");
		    	
		    	line = rd.readLine();
		    }		
		    
		    fw.flush();
		    
		}catch(IOException exc){
			System.out.println("Error occurred when get responce: "+exc);
		}
	}
	
	void CrawlerR(String RFile, String Resultf, String key){
		try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(RFile),"UTF-8"));
				FileWriter fw = new FileWriter(Resultf)){
//			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(
//					    new FileOutputStream(Resultf), "UTF-8")) ){
//			  String sstr = br.readLine();
			  String sstr = "율율율율율";
			  System.out.println(sstr);
		      int i=0;
//			  String rstr = null;
//			  int indx;
//			  
//			  while( (indx = sstr.indexOf(key)) > 0){
//				  sstr.substring(indx);
//				  indx = sstr.indexOf("href=");
//				  rstr = sstr.substring(indx+5, indx+19);
//				  sstr = sstr.substring(indx);
//				  
//				  fw.append(rstr);
//				  indx = 0;
//			  }

			  String reg = "title\">(.*?)(</span>.*?)href=\"(.*?)(\") ";
			  Pattern P = Pattern.compile(reg);
			  Matcher m = P.matcher(sstr);
			  
			  while(m.find()){
				  i++;
				  System.out.print("Find "+i + ": ");
				  if(m.group(1).contains(key)){
					  System.out.println("Match! ");
//					  System.out.println(m.group(1));
					  fw.append(m.group(1));
				      fw.append(": "+"http://daily.zhihu.com"+m.group(3)+"\r\n");
				  }
				  else
					  System.out.println("Not match. ");
			  }
			
		}catch(IOException exc){
			System.out.println("Error occurred: "+exc);
		}
	
	}

}
