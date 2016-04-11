public class PeriAndSq{
	public static void main(String args[]) throws java.io.IOException{
		int choice;
		Graph g;
		
		Choose c = new Choose();
		
		do{
			choice = c.getChoice();
			if(choice!=-1){
				g = c.CreateGraph(choice);
				c.ShowGraph(g);
			}
		}while (choice!=-1);
	}
}