class Circle{
	private double radius = 0;
	
	Circle(double r){
		radius = r;
	}
	
	//calculate perimeter of circle
	double Perimeter(Circle c){
		return (float)(3.14*c.radius*c.radius);
	}
	
	//calculate square of circle
	double Square(Circle c){
		return (float)(3.14*c.radius*2);
	}
	
	double getRadius(){ return radius;}
	void setRadius(double r){ radius = r;}
}
