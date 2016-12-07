package sCrawler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ResultRecordOld {
	//get the counts of existing items in RFile 
	public String[] getExistingLinks(String RFile){
		ArrayList<String> Links = null;
		String[] existingLinks = null;
		
		try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(RFile),"UTF-8"))){
			String regex = "http[s]:\\/\\/.*";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(br.readLine());
			
			while(m.find())
				Links.add(m.group());
			
		}catch (IOException exc) {
			System.out.println(exc);
		};
		
		existingLinks = Links.toArray(existingLinks);
		
		return existingLinks;
	}
	
	
	public void record(LinkData[] datas, String RFile){
		//To-do, to exclude the same links in datas
		int j =0;
		boolean isSame = false;
		
		String[] existingL = getExistingLinks(RFile);
		int oldLength = existingL.length;
		int newLength = existingL.length;
		
		try (FileWriter fw = new FileWriter(RFile)){
			for(LinkData data:datas){
				while(j<oldLength){
					if (data.getLinkHref().equals(existingL[j])) {
						isSame = true;
						break;
					}
					j++;
				}
				if(isSame)
					continue;
				else{
					//write data to the RFile
				 fw.append((newLength+1)+": "+data.getLinkTitle()+"\r\n");
				 fw.append(data.getLinkHref()+"\r\n");
				 newLength++;
				}
			}			
		}catch (IOException exc) {
			System.out.println(exc);
		};
		
	}

}