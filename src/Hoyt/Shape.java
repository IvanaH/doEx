package Hoyt;

import java.util.Scanner;

/**
 * Created by hoyt on 16/3/30.
 */
public abstract class Shape {
    protected String name;

    protected Shape(String name, Scanner scanner){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public static void checkPositive(double d) throws Exception{
        if(d <= 0.0000001)
            throw new Exception(String.format("数值不合法，%f<=0不能成为有效输入值",d));
    }
}
