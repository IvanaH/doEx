class Rectangle extends Graph{
	protected String[] paraL = {"width","length"};

	protected double width = 0;
	protected double length = 0;
	protected boolean v;

	Rectangle(){
		ParaNeed(1);
		width = SetPara(1);

		ParaNeed(2);
		length = SetPara(2);
	
		if((width<0)|(length<0)){
			System.out.println("-- Both length and width need to be greater than zero.");
			v = false;
			return;
		}
		else{
			length = 0;
			width = 0;			
		}
	}
	
	void ParaInfo(){
		if(v){
			System.out.println("The width of this retangle is "+ width 
				               + " and the length is "+length);
		}
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
