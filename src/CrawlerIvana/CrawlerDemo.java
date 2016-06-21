package CrawlerIvana;

class CrawlerDemo {
	public static void main(String args[]){
		String Resultf = "D:\\JavaL\\WorkSpace\\Practice\\src\\CrawlerIvana\\CResult.txt";
		String RFile = "D:\\JavaL\\WorkSpace\\Practice\\src\\CrawlerIvana\\Result.txt";
		
		//get source link and request type from parameter or console
		getSource gs = new getSource();
		
		if(args.length == 1)
			gs.fromFile(args[0]);
		else{
			gs.getType();
			gs.getLink();
		}
		
				
//		setRules sr = new setRules(gs.sLink(),gs.rType());
		
		getResult gr = new getResult();
		
		gr.getResponce(gs.sLink(),gs.rType(),RFile);
		
		gr.setKey();
		
		gr.CrawlerR(RFile, Resultf, gr.getKey());
		
		System.out.println("Hi");
	}

}
