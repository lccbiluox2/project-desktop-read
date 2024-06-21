package test;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class JProgressBarDemo extends JFrame{
	JProgressBar progress = new JProgressBar();
	int count= 0;
	class Task extends java.util.TimerTask{

		@Override
		public void run() {
			progress.setValue(count++);
		}
	}
	
	
	public JProgressBarDemo(){
		progress.setStringPainted(true);
		this.getContentPane().add(progress,"North");
		Task task = new Task();
		java.util.Timer timer = new java.util.Timer();
		timer.schedule(task, 100,100);
		this.setSize(500,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void excute(){}
	 public static void main(String[] args){
		 JProgressBarDemo sft = new JProgressBarDemo();
	    	
	    }
}
