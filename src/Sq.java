class Sq extends Rectangle{	
	private double slength = 0;
	
	Sq(double a){
		super(a,a);
		slength = a;
	}
	
	void ParaInfo(){
		System.out.println("The sides of this square is "+ slength);
	};
}
