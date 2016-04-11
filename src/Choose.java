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
	
	int getChoice() throws java.io.IOException{
		
		int choice,ignore;	
		
		do{				
			Info();
			
			choice = (char) System.in.read();
			
			do{
				ignore = (char) System.in.read();
			}while( ignore != '\n' );
		}while( !isVaild(choice));
			
		if(choice == 'q') return -1;
		
		return choice;
	}
		
	
	Graph CreateGraph(int what){
		
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
		
		return gra;
	}
	
	void ShowGraph(Graph gra){
		gra.ParaInfo();
		if(gra.Perimeter()>0 && gra.Square()>0){
			System.out.println("The perimeter is: " + gra.Perimeter());	
			System.out.println("The square is: " + gra.Square());
		}		
		System.out.println();		
	}
}
