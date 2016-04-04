class Sector extends Graph {
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
		
		void ParaInfo(){
			System.out.println("The radius of this sector is "+ radius 
					+ " and the angle is "+angle);
		};
		
		//calculate perimeter of sector
		double Perimeter(){
			return (float)(3.14*radius*radius*angle/360);
		}
		
		//calculate square of sector
		double Square(){
			return (float)(3.14*radius*2*angle/360+2*radius);
		}
		
		double getRadius(){ return radius;}
		void setRadius(double r){ radius = r;}
		double getAngle(){ return angle;}
		void setAngle(double a){ angle = a;}
}
