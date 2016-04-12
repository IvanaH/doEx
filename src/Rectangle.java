class Rectangle extends Graph{
	protected String[] pNL = {"width","length"};

	protected double width = 0;
	protected double length = 0;
	
	Rectangle(){
		paraNL = pNL;
	
		ParaNeed(0);
		setWidth (SetPara());

		ParaNeed(1);
		setLength (SetPara());
	}
	
	void ParaInfo(){
		System.out.println("The width of this retangle is "+ width 
	               + " and the length is "+length);
	}
	
	Rectangle(int i){
		length = 0;
		width = 0;
	}
	
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
