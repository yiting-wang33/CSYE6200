package bg;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;



public class bgCanvas extends JPanel implements Runnable {
	
    private bgGenerationSet bgGenSet;
    private ArrayList<bgStem> stemPaint;
    bgStem stem;
    private volatile boolean stopped = false;  
    private volatile boolean suspended = false; 
	
	public bgGenerationSet getBgGenSet() {
		return bgGenSet;
	}



	public void setBgGenSet(bgGenerationSet bgGenSet) {
		this.bgGenSet = bgGenSet;
		stemPaint = new ArrayList<>();
	}



	public void paint(Graphics g) {
		

       if( stemPaint!=null && !stopped ) {
           for( int i=0; i<stemPaint.size(); i++ ) {
               stem = stemPaint.get(i);
               // set color
              
               g.setColor(Color.black);
               g.drawLine(stem.x1, stem.y1,stem.x2, stem.y2);
           }
           //stemPaint.clear();
       }		
			
		}





	public void setStem(bgStem stem) {
		this.stem = stem;
	}



	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		while (true) {
            if (!stopped) {
            
            	for (bgGeneration bgGen: bgGenSet.genList) {
        			for (bgStem stem : bgGen.stemList) {
                        stemPaint.add(stem);
                    }
        			repaint();
                 
                    try {
                        if( suspended ) //if pauseBtn
                            wait();
                        else
                            Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                }
                break;  //when painting tree is over, exit run();
            }
            else    //if stopBtn was pressed, break
                break;
        }

	}
	


}