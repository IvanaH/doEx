package Crawler;

/**
 * Created by hoyt on 2016/12/11.
 */
public interface Downloader {

    /**
     * 生成随机文件名（UUID）
     * @return
     */
    static String randomFileName(){
        return null;
    }

    /**
     * 根据给定的url下载对应的资源，并保存到savepath
     *
     * @param url
     * @param savepath
     * @return
     */
    boolean fetch(String url, String savepath);


}
