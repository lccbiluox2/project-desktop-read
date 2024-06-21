package cn.biluo.readbook;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ShowReadContent {
	
	public void showReadCon(String filename,String chapter){
		

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
		
		
		/*********************************************************************/
		//带滚动条的阅读界面
		 JPanel panelContent = new JPanel();
		 panelContent.setLayout(new FlowLayout(FlowLayout.LEFT));
		 panelContent.setPreferredSize(new Dimension(900,8000));//主要是这句代码，设置panel的首选大小，同时保证宽高大于JScrollPane的宽高，这样下面的JScrollPane才会出现滚动条
		
		 
		 
		 
		 
		String filenames = filename+".txt";
		System.out.println(filenames);
		File file = new File(filenames);
		BufferedReader reader = null;
		
		String readContent = null;//存储读出的所有有用数据
		try{
			System.out.println("------------------以行为单位读取数据到阅读面板---------------------------");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			
			System.out.println("------------读入的数据---------------------");
			
			/************************************************************/
			boolean flag = true;//定义不继续读取的标志
			while(((tempString = reader.readLine()) != null) && (flag)){
				
				//判断开始读取的地方
					if(tempString.length() < 20  && tempString.length() > 3 && (tempString != "")){
						if(tempString.startsWith("第")){
						     String[] StoryName = tempString.split(" ");
						     String myStoryName = StoryName[0]; 
						     if(myStoryName.endsWith("章")){
						    	 if(chapter.startsWith(myStoryName)){
						    		 System.out.println("读入的数据-----2"+tempString);
						    		 
						    		 readContent = readContent+ tempString+"\r\n";
						    		 //这里是为了显示每章节的标题
						    		 
						    		 /*******************/
						    		 //判断结束读取的地方
						    		 String readString = null;
						    		 String readStringChapter = null ;
						    		 while(( readStringChapter = reader.readLine()) != null  && (flag) ){
						    			  String[] readEnd = readStringChapter.split(" ");
										  String readEndFirst = StoryName[0];
						    			 if(readStringChapter.startsWith("第") && (readEndFirst.endsWith("章")) ){
										    	//说明读到了下一章节的开始
										    	 flag =false;
										     
						    			 }else{
										    	//否者就将读取到的数据显示
												 System.out.println("读入的数据------3"+readStringChapter);
												 //遇到问题，如何让读入的数据换行
												readContent = readContent + readStringChapter+"\r\n";
												
										 }
						    		 }
						    		 
						    		 /*******************/
						    	 }
						    	
						     }
						}
					}
			}
			
			
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
			 

			 

			/************************************************************/
			reader.close();
		}catch(IOException e){}
		finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {e.printStackTrace();}
			}
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

