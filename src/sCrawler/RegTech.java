package sCrawler;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hoyt on 2016/12/8.
 */
public class RegTech {

    public static String readAll(String file) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        return readAll(file,"utf-8");
    }

//    public static String readAll(String file, String encoding) throws FileNotFoundException, UnsupportedEncodingException {
//        File f = new File(file);
//        byte[] data = new byte[new Long(f.length()).intValue()];
//        FileInputStream stream = new FileInputStream(f);
//    	
//        try {
//            stream.read(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new String(data, encoding);
//    }
    
    public static String readAll(String file, String encoding) throws FileNotFoundException, UnsupportedEncodingException, IOException {
  	BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(file),"UTF-8"));
  	String data = "";
		String line = null;
		
		while ((line = br.readLine())!=null) {
			data = data+line;					
		}
      return data;
  }


    /**
     * 这里是一次性将所有文本读出，然后存储到一个字符串里，此时不可使用^$来匹配头尾了，只需要将http的表达式加以匹配
     * 然后用matcher循环查询即可，但这样做可能会存在问题，如果标题中存在http地址，也会被牵扯出来
     */
    public static void test1() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String data = readAll("D:\\JavaL\\WorkSpace\\Practice\\src\\sCrawler\\1.txt");
        Pattern p = Pattern.compile("https?:\\/\\/.+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(data);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println("========test 1执行完毕========");
    }

    /**
     * 由于是文本文件，还可以逐行读出，这样做就可以避免非行首的url被匹配进来了，
     * 这两种方式各有优劣，好好体会
     * @throws IOException
     */
    public static void test2() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("D:\\JavaL\\WorkSpace\\Practice\\src\\sCrawler\\1.txt"));
        String line = f.readLine();
        while(line!=null){
            if(line.matches("(?i)^https?:\\/\\/.+$")){
                System.out.println(line);
            }
            line = f.readLine();
        }
        System.out.println("========test 2执行完毕========");
    }

    public static void main(String[] args) throws IOException {
            test1();
            test2();
    }
}
