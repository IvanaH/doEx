public class PeriAndSq{
	public static void main(String args[]) throws java.io.IOException{
		int choice,ignore;
				
		Choose c = new Choose();
		
		for(;;){
			do{				
				c.Info();
			
			    choice = (char) System.in.read();
			
			    do{
			    	ignore = (char) System.in.read();
			    }while( ignore != '\n' );
			}while( !c.isVaild(choice));
			
			if(choice == 'q') break;
			
			//To-do
		    // generate graph according to choice
		c.CreateGraph(choice);
		}
	}
}



