/*
 * 	实现LA的进度条显示
 * 	@Author: JJN(GWYOG)
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class progressWindow extends JFrame{
	
	private JFrame progressFrame;
	private JProgressBar progressBar;
	private mainFrame parentFrame;
	private int maxStageNumber;
	private int stageNumber = 0;
	private double progressValue = 0;
	
	
	public progressWindow(mainFrame parentFrame, int maxStageNumber){
		super("进度");
		this.maxStageNumber = maxStageNumber;
		this.parentFrame = parentFrame;
		
		//frame
		progressBar = new JProgressBar();
		int x=(int) (parentFrame.getLocation().getX() + parentFrame.getWidth()/4);
		int y=(int) (parentFrame.getLocation().getY() + parentFrame.getHeight()/2);
		this.setLocation(x, y);
		this.setSize(250, 70);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		this.setAlwaysOnTop(true);
		//add
		this.getContentPane().add(progressBar);
		
		//progressBar
	    progressBar.setMinimum(0);
	    progressBar.setMaximum(100);
	    progressBar.setValue(0);
	    progressBar.setStringPainted(true);
	}
	
	public void addValue(){
		stageNumber += 1;
		progressValue += 100 / maxStageNumber;
		System.out.println(progressValue);
		if(stageNumber == maxStageNumber)
		{
			progressBar.setValue(100);
		    this.dispose();
			JOptionPane.showMessageDialog(parentFrame, "Done！", "完成", JOptionPane.INFORMATION_MESSAGE);
		}
		else
			progressBar.setValue((int)progressValue);
	}

}
