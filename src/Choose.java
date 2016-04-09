class Choose{
	void Info(){
		System.out.println("Choose one graph from the list:");
		System.out.println("1. Circle");
		System.out.println("2. Sector");
		System.out.println("3. Triangle");
		System.out.println("4. Retangle");
		System.out.println("5. Square");
		System.out.print("Choose one (q to quit):");
	}
	
	boolean isVaild(int ch){
		if(ch < '1' | ch > '5' & ch!= 'q'){
			System.out.println("The choice is not legal.");
			System.out.println();
			return false;
		}
		else
			return true;
	}
	
	
	void CreateGraph(int what){
		
		Graph gra = null;
		
		switch(what){
		case '1' :
			gra = new Circle();
			break;
		case '2' :
			gra = new Sector();
			break;
		case '3' :
			gra = new Triangle();
			break;
		case '4' :
			gra = new Rectangle();
			break;
		case '5' :
			gra = new Sq();
			break;
		}
	
		gra.ParaInfo();
		System.out.println("The perimeter is:" + gra.Perimeter());	
		System.out.println("The square is:" + gra.Square());
		System.out.println();
	}
}
