package Crawler;

import java.io.File;

/**
 * Created by hoyt on 2016/12/11.
 */
public class Crawler {

    URLGenerator urls = new URLGenerator();
    Downloader downloader = new Downloader();
    Parser parser = new Parser();

    public void start(String seed){
        urls.enqueue(seed);
        parser.setGenerator(urls);
        String url = urls.next();
        while(url!=null){
            String randf = Downloader.randomFileName();
            downloader.fetch(url, randf);
            parser.parse(new File(randf));
            url = urls.next();
        }
        
        System.out.println("Done.");
    }

    public static void main(String[] args){
        Crawler crawler = new Crawler();
        crawler.start("http://daily.zhihu.com");
    }
}
