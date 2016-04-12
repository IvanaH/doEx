class Sq extends Rectangle{		
	protected String[] NL = {"slength"};

	Sq(){
		super(0);
		
		paraNL = pNL;
		
		ParaNeed(0);
		setWidth (SetPara());
		setLength (getWidth()); //set length = width
	}
	
	void ParaInfo(){
		System.out.println("The side length of this square is "+ width);
	}
}
