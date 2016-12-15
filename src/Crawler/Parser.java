package Crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by hoyt on 2016/12/11.
 */
public class Parser {


    /**
     * 解析文件内容
     * @param file
     */
    void parse(File file){
    	try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)),"UTF-8"))){
    		
    	}
    	FileReader fr = new FileReader(file);
    	
    }

    /**
     * 解析字符串内容
     * @param content
     */
    void parse(String content){
    	
    }

    /**
     * 设置url生成器
     * @param generator
     */
    void setGenerator(URLGenerator generator){
    	
    }

    /**
     * 返回当前的URLGenerator
     * @return 
     */
    URLGenerator getGenerator(){
    	
    }
}
