package CrawlerIvana;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


class getResult {
	private String k;
	
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
		
		try{
			URL url = new URL("http://"+sLink);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if(sType == 'g')
				con.setRequestMethod("GET");
			else
				con.setRequestMethod("POST");
			
			con.setReadTimeout(15*1000);
			con.connect();
			
			//read the output
			if(con.getResponseCode() == 200)
				rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			else
				System.out.println("No response from Server.");
			
			fw = new FileWriter("D:\\JavaL\\WorkSpace\\Practice\\src\\CrawlerIvana\\Result.txt");
			
			String line = null;
		    while ((line = rd.readLine()) != null){
		    	fw.append(line);
		    }
			
			//To-do, find the title contain the key word, then write the followed href info in to the result file
			
			
		}catch(IOException exc){
			System.out.println("Error occurred when get responce: "+exc);
		}
		
	}
}
