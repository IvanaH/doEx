class Rectangle extends Graph{
	protected double width = 0;
	protected double length = 0;
	protected boolean v;
	protected double p[];

	Rectangle(){
		System.out.println("Please input the length and width of the retangle, and using ENTER sperating values:");
		p = SetPara(2);
	
		if((p[0]<0)|(p[1]<0)){
			System.out.println("-- Both length and width need to be greater than zero.");
			v = false;
			return;
		}
		
		length = p[0];
		width = p[1];
	}
	
	void ParaInfo(){
		if(!v){
			System.out.println("The width of this retangle is "+ width 
				               + " and the length is "+length);
		}
	};
	
	//calculate perimeter of sector
	double Perimeter(){
		return (float)((length+width)*2);
	}
	
	//calculate square of sector
	double Square(){
		return (float)(length*width);
	}
	
	double getLength(){ return length;}
	void setLength(double l){ length = l;}
	double getWidth(){ return width;}
	void setWidth(double w){ width = w;}
}
