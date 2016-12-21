package Crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by hoyt on 2016/12/11.
 */
public class Parser {
	URLGenerator urlGenerator;


    /**
     * 解析文件内容
     * @param file
     */
    void parse(File file){
    	try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))){
    		String line = null;
    		String s = null;
    		
    		if((line = br.readLine())!= null)
    			s = s+line;
    		
    		if(s == null)
    			System.out.println( file.getName()+" is null.");
    		else
    			parse(s);
    		
    	}catch (FileNotFoundException exc1) {
			exc1.printStackTrace();
		}catch (IOException exc2) {
			exc2.printStackTrace();
		}
    	
    }

    /**
     * 解析字符串内容
     * @param content
     */
    void parse(String content){
    	String reg = "(http|https)://daily.zhihu.com/story/.*";
    	Pattern p = Pattern.compile(reg);
    	Matcher m = p.matcher(content);
    	
    	while(m.find()){
    		getGenerator().enqueue(m.group());
    	}
    	
    }

    /**
     * 设置url生成器
     * @param generator
     */
    void setGenerator(URLGenerator generator){
    	this.urlGenerator = generator;
    	
    }

    /**
     * 返回当前的URLGenerator
     * @return 
     */
    URLGenerator getGenerator(){
    	return urlGenerator;
    	
    }
}
