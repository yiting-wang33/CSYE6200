package bg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class bgUi extends JFrame implements ActionListener {
	
	private Logger log = Logger.getLogger(bgUi.class.getName());
	private JFrame frame = null;
	private JPanel mainPanel = null;
	private JButton startBtn= null;
	private JButton stopBtn= null;
	private JButton resumeBtn= null;
	private JButton pauseBtn= null;
	private JLabel ruleLabel = null;
	private JComboBox jcBox = null;
	private bgCanvas canvas = null;
	
	private JLabel Generation;
	private JTextField Gen;
	
	 private static  Thread  canvasThrd = null;  // Thread created for demonstrating canvas
	 private int     thrdNum = 0;
	
	 bgGenerationSet bgGenSet;
	
	int rule;
	int maxGen;
	//constructor 
	public bgUi() {
		initGUI();
	}
	
	
	private void initGUI() {
		frame = new JFrame();
		frame.setSize(800,800);
		frame.setResizable(true);
		frame.setTitle("Biology Growth AppUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout()); // frame has a borderlayout
		
	    frame.add(getMainPanel(),BorderLayout.NORTH);
	    canvas = new bgCanvas();
	    frame.add(canvas,BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	
	private JPanel getMainPanel() {
		mainPanel = new JPanel();
	    mainPanel.setBackground(Color.pink);//Test line
		
		startBtn = new JButton("Start");
		startBtn.addActionListener(this); //subscribe to button events
		
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(this);
		
		resumeBtn = new JButton("Resume");
		resumeBtn.addActionListener(this);
		
		pauseBtn = new JButton("Pause");
		pauseBtn.addActionListener(this);
		
		Generation = new JLabel("Generation:");
		Gen = new JTextField("10");
		
		mainPanel.add(startBtn); 
	    mainPanel.add(stopBtn);
	    mainPanel.add(resumeBtn); 
	    mainPanel.add(pauseBtn); 
	    
        mainPanel.add(ruleLabel());
        mainPanel.add(jcBox());
        
        mainPanel.add(Generation);
        mainPanel.add(Gen);
       
	    return mainPanel;
		
	}
	
	public JLabel ruleLabel() {
		ruleLabel = new JLabel("Rule:");
		return ruleLabel;
		
	}
	
	public JComboBox jcBox() {
	    String str1[] = {"Rule1","Rule2","Rule3"};  
	    
        jcBox = new JComboBox(str1);
        jcBox.addActionListener(new ActionListener() {
            
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rule = jcBox.getSelectedIndex();
				System.out.println(rule);
				
			}
        	
        });
		return jcBox;
		
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("We received an ActionEvent" +arg0);
		if (arg0.getSource() == startBtn) {
			
			maxGen = Integer.parseInt(Gen.getText());
			bgGenSet = new bgGenerationSet(rule, maxGen);
			canvas.setBgGenSet(bgGenSet);
				

			System.out.println("Start was pressed");
            if(canvasThrd!=null)
                canvasThrd.stop();
            canvasThrd = new Thread( canvas, "canvasThrd"+(thrdNum++) );
            canvasThrd.start();
		
		}
			
		if (arg0.getSource() == stopBtn) {
			System.out.println("Stop was pressed");
            if(canvasThrd!=null)
                canvasThrd.stop();
            canvasThrd = null;
		}
		
		if (arg0.getSource() == resumeBtn) {
			System.out.println("Resume was pressed");
            if( canvasThrd!=null )
                canvasThrd.resume(); 
		}
		
		if (arg0.getSource() == pauseBtn) {	
			System.out.println("Pause was pressed");
            if(canvasThrd!=null)
                canvasThrd.suspend();
		}
			
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		bgUi bgUi = new bgUi();
		System.out.println("App ended!!!!!");
			
	}


	
}

