class Triangle extends Graph{
	private double side1 = 0;
	private double side2 = 0;
	private double side3 = 0;
	
	Triangle(double s1, double s2, double s3){
		if((s1+s2<s3)|(s1+s3<s2)|(s2+s3<s1)){
			System.out.println("--"+ s1 + ", "+ s2 +", "+ s3 +" can not construct a triangle.");
			return;
		}
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}
	
	void ParaInfo(){
		System.out.println("The sides of this triangle is "+ side1 + ", "
				+ side2 + ", "+side3);
	};
	
	//calculate perimeter of triangle
	double Perimeter(){
		return (float)(side1+side2+side3);
	}
	
	//calculate square of triangle
	double Square(){
		double p = (side1+side2+side3)/2;
		return (float)(Math.sqrt(p*(p-side1)*(p-side2)*(p-side3)));
	}
	
	double getSide1(){ return side1;}
	void setSide1(double s){
		if((s+side2<side3)|(s+side3<side2)|(side2+side3<s)){
			System.out.println("--"+ s + ", "+ side2 +", "+ side3 +" can not construct a triangle.");
			return;
		}
		side1 = s;
	}
	double getSide2(){ return side2;}
	void setSide2(double s){
		if((s+side1<side3)|(s+side3<side1)|(side1+side3<s)){
			System.out.println("--"+ side1 + ", "+ s +", "+ side3 +" can not construct a triangle.");
			return;
		}
		side2 = s;
	}
	double getSide3(){ return side3;}
	void setSide3(double s){
		if((s+side1<side2)|(s+side2<side1)|(side1+side2<s)){
			System.out.println("--"+ side1 + ", "+ side2 +", "+ s +" can not construct a triangle.");
			return;
		}
		side3 = s;
	}
}
