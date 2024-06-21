package cn.biluo.readbook;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import cn.biluo.daoRu.DaoRuView;

public class ShowReadContent {
	
	public void showReadCon(final String filename,final String chapter,int readnow){
		

		JFrame readjf  = new JFrame();
		readjf.setSize(900, 700);
		readjf.setLocation(400, 200);
		readjf.setTitle(chapter);
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
		JPanel panelPreViewChapter = new JPanel(); 
		JPanel panelNextChapter = new JPanel(); 
		JPanel panelbookList  = new JPanel(); 
		JPanel panelbookSelf  = new JPanel(); 
		JPanel panelFont  = new JPanel(); //字体下拉列表
		JPanel panelFontSize  = new JPanel(); //字体大小
		JPanel panelBgColor  = new JPanel(); //阅读背景
		
		panelFlush.setBackground(Color.orange);
		panelFlush.setSize(50, 30);
		panelFlush.setLocation(10,0);
		panelFlush.add(new Label("刷新",Label.CENTER));
		
		panelPreViewChapter.setBackground(Color.orange);
		panelPreViewChapter.setSize(100, 30);
		panelPreViewChapter.setLocation(70,0);
		panelPreViewChapter.add(new Label("上一章",Label.CENTER));
		
		panelNextChapter.setBackground(Color.orange);
		panelNextChapter.setSize(100, 30);
		panelNextChapter.setLocation(180,0);
		panelNextChapter.add(new Label("下一章",Label.CENTER));
		
		panelbookList.setBackground(Color.orange);
		panelbookList.setSize(100, 30);
		panelbookList.setLocation(290,0);
		panelbookList.add(new Label("目录",Label.CENTER));
		
		panelbookSelf.setBackground(Color.orange);
		panelbookSelf.setSize(100, 30);
		panelbookSelf.setLocation(400,0);
		panelbookSelf.add(new Label("加入书架",Label.CENTER));
		
		//字体
		panelFont.setBackground(Color.orange);
		panelFont.setSize(100, 30);
		panelFont.setLocation(510,0);
		//让字体出现下拉列表
		 JComboBox comboBox;
	     String[] names;

         names = new String[3];
         names[0] = "微软雅黑";
         names[1] = "宋体";
         names[2] = "隶书";
         comboBox = new JComboBox(names);
         comboBox.setEditable(false);
         panelFont.add(comboBox);
         
      
     
        //字体大小
        panelFontSize.setBackground(Color.orange);
        panelFontSize.setSize(100, 30);
        panelFontSize.setLocation(620,0);
 		//让字体大小出现下拉列表
 		JComboBox comboBoxFontSize;
 	    String[] FontSzie;
 
 	    FontSzie = new String[3];
 	    FontSzie[0] = "特大";
   		FontSzie[1] = "中等";
  		FontSzie[2] = "小";
        comboBoxFontSize = new JComboBox(FontSzie);
        comboBoxFontSize.setEditable(false);
        panelFontSize.add(comboBoxFontSize);
          
		
        //阅读背景颜色选取面板
		panelBgColor.setBackground(Color.orange);
		panelBgColor.setSize(100, 30);
		panelBgColor.setLocation(730,0);
		JButton btn=new JButton("选背景色" ); 
		final Color color=new Color(200,200,200); 
		btn.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e)  
			{   
				Color colorReadBackground = JColorChooser.showDialog(null,"请选择你喜欢的颜色" ,color);  
				if (colorReadBackground == null ) {
					colorReadBackground = Color.lightGray;  
				}
				//c.setBackground(color);  
				//c.repaint();   
				//这里已经选好了背景色，下面要引用
				System.out.println("----------颜色选取器(内部外部不能用)-----------------"+colorReadBackground);
				
			}   
			
		} );  
		panelBgColor.add(btn);
		
		
		
		
		//将一个个菜单面板加入导航条中
		panel.add(panelFlush);
		panel.add(panelPreViewChapter);
		panel.add(panelNextChapter);
		panel.add(panelbookList);
		panel.add(panelbookSelf);
		panel.add(panelFont);
		panel.add(panelFontSize);
		panel.add(panelBgColor);
		
		
		
		

		panelNextChapter.addMouseListener(new MouseListener() {  

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// 一个弹框，此处不细说其语法
				JOptionPane.showMessageDialog(null, "你點擊了按鈕", "注意", 0, null);
				int flag = 2;//设置读的地方 1 读当前点击的章节 2点击下一章 3 点击上一章节
				ShowReadContent rdc = new ShowReadContent();
				rdc.showReadCon(filename, chapter,flag);
				
			}
		});
		
		
		/*********************************************************************/
		//带滚动条的阅读界面
		 JPanel panelContent = new JPanel();
		 panelContent.setLayout(new FlowLayout(FlowLayout.LEFT));
		 panelContent.setPreferredSize(new Dimension(900,8000));//主要是这句代码，设置panel的首选大小，同时保证宽高大于JScrollPane的宽高，这样下面的JScrollPane才会出现滚动条
		
		 
		 
		 
		 ReadThree readthree = new ReadThree();
		 String readContent = null;
		 System.out.println("------------阅读方向------------------"+readnow);
		 if(readnow == 1){
			 System.out.println("------------阅读方向-------读取当前-----------"+readnow);
			 readContent = readthree.readNow(filename, chapter);
		 }else if(readnow == 2){
			 System.out.println("------------阅读方向--------读取下一章----------"+readnow);
			 readContent = readthree.readNextChapter(filename, chapter);
			 String[] readEnd = readContent.split("#");
			 System.out.println("-----------分割后的长度---------"+readEnd.length);
			 String trueTitle = null;
			 for(String in : readEnd){
				 System.out.println(in);
				 if(in.length() < 20){
					 trueTitle = in;
					 break;
				 }
			 }
			 
			 System.out.println("-----------------trueTitle-------------------------"+trueTitle);
			 readContent = trueTitle+"\r\n"+readEnd[0];
			
		 }else if(readnow == 3 ){
			 System.out.println("------------阅读方向----------读取上一张--------"+readnow);
			 readContent = readthree.readNow(filename, chapter);
			
		 }
		 System.out.println("---------最终阅读出来的数据----------------"+readContent);
		
		 
		if(readContent != null){
			 JTextArea JTextCon = new JTextArea(readContent);
			 JTextCon.setEditable(false);
			 JTextCon.setLineWrap(true);
			 JTextCon.setWrapStyleWord(true);
			 //下面这一句话前两个是文字相对左上角的距离，后面两个是最后一个是设置文本域大小
			 JTextCon.setBorder (BorderFactory.createEmptyBorder (40,100,1,750));
			 JTextCon.setColumns (30); //设置一行显示多少字
			 JTextCon.setRows (0);//相当于设置文本区组件的初始大小,并不是说一行只能写0
			 Color colorBg = new  Color(153,204,255);
			 Color colorTxt = new  Color(0,0,0);
			 JTextCon.setBackground (colorBg);//文本区背景
			 JTextCon.setForeground (colorTxt);//字体颜色
			 JTextCon.setFont (new Font ("SansSerif", Font.PLAIN, 25));
			 JTextCon.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			 
			 panelContent.add(JTextCon);
		}
		 

		 

		 
		 
		 
		readjf.add(panel);
		readjf.add(panelContent);
		  
		JScrollPane scrollPane = new JScrollPane(panelContent);
		scrollPane.setBounds(0, 30, 880, 860);
	    readjf.getContentPane().add(scrollPane);
		readjf.setVisible(true);
		readjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		/*********************************************************************/
	
		
	}
	/*********************************************************************/
	
}

