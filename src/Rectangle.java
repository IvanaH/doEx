class Rectangle extends Graph{
	private double width = 0;
	private double length = 0;
	
	Rectangle(double w, double l){
		width = w;
		length = l;
	}
	
	void ParaInfo(){
		System.out.println("The width of this retangle is "+ width 
				+ " and the length is "+length);
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
