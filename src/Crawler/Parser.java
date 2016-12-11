package Crawler;

import java.io.File;

/**
 * Created by hoyt on 2016/12/11.
 */
public interface Parser {


    /**
     * 解析文件内容
     * @param file
     */
    void parse(File file);

    /**
     * 解析字符串内容
     * @param content
     */
    void parse(String content);

    /**
     * 设置url生成器
     * @param generator
     */
    void setGenerator(URLGenerator generator);

    /**
     * 返回当前的URLGenerator
     * @return
     */
    URLGenerator getGenerator();
}
