package bg;

public class bgStem {
	
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public double angle;
	public double length;
	public int gen;
	
	public bgStem() {
		
	}
	
	//Constructor
	public bgStem(int x1, int y1,int x2,int y2, double angle,int gen, double length) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.angle = angle;
		this.gen = gen;
		this.length = length;
	}

}
