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
	
	int graphInfo(int what){		
		switch(what){
		case '1' :
			System.out.print("Please input the radius of circle: ");
			return 1;
		case '2' :
			System.out.println("Please input the radius and angle of the sector, and using ENTER sperating values: ");
			return 2;
		case '3' :
			System.out.println("Please input the sides of the triangle, and using ENTER sperating values: ");
			return 3;
		case '4' :
			System.out.println("Please input the length and width of the retangle, and using ENTER sperating values:");
			return 2;
		case '5' :
			System.out.println("Please input the length of side of the square, and using ENTER sperating values: ");
			return 1;
		}
		return 0;
	}
	
	void CreateGraph(int what, double m, double n, double p){
		Graph gra = new Circle(0);
		
		switch(what){
		case '1' :
			gra = new Circle(m);
			break;
		case '2' :
			gra = new Sector(m,n);
			break;
		case '3' :
			gra = new Triangle(m,n,p);
			break;
		case '4' :
			gra = new Rectangle(m,n);
			break;
		case '5' :
			gra = new Sq(m);
			break;
		}
		String GraphTy[] = {"Circle","Sector","Triangle","Retangle","Square" };  // char-int, to void out-of-bound
		
		gra.ParaInfo();
		System.out.println("The perimeter of this "+ GraphTy[what-49]+" is:" + gra.Perimeter());	
		System.out.println("The square of this "+ GraphTy[what-49]+" is:" + gra.Square());
		System.out.println();
	}
}
