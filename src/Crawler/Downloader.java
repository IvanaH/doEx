package Crawler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

/**
 * Created by hoyt on 2016/12/11.
 */
class Downloader {

    /**
     * 生成随机文件名（UUID）
     * @return
     */
    static String randomFileName(){
    	UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    
    /**
     * 判断url类型为http/https/ftp
     * @param url
     **/
    public static int valid(String url){
    	int i=0;
    	
    	if(url.startsWith("http://")||url.startsWith("https://"))
    			i = 1;
    	else if(url.startsWith("ftp://"))
    			i = 2;
    	else if(url.isEmpty())
			System.out.println ("Finish! ");			
    	else 
			System.out.println ("The format of the url is wrong.");			
		
    	return i;
    }
    

    /**
     * 根据给定的url下载对应的资源，并保存到savepath
     *
     * @param url
     * @param savepath
     * @return
     */
    protected boolean fetch(String url, String savepath){
    	boolean flag = false;
    	String html = null;
    	String line = null;
    	String addr = null;
    	
    	//1:http/https  2:ftp
    	int i = valid(url);
    	
    	addr = "./"+randomFileName();
    	
    	try{
    		URL u = new URL(url);
    		URLConnection con = u.openConnection();
    		
    		con.setReadTimeout(20*1000);
			con.connect();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"),1 * 1024 * 1024);
			
			while((line = br.readLine())!=null)
				html = html + line;
			
			FileWriter fw = new FileWriter(addr);
			fw.write(html+"\r\n");
				
    	}catch(FileNotFoundException exc1){
    		System.out.println(exc1);
    	}catch(MalformedURLException exc2){
    		System.out.println(exc2);
    	}catch(IOException exc3){
    		System.out.println(exc3);
    	}
    	
    	return flag;
    }
    
}

