import java.util.Scanner;

abstract class Graph {
	//get the parameter value from console
	protected double[] SetPara(int i){
		double m[] = {0,0,0};
		int n = 0;
		
		Scanner s = new Scanner(System.in); 

		do{
			m[n] = s.nextDouble();
			n++;
		}while((n < i)&&s.hasNextDouble());
				
		return m;
	}	
	
	abstract void ParaInfo();
	abstract double Perimeter();
	abstract double Square();
}