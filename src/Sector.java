class Sector extends Graph {
		private double radius = 0;
		private double angle = 0;
		private double p[];
		private boolean v;
				
		Sector(){
			System.out.println("Please input the radius and angle of the sector, and using ENTER sperating values: ");
			p = SetPara(2);
						
			if((p[1]<0)|(p[1]>360)){
				System.out.println("-- The angle of sector is illegal. ");
				v = false;
				return;
			}		

			radius = p[0];
			angle = p[1];
		}
		
		
		void ParaInfo(){
			if(!v){
				System.out.println("The radius of this sector is "+ radius 
						+ " and the angle is "+angle);
			}
		};
		
		//calculate perimeter of sector
		double Perimeter(){
			return (float)(3.14*radius*2*angle/360+2*radius);
		}
		
		//calculate square of sector
		double Square(){
			return (float)(3.14*radius*radius*angle/360);
		}
		
		double getRadius(){ return radius;}
		void setRadius(double r){ radius = r;}
		double getAngle(){ return angle;}
		void setAngle(double a){ angle = a;}
}
