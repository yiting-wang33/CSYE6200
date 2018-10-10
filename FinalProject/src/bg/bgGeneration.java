package bg;

import java.util.ArrayList;

public class bgGeneration {
    
	public ArrayList<bgStem> stemList = new ArrayList<bgStem>();
	public int genRule;
	 int gen;

	public bgGeneration() {
	   bgStem rootStem = new bgStem(400, 800, 400, 600, 90, 0,200);
	   stemList.add(rootStem);
	   this.gen = 0;
	}
	
	public bgGeneration(bgGeneration dadGen,int DadGen) {
		//set up rule of this generation
		
		this.genRule = dadGen.genRule;
	    this.gen = dadGen.gen+1;
	    
	    //grow its child 
	    for (bgStem dadStem: dadGen.stemList) {
	    	
	    	    bgRule myrule = new bgRule();
	    	    
	    	   switch (this.genRule) {
	    	   case 0:
	    		 	myrule.rule1(this, dadStem);
	    		 	break;
	    	   case 1:
	    			myrule.rule2(this, dadStem);
	    			break;
	    	   case 2:
	    		   myrule.rule3(this, dadStem);
	    		   break;
	    	   }
	  
		}
	}
	
	public bgStem get(int num) {
		return this.stemList.get(num);
		
	}
	
	
	
	
}

