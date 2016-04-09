class Circle extends Graph{
	private double radius = 0;
	private boolean v;
	private double p[];

	Circle(){
		System.out.print("Please input the radius of circle: ");
		
		p = SetPara(1);

		if(p[0]<0){
			System.out.println("-- The radius need to be POSITIVE.");
			v = false;
		}
		radius = p[0];
	}
	
	void ParaInfo(){
		if(!v){
			System.out.println("The radius of this circle is "+ radius);
		}
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
