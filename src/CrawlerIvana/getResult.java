package CrawlerIvana;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class getResult {
	private String k;
	private String RFile = null;
	private String Resultf = "D:\\JavaL\\WorkSpace\\Practice\\src\\CrawlerIvana\\CResult.txt";
	
	void setKey(String keys){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the key word");
		k = s.next();
		
		if(!s.hasNextLine())
			s.close();
	}
	
	void getResponce(String sLink, char sType){
		BufferedReader rd = null;
		FileWriter fw = null;
		RFile = "D:\\JavaL\\WorkSpace\\Practice\\src\\CrawlerIvana\\Result.txt";
		
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
				rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			else
				System.out.println("No response from Server.");
			
			fw = new FileWriter(RFile);
			
			String line = null;
			
//			fw.append(line+"\r\n");
		    while ((line = rd.readLine()) != null){
		    	fw.append(line+"\r\n");
		    }			
		}catch(IOException exc){
			System.out.println("Error occurred when get responce: "+exc);
		}
	}
	
	void getR(String RFlie, String Resultf, String key){
		try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(RFile),"UTF-8"));
				FileWriter fw = new FileWriter(Resultf)){
			
			  Pattern p=Pattern.compile(key);
			  Matcher m=p.matcher(br.readLine());
			  
			  while(m.find()){
			   
			  }
			
		}catch(IOException exc){
			System.out.println("Error occurred: "+exc);
		}
	
	}

}
