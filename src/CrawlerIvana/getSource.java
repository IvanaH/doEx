package CrawlerIvana;

import java.io.*;
import java.util.Scanner;

class getSource {
	
	protected String l = null;  //source link of crawler
	protected char ty = 'e'; //request type of link
	
	String sLink(){
		return l;
	}
	
	char rType(){
		return ty;
	}
	
	//get source link and request type from file
	void fromFile(String addr){
		int ch;
		
		try(BufferedReader br = new BufferedReader(new FileReader(addr))){
			do{
				//read characters until a# is found
				ch = br.read();
				if(ch == '#') {
					if (l==null)
						l = br.readLine();
					else if (ty == 'e')
						ty = (char)br.read();
				}
			}while(ch != -1);
			
			if((l==null)||(ty =='e'))
				System.out.println("Can not find source link or request type in file.");
			
		}catch(FileNotFoundException exc){
			System.out.println("Can not find the file.");
		}catch(IOException exc){
			System.out.println("I/O Error: " + exc);
		}
		
	}
	
	//get source link from console
	void getLink(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the source link of crawler: ");

		l = s.next();
						
		if(!s.hasNextLine())
			s.close();
	}
	
	//get request type from console
	void getType(){
		String str;
		
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.println("Please enter the request type of source link (POST/GET): ");
			str = s.next();
			
			if(str.compareToIgnoreCase("post") == 0)
				ty = 'p';
			else if(str.compareToIgnoreCase("get") == 0)
				ty = 'g';
			else
				ty = 'e';
		}while(ty == 'e');
		

		if(!s.hasNextLine())
			s.close();
	}
}
