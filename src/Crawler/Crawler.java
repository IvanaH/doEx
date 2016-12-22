package Crawler;

import java.io.File;


/**
 * Created by hoyt on 2016/12/11.
 */
public class Crawler {

    URLGenerator urls = new URLGenerator();
    Downloader downloader = new Downloader();
    Parser parser = new Parser();
    boolean download;

    public void start(String seed){
        urls.enqueue(seed);
        parser.setGenerator(urls);
        String url = urls.next();
        while(url!=null){
            String randf = Downloader.randomFileName();
            download = downloader.fetch(url, randf);
            if (download){
            	System.out.println(randf);
            	parser.parse(new File(randf));
            }
            url = urls.next();
        }
        
        for(int i = 0; i< urls.urls.size(); i++)
        	System.out.println(urls.urls.get(i));
        
        System.out.println("Done.");
    }

    public static void main(String[] args){
        Crawler crawler = new Crawler();
        crawler.start("http://daily.zhihu.com/");
    }
}
