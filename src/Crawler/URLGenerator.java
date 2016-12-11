package Crawler;

/**
 * Created by hoyt on 2016/12/11.
 */
public interface URLGenerator {

    /**
     * 返回下一个待下载的连接
     * @return
     */
    String next();

    /**
     * 将url添加到带抓取的列表
     */
    boolean enqueue(String url);

}
