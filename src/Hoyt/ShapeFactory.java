

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by hoyt on 16/3/30.
 */
public class ShapeFactory {

    public static Shape create(String shapeName,Scanner scanner) throws Exception{
        switch (shapeName.replaceAll("\\s","")){
            case "圆":
                return new Circle(shapeName,scanner);
            case "扇形":
                return new Sector(shapeName,scanner);
            case "长方形":
            case "矩形":
                return new Rectangle(shapeName,scanner);
            case "正方形":
                return new Square(shapeName,scanner);
            case "三角形":
                return new Triangle(shapeName,scanner);
            case "直角梯形":
                return new RTrapezoid(shapeName,scanner);
            //case "椭圆":
            //    return null;
        }
        throw new Exception(String.format("%s暂时不被支持",shapeName));
    }

    static void output(Shape shape, PrintStream stream){
        stream.println(String.format("%s的周长是%f",shape.getName(),shape.getPerimeter()));
        stream.println(String.format("%s的面积是%f",shape.getName(),shape.getArea()));

    }

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.println("请输入您要处理的图形名称");
                Shape shape = create(scanner.next(),scanner);
                output(shape,System.out);
            } catch (Exception e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        }
    }
}
