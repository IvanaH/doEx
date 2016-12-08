package sCrawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class WriteService {
	public void writeFile(ArrayList<LinkData> datas,ArrayList<String> existingLinks, String RFile){
		
		if (datas == null)
			System.out.println("Not found matches.");
		else{
			int j =0;
			boolean isSame = false;
			
				
			try (FileWriter fw = new FileWriter(RFile, true)){
				for(int i=0;i<datas.size();i++){
//					System.out.println(data.getLinkTitle());

					while(j<existingLinks.size()){
						if (datas.get(i).getLinkHref().equals(existingLinks.get(j))) {
							isSame = true;
							break;
						}
						j++;
					}
					if(isSame)
						continue;
					else{
						//write data to the RFile
					 fw.append((existingLinks.size()+i+1)+": "+datas.get(i).getLinkTitle()+"\r\n");
					 fw.append(datas.get(i).getLinkHref()+"@"+"\r\n");
					}
				}			
			}catch (IOException exc) {
				System.out.println(exc);
			}
			
		}
	}
}
