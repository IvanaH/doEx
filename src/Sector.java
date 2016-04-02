class Sector {
		private double radius = 0;
		private double angle = 0;
		
		Sector(double r, double a){
			if((a<0)|(a>360)){
				System.out.println("-- The angle of sector is illegal. ");
				return;
			}
			radius = r;
			angle = a;
		}
		
		//calculate perimeter of sector
		double Perimeter(Sector s){
			return (float)(3.14*s.radius*s.radius*s.angle/360);
		}
		
		//calculate square of sector
		double Square(Sector s){
			return (float)(3.14*s.radius*2*s.angle/360+2*s.radius);
		}
		
		double getRadius(){ return radius;}
		void setRadius(double r){ radius = r;}
		double getAngle(){ return angle;}
		void setAngle(double a){ angle = a;}
}
