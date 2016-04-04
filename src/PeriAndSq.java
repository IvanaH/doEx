import java.util.Scanner;

public class PeriAndSq{
	public static void main(String args[]) throws java.io.IOException{
		int choice,ignore;
		int times;
		int i = 0;
		
		double m[] = {0,0,0};
		
		Scanner s = new Scanner(System.in); 
		
		Choose c = new Choose();
		
		for(;;){
			do{
				i = 0;
				
				c.Info();
			
			    choice = (char) System.in.read();
			
			    do{
			    	ignore = (char) System.in.read();
			    }while( ignore != '\n' );
			}while( !c.isVaild(choice));
			
			if(choice == 'q') break;
						
			times = c.graphInfo(choice);
			
			do{
				m[i] = s.nextDouble();
				i++;
			}while((i<times)&&s.hasNextDouble());
		    
		    c.CreateGraph(choice,m[0],m[1],m[2]);
		}
		
		s.close();
	}
}



