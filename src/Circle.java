class Circle extends Graph{
	private double radius = 0;
	
	Circle(double r){
		radius = r;
	}
	
	void ParaInfo(){
		System.out.println("The radius of this circle is "+ radius);
	};
	
	//calculate perimeter of circle
	double Perimeter(){
		return (float)(3.14*radius*radius);
	}
	
	//calculate square of circle
	double Square(){
		return (float)(3.14*radius*2);
	}
	
	double getRadius(){ return radius;}
	void setRadius(double r){ radius = r;}
}
