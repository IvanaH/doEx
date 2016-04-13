import java.util.Scanner;


class RTrapezoid extends Shape{
	protected double a,b,c,r;

    protected RTrapezoid(String name, Scanner scanner) throws Exception{
        super(name, scanner);
        System.out.println("请输上边长和下边长");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        System.out.println("请输直角边");
        r = scanner.nextDouble();
        System.out.println("请输斜边");
        c = scanner.nextDouble();

        checkPositive(a);
        checkPositive(b);
        checkPositive(c);
        checkPositive(r);

        System.out.println(String.format("您输入的上边和下边长分别为 %f,%f;",a,b));
        System.out.println(String.format("直角边长为 %f,斜边长为 %f。",r,c));
        doCheck(r,c);
    }

    static void doCheck(double r, double c) throws Exception{
        if( r > c ) 
            throw new Exception(String.format("您输入的斜边长%f小于了直角边长%f",c,r));
    }

    @Override
    public double getArea() {
        return (a+b)*r/2;
    }

    @Override
    public double getPerimeter() {
        return a+b+c+r;
    }

}


