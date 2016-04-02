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
		if(ch < '1' | ch > '5' & ch!= 'q')
			return false;
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
		switch(what){
		case '1' :
			Circle ob1 = new Circle(m);
			System.out.println( "The perimeter is "+ob1.Perimeter(ob1));
			System.out.println( "The square is "+ob1.Square(ob1));
			System.out.println();
			break;
		case '2' :
			Sector ob2 = new Sector(m,n);
			System.out.println( "The perimeter is "+ob2.Perimeter(ob2));
			System.out.println( "The square is "+ob2.Square(ob2));
			System.out.println();
			break;
		case '3' :
			Triangle ob3 = new Triangle(m,n,p);
			System.out.println( "The perimeter is "+ob3.Perimeter(ob3));
			System.out.println( "The square is "+ob3.Square(ob3));
			System.out.println();
			break;
		case '4' :
			Rectangle ob4 = new Rectangle(m,n);
			System.out.println( "The perimeter is "+ob4.Perimeter(ob4));
			System.out.println( "The square is "+ob4.Square(ob4));
			System.out.println();
			break;
		case '5' :
			Sq ob5 = new Sq(m);
			System.out.println( "The perimeter is "+ob5.Perimeter(ob5));
			System.out.println( "The square is "+ob5.Square(ob5));
			System.out.println();
			break;
		}		
	}
}
