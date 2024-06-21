package cn.biluo.readbook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;




public class ShowReadList extends JFrame {
	
	
	//显示一个列表页面
	//先将文件信息写入到mybook\book.xml文件中
	//String XMLfileName,xml文件路径
	//String booknameDemo,文件名
	//String locationDemo,文件位置
	//String contentchapterDemo,总章节
	//String allreadyreadDemo已经读过的章节
	String  XMLfileName = "students.xml";
	String  JFrametitle = "十方神王";
	
	String  filename = "十方神王";
	String  booknameDemo = "十方神王";
	String  locationDemo = "mybook";
	String  contentchapterDemo = "28";
	String  allreadyreadDemo = "0";
	
	public ShowReadList(String XMLfileName,String filename, String jFrametitle,String booknameDemo, String locationDemo,String contentchapterDemo, String allreadyreadDemo)throws HeadlessException {
		super();
		this.filename = filename;
		JFrametitle = jFrametitle;
		this.booknameDemo = booknameDemo;
		this.locationDemo = locationDemo;
		this.contentchapterDemo = contentchapterDemo;
		this.allreadyreadDemo = allreadyreadDemo;
		//保存书记的相关信息（名字，位置，阅读章节）
		MyXMLOption  saveToXml =new MyXMLOption();
		try {
			saveToXml.add(XMLfileName, booknameDemo, locationDemo, contentchapterDemo, allreadyreadDemo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**************************************************************/
	public void showList(String targetPath){
		
		
		JFrame readjf  = new JFrame();
		readjf.setSize(900, 700);
		readjf.setLocation(400, 200);
		readjf.setTitle(JFrametitle);
		readjf.setLayout(null);
		readjf.setVisible(true);

		//阅读导航条
		JPanel panel = new JPanel(); 
		// 根据窗口的大小自动改变大小
		panel.setLayout(null);
		panel.setBackground(Color.pink);
		panel.setSize(900, 30);
		panel.setLocation(0,0);
		panel.setLayout(null);
			
		JPanel panelFlush = new JPanel(); 
		JPanel panelContinue = new JPanel(); 
		JPanel panelExport = new JPanel(); 
		JPanel panelbookshelf  = new JPanel(); 
		
		panelFlush.setBackground(Color.orange);
		panelFlush.setSize(50, 30);
		panelFlush.setLocation(10,0);
		panelFlush.add(new Label("刷新",Label.CENTER));
		
		panelContinue.setBackground(Color.orange);
		panelContinue.setSize(100, 30);
		panelContinue.setLocation(70,0);
		panelContinue.add(new Label("继续阅读",Label.CENTER));
		
		panelExport.setBackground(Color.orange);
		panelExport.setSize(100, 30);
		panelExport.setLocation(180,0);
		panelExport.add(new Label("导出小说",Label.CENTER));
		
		panelbookshelf.setBackground(Color.orange);
		panelbookshelf.setSize(100, 30);
		panelbookshelf.setLocation(300,0);
		panelbookshelf.add(new Label("加入书架",Label.CENTER));
		
		panel.add(panelFlush);
		panel.add(panelContinue);
		panel.add(panelExport);
		panel.add(panelbookshelf);
		
		//添加章节列表
		System.out.println("-----------------------添加章节列表------------------------------------");
		
		ExtractionChapter mylist = new ExtractionChapter();
		ArrayList<String> arrlist = mylist.readStoryList(targetPath);
		
		System.out.println("---------------------遍历arrlist----------------------------------------------");
		
		for(String tmp:arrlist){
	          System.out.println(tmp);
	    }
		
		/*******************直接读取数据************************************/

		
		 JPanel panelContent = new JPanel();
		 panelContent.setPreferredSize(new Dimension(900,50000));//主要是这句代码，设置panel的首选大小，同时保证宽高大于JScrollPane的宽高，这样下面的JScrollPane才会出现滚动条
		 for(String tmp:arrlist){
				JButton button = new JButton(tmp); 
				button.setPreferredSize(new Dimension(224, 30));//关键代码,设置按鈕的大小 
				final String chapter = button.getText();
				//为按钮添加点击事件
				button.addMouseListener(new MouseListener() {  

					public void mouseReleased(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
					}

					public void mouseEntered(MouseEvent e) {
					}

					public void mouseClicked(MouseEvent e) {
						
						//传入按钮上面的字体
//						JOptionPane.showMessageDialog(null, chapter, "注意", 0, null);
//						JOptionPane.showMessageDialog(null, filename, "注意", 0, null);
//					
//						// 一个弹框，此处不细说其语法
//						JOptionPane.showMessageDialog(null, "你點擊了按鈕", "注意", 0, null);
//						
						//显示阅读界面
						
						ShowReadContent rdc = new ShowReadContent();
						rdc.showReadCon(filename, chapter);
						
					}
				});
				panelContent.add(button); 
		    }
		  
		readjf.add(panel);
		readjf.add(panelContent);
		  
		JScrollPane scrollPane = new JScrollPane(panelContent);
		scrollPane.setBounds(0, 30, 880, 860);
	    readjf.getContentPane().add(scrollPane);
		readjf.setVisible(true);
		readjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
