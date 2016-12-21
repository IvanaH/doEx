package Crawler;

import java.util.ArrayList;

/**
 * Created by hoyt on 2016/12/11.
 */
public class URLGenerator {
	
	ArrayList<String> urls = new ArrayList<String>();;
	int get = 0;
 
    /**
     * 返回下一个待下载的连接
     * @return
     */
    String next(){
    	String url = null;
    	if(urls.get(get)!= null){
    		url = urls.get(get);
    		get ++;
    	}
    	
    	return url;    	
    }

    /**
     * 将url添加到待抓取的列表
     */
    boolean enqueue(String url){
    	boolean result = false;
    	int i = 0;
    	
    	if( urls.size() == 0){
    		urls.add(url);
    		
    		System.out.println(urls.size());

    		result = true;    		
    	}
    	
    	for(;i<urls.size();i++){
    		if (url.equals(urls.get(i))){
    			result = false;
    			break;
    		}
    	}
    	
    	if( urls.size() == 20 &&i == urls.size()){
    		urls.add(url);
    		result = true;
    	}
    	
    	return result;
    }

}
