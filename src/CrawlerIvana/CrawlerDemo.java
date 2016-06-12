package CrawlerIvana;

class CrawlerDemo {
	public static void main(String args[]){
		
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
		
		
	}

}
