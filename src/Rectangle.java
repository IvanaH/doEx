class Rectangle {
	private double width = 0;
	private double length = 0;
	
	Rectangle(double w, double l){
		width = w;
		length = l;
	}
	
	//calculate perimeter of sector
	double Perimeter(Rectangle r){
		return (float)((r.length+r.width)*2);
	}
	
	//calculate square of sector
	double Square(Rectangle r){
		return (float)(r.length*r.width);
	}
	
	double getLength(){ return length;}
	void setLength(double l){ length = l;}
	double getWidth(){ return width;}
	void setWidth(double w){ width = w;}
}
