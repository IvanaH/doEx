package Hoyt;

import java.util.Scanner;

/**
 * Created by hoyt on 16/3/30.
 */
public class Triangle extends Shape {

    protected double a,b,c;

    protected Triangle(String name, Scanner scanner) throws Exception{
        super(name, scanner);
        System.out.println("请输入三条边");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        checkPositive(a);
        checkPositive(b);
        checkPositive(c);

        System.out.println(String.format("您输入的三条边长分别为:%f,%f,%f",a,b,c));
        doCheck(a,b,c);
    }

    static void doCheck(double a, double b, double c) throws Exception{
        if( a >= (b+c) || b >= (a+c) || c >=(a+b) )
            throw new Exception(String.format("您输入的边长%f,%f,%f无法构成一个有效的三角形",a,b,c));
    }

    @Override
    /**
     * 海伦公式 https://zh.wikipedia.org/zh-cn/%E6%B5%B7%E4%BC%A6%E5%85%AC%E5%BC%8F
     */
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public double getPerimeter() {
        return a+b+c;
    }
}
