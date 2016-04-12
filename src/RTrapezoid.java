class RTrapezoid extends Graph {
	private String[] pNL = {"upperlength","downlength","right-angle side","hypotenuse"};

	private double uplength = 0;
	private double dolength = 0;
	private double ralength = 0;
	private double hylength = 0;

	
	RTrapezoid(){
		paraNL = pNL;
	
		ParaNeed(0);
		setuplength(SetPara());

		ParaNeed(1);
	    setdoLength(SetPara());

		ParaNeed(2);
		setralength(SetPara());

		ParaNeed(3);
		sethylength(SetPara());
		
		while (getralength() > gethylength() ){
			System.out.println(" -- Hypotenuse should be bigger than right-angle side, please enter hypotenuse again :");
			sethylength(SetPara());
		}
	}
	
	void ParaInfo(){
		System.out.println("The upperlength, downlength of this right trapezoid is "+ getuplength() + ", " +getdolength()
	               + " and the right-angle side and hypotenuse  is "+ getralength() + ", "+ gethylength());
	}
	
	
	//calculate perimeter of sector
	double Perimeter(){
		return (float)(uplength+dolength+ralength+hylength);
	}
	
	//calculate square of sector
	double Square(){
		return (float)((uplength+dolength)*ralength/2);
	}
	
	double getuplength(){ return uplength;}
	void setuplength(double l){ uplength = l;}
	double getdolength(){ return dolength;}
	void setdoLength(double w){ dolength = w;}
	double getralength(){ return ralength;}
	void setralength(double w){ ralength = w;}
	double gethylength(){ return hylength;}
	void sethylength(double w){ hylength = w;}

}
