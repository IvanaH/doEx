
import java.util.Scanner;

/**
 * Created by hoyt on 16/3/30.
 */
public class Sector extends Circle {

    protected double angle = 0;

    Sector(String name, Scanner scanner) throws Exception {
        super(name, scanner);

        System.out.println("请输入圆心角度数");
        angle = scanner.nextDouble();

        checkPositive(angle);
        if(angle > 360){
            throw new Exception("圆心角度数不能超过360!");
        }

        System.out.println(String.format("您输入的圆心角度数为%f",angle));
    }

    @Override
    public double getArea() {
        return super.getArea()*(angle/360.0);
    }

    @Override
    public double getPerimeter() {
        return 2*radius+(angle/360.0)*super.getPerimeter();
    }
}
