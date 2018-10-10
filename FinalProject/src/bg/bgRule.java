package bg;

public class bgRule {
	private double dAngle; 
	private int branch;  //how mang children the stem will grow
	private double lRatio;

    public bgRule() {
    	
    }
    
    

	public bgRule(double dAngle, int branch, double lRatio) {
		this.dAngle = dAngle;
		this.branch = branch;
		this.lRatio = lRatio;
	}
	
	

	

	
	public void rule1(bgGeneration bgGen, bgStem dadStem) {
		//angle is 45, has two child
		bgRule rule1 = new bgRule(45,2,1.5);
		bgGen.stemList.add(growbranch(dadStem,rule1,rule1.dAngle));
		bgGen.stemList.add(growbranch(dadStem,rule1,-rule1.dAngle));
	}
	
	public void rule2(bgGeneration bgGen, bgStem dadStem) {
		//angle is random from 30 to 60 degree, has two child
	    bgRule rule2 = new bgRule((int)(Math.random()*30)+30,2,1.5);
	    bgGen.stemList.add(growbranch(dadStem,rule2,rule2.dAngle));
	    bgGen.stemList.add(growbranch(dadStem,rule2,-rule2.dAngle));
	}
	
	public void rule3(bgGeneration bgGen, bgStem dadStem) {
		//angle is 30 degree, has three child
		bgRule rule3 = new bgRule((int)(Math.random()*30)+30,3,1.5);
		bgGen.stemList.add(growbranch(dadStem,rule3,rule3.dAngle));
		bgGen.stemList.add(growbranch(dadStem,rule3,0));
		bgGen.stemList.add(growbranch(dadStem,rule3,-rule3.dAngle));
	}

    public bgStem growbranch(bgStem dadStem, bgRule myrule, double angle) {
    	    
    	    bgStem newBranch = new bgStem();
    	    newBranch.x1 = dadStem.x2;
    	    newBranch.y1 = dadStem.y2;
    	    newBranch.angle = dadStem.angle-angle;
    	    newBranch.length = dadStem.length/myrule.lRatio;
    	    newBranch.gen = dadStem.gen+1;
    	    
    	    newBranch.x2 = getX2(newBranch.x1,newBranch.angle,newBranch.length);
    	    newBranch.y2 = getY2(newBranch.y1,newBranch.angle,newBranch.length);
		return newBranch;
    	
    }
	
	public int getX2(int x1, double angle, double length) {
		int x2 = x1 - (int) (Math.cos(Math.toRadians(angle))*length);
		return x2;
	}
	
	public int getY2(int y1, double angle, double length) {
		int y2 = y1 - (int) (Math.sin(Math.toRadians(angle))*length);
		return y2;
	}
	
	
	

	
	

}

