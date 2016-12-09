package sCrawler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExistingLinks {
	//get links from RFile 
		public ArrayList<String> getExistingLinks(String RFile){
			ArrayList<String> existingLinks = new ArrayList<String>();
			
			try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(RFile),"UTF-8"))){
				String s = "";
				String line = null;
				
				while ((line = br.readLine())!=null) {
					s = s+line+"\n";					
				}
				
//				String s = br.readLine();
				System.out.println(s);
				
				String regex = "https?:\\/\\/.+";
				Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(s);
				
				while(m.find())
//					System.out.println(m.group());
					existingLinks.add(m.group());
				
//				String line = null;
//
//				String regex = "https?:\\/\\/.+";
//				Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//				
//				while ((line = br.readLine())!=null) {
//					Matcher m = p.matcher(line);
//					if(m.find())
//						existingLinks.add(m.group());
//				}
				
				
			}catch (IOException exc) {
				System.out.println(exc);
			}catch (NullPointerException exc2) {  //where would the nullpointer come from 
				exc2.printStackTrace();
			};
			
			return existingLinks;
		}
}
