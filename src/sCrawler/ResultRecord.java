package sCrawler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//using arraylist to keep the links from RFile
class ResultRecord {
	
	//get links from RFile 
	public ArrayList<String> getExistingLinks(String RFile){
		ArrayList<String> existingLinks = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(RFile),"UTF-8"))){
			String regex = "http[s]:\\/\\/.*";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(br.readLine());
			
			while(m.find())
				existingLinks.add(m.group());
			
		}catch (IOException exc) {
			System.out.println(exc);
		}catch (NullPointerException exc2) {  //where would the nullpointer come from 
			exc2.printStackTrace();
		};
		
		return existingLinks;
	}
	
	
	public void record(ArrayList<LinkData> datas, String RFile){
		
		if (datas == null)
			System.out.println("Not found matches.");
		else{
			int j =0;
			boolean isSame = false;
			
			ArrayList<String> existingL = getExistingLinks(RFile);
					
			try (FileWriter fw = new FileWriter(RFile)){
				for(int i=0;i<datas.size();i++){
//					System.out.println(data.getLinkTitle());

					while(j<existingL.size()){
						if (datas.get(i).getLinkHref().equals(existingL.get(j))) {
							isSame = true;
							break;
						}
						j++;
					}
					if(isSame)
						continue;
					else{
						//write data to the RFile
					 fw.append((existingL.size()+1)+": "+datas.get(i).getLinkTitle()+"\r\n");
					 fw.append(datas.get(i).getLinkHref()+"\r\n");
					}
				}			
			}catch (IOException exc) {
				System.out.println(exc);
			}
			
		}
	}

}

