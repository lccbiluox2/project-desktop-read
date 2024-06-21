package cn.biluo.showlist;

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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import comman.AddBookToBookSelf;
import comman.ReadBgColor;
import comman.ReadTextColor;
import comman.StateJFrame;
import comman.UpdatedaorubooklistAllreadyRead;

public class ShowContent {
	
public static void showReadCon(String JFlocation, String JFtitle,String tmp){
	
		String[] id = tmp.split("##");
		final String state =JFtitle +"~~" +JFlocation+"~~" +id[0];
		StateJFrame.setStateJFrame(state);
		
		//System.out.println("---------state---------------"+state);
		String[] jlocation = JFlocation.split("\\\\");
		//System.out.println("---------jlocation---------------"+jlocation[0]);
		//System.out.println("---------jlocation---------------"+jlocation[1]);
		//System.out.println("---------id[0]---------------"+id[0]);
		
		final String addID =jlocation[1];//添加书到书架必须的ID
		
		//修改daorubooklist.xml中的已经阅读
		UpdatedaorubooklistAllreadyRead.update(jlocation[1], id[0]);
		
		

		JFrame readjf  = new JFrame();
		readjf.setSize(900, 700);
		readjf.setLocation(400, 200);
		readjf.setTitle(StateJFrame.getStateJFrame());
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
		JPanel panelTextColor  = new JPanel(); //阅读文字颜色
		
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
        panelFontSize.setSize(60, 30);
        panelFontSize.setLocation(620,0);
 		//让字体大小出现下拉列表
 		JComboBox comboBoxFontSize;
 	    String[] FontSzie;
 
 	    FontSzie = new String[6];
 	    FontSzie[0] = "10";
   		FontSzie[1] = "15";
  		FontSzie[2] = "20";
  		FontSzie[3] = "22";
  		FontSzie[4] = "24";
  		FontSzie[5] = "28";
        comboBoxFontSize = new JComboBox(FontSzie);
        comboBoxFontSize.setEditable(false);
        panelFontSize.add(comboBoxFontSize);
        
        /**********************************************/   
        ActionListener listenerTextSize = new ActionListener(){   
             public void  actionPerformed(ActionEvent e) {   
                  JComboBox com = (JComboBox)e.getSource();   
                  String str = (String)com.getSelectedItem();   
                  //System.out.println("----下拉列表----"+str);
                  //////////////////////////////////////
                  ReadContentTextSize.setFontSize(str);
             }   
        };   
        comboBoxFontSize.addActionListener(listenerTextSize);//添加监听器   
        /*********************************************/  
        
        
        
        
      
        //阅读背景颜色选取面板
		panelBgColor.setBackground(Color.orange);
		panelBgColor.setSize(90, 30);
		panelBgColor.setLocation(690,0);
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
				//System.out.println("----------颜色选取器(内部外部不能用)-----------------"+colorReadBackground);
				//System.out.println(colorReadBackground.getRed());
				//System.out.println(colorReadBackground.getGreen());
				//System.out.println(colorReadBackground.getBlue());
				
				String value = colorReadBackground.getRed()+"-"+colorReadBackground.getGreen()+"-"+colorReadBackground.getBlue();
				ReadBgColor.setBgColor(value);
			}
		} );  
		panelBgColor.add(btn);
		
		
		
		
		//阅读文字颜色选取面板
		panelTextColor.setBackground(Color.orange);
		panelTextColor.setSize(90, 30);
		panelTextColor.setLocation(790,0);
		JButton textColor=new JButton("文字颜色" ); 
		final Color colortxt=new Color(200,200,200); 
		textColor.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e)  
			{   
				Color colorReadBackground = JColorChooser.showDialog(null,"请选择你喜欢的颜色" ,colortxt);  
				if (colorReadBackground == null ) {
					colorReadBackground = Color.lightGray;  
				}
				//c.setBackground(color);  
				//c.repaint();   
				//这里已经选好了背景色，下面要引用
				//System.out.println("----------颜色选取器(内部外部不能用)-----------------"+colorReadBackground);
				//System.out.println(colorReadBackground.getRed());
				//System.out.println(colorReadBackground.getGreen());
				//System.out.println(colorReadBackground.getBlue());
				
				String value = colorReadBackground.getRed()+"-"+colorReadBackground.getGreen()+"-"+colorReadBackground.getBlue();
				ReadTextColor.setTextColor(value);
			}

			
			
		} );  
		panelTextColor.add(textColor);
		
		/***********************************************************************/
		//导航条添加点击事件
		
		
		//上一章
		panelPreViewChapter.addMouseListener(new MouseListener() {  

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
				//JOptionPane.showMessageDialog(null, StateJFrame.getStateJFrame(), "注意", 0, null);
				String[] first =state.split("~~");
				int ids = Integer.parseInt(first[2])-1;
				String next = ids +"";
				String loc = first[1];
				String tit = first[0];
				String tmp = first[2];
				ShowContent.showReadCon(loc, tit, next);
			}
		});
		
		
		
		
		
		
		
		//下一章
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
				JOptionPane.showMessageDialog(null, StateJFrame.getStateJFrame(), "注意", 0, null);
				String[] first =state.split("~~");
				int ids = Integer.parseInt(first[2])+1;
				String next = ids +"";
				String loc = first[1];
				String tit = first[0];
				String tmp = first[2];
				ShowContent.showReadCon(loc, tit, next);
			}
		});
		
		//加入书架
		panelbookSelf.addMouseListener(new MouseListener() {  

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
				// 一个弹框，此处不细说其语法
				JOptionPane.showMessageDialog(null, "加入书架", "注意", 0, null);
				AddBookToBookSelf.add(addID);
			}
		});
		
		
		
		/***********************************************************************/
		//将一个个菜单面板加入导航条中
		panel.add(panelFlush);
		panel.add(panelPreViewChapter);
		panel.add(panelNextChapter);
		panel.add(panelbookList);
		panel.add(panelbookSelf);
		panel.add(panelFont);
		panel.add(panelFontSize);
		panel.add(panelBgColor);
		panel.add(panelTextColor);
		
		
		/*********************************************************************/
		//带滚动条的阅读界面
		 JPanel panelContent = new JPanel();
		 panelContent.setLayout(new FlowLayout(FlowLayout.LEFT));
		 panelContent.setPreferredSize(new Dimension(900,8000));//主要是这句代码，设置panel的首选大小，同时保证宽高大于JScrollPane的宽高，这样下面的JScrollPane才会出现滚动条
		
		 
		 
		String con = ReadFileByBookID.readfilebyid(JFlocation,  JFtitle, tmp);
		 
		if(con != null){
				 JTextArea JTextCon = new JTextArea(con);
				 JTextCon.setEditable(false);
				 JTextCon.setLineWrap(true);
				 JTextCon.setWrapStyleWord(true);
				 //下面这一句话前两个是文字相对左上角的距离，后面两个是最后一个是设置文本域大小
				 JTextCon.setBorder (BorderFactory.createEmptyBorder (40,100,1,750));
				 JTextCon.setColumns (30); //设置一行显示多少字
				 JTextCon.setRows (0);//相当于设置文本区组件的初始大小,并不是说一行只能写0
				 
				 
				
			
				 String colorStr = ReadBgColor.getBgColor();
				 Color colorBg = null;
				 if(colorStr == null){
					  colorBg = new  Color(153,204,255);
				 }else{
					 String[] colorStrs = colorStr.split("-");
					 int Red = Integer.parseInt(colorStrs[0]);
					 int Green = Integer.parseInt(colorStrs[1]);
					 int Blue = Integer.parseInt(colorStrs[2]);
					 colorBg = new  Color(Red,Green,Blue);
				 }
				 
	
				 
				
				 String colorText = ReadTextColor.getTextColor();
				 Color colorTxt = null;
				 if(colorText == null){
					 colorTxt = new  Color(0,0,0);
				 }else{
					 String[] colorTexts = colorText.split("-");
					 int Red = Integer.parseInt(colorTexts[0]);
					 int Green = Integer.parseInt(colorTexts[1]);
					 int Blue = Integer.parseInt(colorTexts[2]);
					 colorTxt = new  Color(Red,Green,Blue);
				 }
				 
				 JTextCon.setBackground (colorBg);//文本区背景
				 JTextCon.setForeground (colorTxt);//字体颜色
				 
				 String fontSize = ReadContentTextSize.getFontSize();
				 if(fontSize == null){
					 fontSize = "24";
				 }
				 int fontSizeInt =Integer.parseInt(fontSize);
				 JTextCon.setFont (new Font ("SansSerif", Font.PLAIN, fontSizeInt));
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
	
		//*********************************************************************/
	
		
	}
	/*********************************************************************/
	
}