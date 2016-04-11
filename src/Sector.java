class Sector extends Circle {
	protected String[] paraL = {"radius","angle"};
	
	private double radius = 0;
	private double angle = 0;
	
	private boolean v;
				
	Sector(){	
		ParaNeed(2);
		angle = SetPara(2);

		if((angle<0)|(angle>360)){
			System.out.println("-- The angle of sector is illegal. ");
			v = false;
			angle = 0;
			return;
		}
	}
		
		
	void ParaInfo(){
		if(v){
			System.out.println("The radius of this sector is "+ radius 
					+ " and the angle is "+angle);
		}
	};
		
	//calculate perimeter of sector
	double Perimeter(){
		return (float)(super.Perimeter()*angle/360+2*radius);
	}
		
	//calculate square of sector
	double Square(){
		return (float)(super.Square()*angle/360);
	}
		
	double getRadius(){ return radius;}
	void setRadius(double r){ radius = r;}
	double getAngle(){ return angle;}
	void setAngle(double a){ angle = a;}
}
