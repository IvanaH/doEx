class Circle extends Graph{
	protected String[] paraL = {"radius"};
	
	private double radius = 0;
	private double m;
	private boolean v;

	Circle(){
		ParaNeed(1);
		radius = SetPara(1);

		if(m <0){
			System.out.println("-- The radius need to be POSITIVE.");
			radius = 0;
			v = false;
		}
	}
	
	void ParaInfo(){
		if(v){
			System.out.println("The radius of this circle is "+ radius);
		}
	}
	
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

