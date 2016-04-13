
import java.util.Scanner;

/**
 * Created by hoyt on 16/3/30.
 */
public class Rectangle extends Shape {

    protected double width,height;

    Rectangle(String name, Scanner scanner) throws Exception {
        super(name, scanner);

        if(scanner != null){
            System.out.println("请输入宽度");
            width = scanner.nextDouble();
            System.out.println("请输入高度");
            height = scanner.nextDouble();

            checkPositive(width);
            checkPositive(height);

            System.out.println(String.format("%s的宽度和高度分别为%f和%f",name,width,height));
        }

    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }
}
