import java.util.Scanner;

abstract class Graph {
	protected String paraNL[] = new String[3];
	
//	//set parameter list
//	protected void setPL(String ... a){
//		
//	}
	
	//show the needed parameter in console
	protected void ParaNeed(int i){
		System.out.println("Please enter the "+paraNL[i]+" :");
	}
	
	//get the parameter value from console
	protected double SetPara(){
	
		double m;
		
		Scanner s = new Scanner(System.in);
		
		do{
			m = s.nextDouble();
			if(m<= 0){
				m = 0;
				System.out.println("Please enter a POSITIVE number: ");
			}
		}while(m == 0);
		
		return m;
		
	}
	
	abstract void ParaInfo();
	abstract double Perimeter();
	abstract double Square();
}


