package Crawler;

import java.io.File;

/**
 * Created by hoyt on 2016/12/11.
 */
public class Crawler {

    URLGenerator urls;
    Downloader downloader;
    Parser parser;

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
    }

    public void main(String[] args){
        Crawler crawler = new Crawler();
        crawler.start("http://www.zhihu.com/");
    }
}
