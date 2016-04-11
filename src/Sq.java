class Sq extends Rectangle{		
	protected String[] paraL = {"slength"};

	Sq(){
		super(0);
		
		System.out.println("Please input the length of the square:");
		p = SetPara(1);
		
		if(p[0]<0){
			System.out.println("-- The length of square need to be greater than zero.");
			v = false;
			return;
		}
		else{
			super.setWidth(p[0]);
			super.setLength(p[0]);
		}
	}
	
	void ParaInfo(){
		if(v){
			System.out.println("The side length of this square is "+ width);
		}
	}
}
