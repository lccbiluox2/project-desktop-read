package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class myBrowserTest implements ActionListener,HyperlinkListener{

	
		JLabel msgLbl;
		JTextField urlText;
		JEditorPane content;
		JScrollPane JSPanel;
		JPanel panel;
		Container con;
		JFrame mainJframe;
		
		public myBrowserTest(){
			mainJframe = new JFrame("我的浏览器");
			mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			con=mainJframe.getContentPane();
			msgLbl= new JLabel("输入地址");
			urlText =new JTextField();
			urlText.setColumns(20);
			urlText.addActionListener(this);
			panel=new JPanel();
			panel.setLayout(new FlowLayout());
			panel.add(msgLbl);
			panel.add(urlText);
			content=new JEditorPane();
			content.setEditable(false);
			content.addHyperlinkListener(this);
			JSPanel = new JScrollPane(content);
			con.add(panel,BorderLayout.NORTH);
			con.add(JSPanel,null);
			mainJframe.setSize(800, 600);
			mainJframe.setVisible(true);
			mainJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				
				try {
					System.out.println(urlText.getText());
					URL url = new URL(urlText.getText());
			        content.setPage(url);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
		}
		
		
		@Override
		public void hyperlinkUpdate(HyperlinkEvent e) {
			if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
				try {
					URL url = e.getURL();
					content.setPage(url);
					urlText.setText(e.getURL().toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	
		
		public static void main(String[] args){
			new myBrowserTest();
		}
		
	
}
