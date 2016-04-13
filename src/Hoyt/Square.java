
import java.util.Scanner;

/**
 * Created by hoyt on 16/3/30.
 */
public class Square extends Rectangle {

     Square(String name, Scanner scanner) throws Exception {
        super(name, null);
        System.out.println("请输入边长");
         width = scanner.nextDouble();
         height = width;
         System.out.println(String.format("您输入的边长为%f",width));
    }
}
