package bg;

import java.util.ArrayList;



public class bgGenerationSet  {
	public ArrayList<bgGeneration> genList;
	int rule;
    
	public bgGenerationSet() {
		
	}
	
	
	public bgGenerationSet(int rule, int maxGen) {
		// TODO Auto-gener ated constructor stub
		genList = new ArrayList<bgGeneration>();
		
		initGen(rule);	
	    
		for (int j=0; j<=maxGen-1;j++) {
			bgGeneration bgGen = new bgGeneration(genList.get(j),j);
			genList.add(bgGen);
		}
	}
	
	
	public void initGen(int rule) {
		bgGeneration rootGen = new bgGeneration();
		rootGen.genRule = rule;
		genList.add(rootGen);
	}
	
	
	public bgGeneration get(int num) {
		return this.genList.get(num);
	}




	  
	
	
}
