package CrawlerIvana;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;


class getResult {
	private String k = null;
	
	void setKey(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the key word");
		k = s.next();
		
		if(!s.hasNextLine())
			s.close();
	}
	
	String getKey(){
		return k;
	}
	
	void getResponce(String sLink, char sType, String RFile){
		BufferedReader rd = null;
		FileWriter fw = null;
				
		try{
			URL url = new URL("http://"+sLink);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if(sType == 'g')
				con.setRequestMethod("GET");
			else
				con.setRequestMethod("POST");
			
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
			
//			fw.append(line+"\r\n");
		    while (line != null){
//		    	fw.append(line+"\r\n");
		    	fw.write(line+"\r\n");
		    	
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
			
			  String sstr = br.readLine();
			  String rstr = null;
			  int indx;
			  
			  while( (indx = sstr.indexOf(key)) > 0){
				  sstr.substring(indx);
				  indx = sstr.indexOf("href=");
				  rstr = sstr.substring(indx+5, indx+19);
				  sstr = sstr.substring(indx);
				  
				  fw.append(rstr);
				  indx = 0;
			  }
			
		}catch(IOException exc){
			System.out.println("Error occurred: "+exc);
		}
	
	}

}
