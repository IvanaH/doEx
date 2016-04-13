import java.util.Scanner;

/**
 * Created by hoyt on 16/3/30.
 */
public class Circle extends Shape {

    protected double radius;

    Circle(String name,Scanner scanner) throws Exception {
        super(name,scanner);
        System.out.println("请输入半径");
        radius = scanner.nextDouble();

        checkPositive(radius);
        System.out.println(String.format("您输入的半径长度为%f",radius));
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
}
