class Sq extends Rectangle{		
	Sq(){
		System.out.println("Please input the length of the square:");
		p = SetPara(1);
		
		if(p[0]<0){
			System.out.println("-- Both length and width need to be greater than zero.");
			v = false;
			return;
		}
		width = p[0];
		length = p[0];
	}
	
	void ParaInfo(){
		if(!v){
			System.out.println("The sides of this square is "+ width);
		}
	}
}
