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
		
		final String addID =jlocation[1];//����鵽��ܱ����ID
		
		//�޸�daorubooklist.xml�е��Ѿ��Ķ�
		UpdatedaorubooklistAllreadyRead.update(jlocation[1], id[0]);
		
		

		JFrame readjf  = new JFrame();
		readjf.setSize(900, 700);
		readjf.setLocation(400, 200);
		readjf.setTitle(StateJFrame.getStateJFrame());
		readjf.setLayout(null);
		readjf.setVisible(true);
		
	

		//�Ķ�������
		JPanel panel = new JPanel(); 
		// ���ݴ��ڵĴ�С�Զ��ı��С
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
		JPanel panelFont  = new JPanel(); //���������б�
		JPanel panelFontSize  = new JPanel(); //�����С
		JPanel panelBgColor  = new JPanel(); //�Ķ�����
		JPanel panelTextColor  = new JPanel(); //�Ķ�������ɫ
		
		panelFlush.setBackground(Color.orange);
		panelFlush.setSize(50, 30);
		panelFlush.setLocation(10,0);
		panelFlush.add(new Label("ˢ��",Label.CENTER));
		
		panelPreViewChapter.setBackground(Color.orange);
		panelPreViewChapter.setSize(100, 30);
		panelPreViewChapter.setLocation(70,0);
		panelPreViewChapter.add(new Label("��һ��",Label.CENTER));
		
		panelNextChapter.setBackground(Color.orange);
		panelNextChapter.setSize(100, 30);
		panelNextChapter.setLocation(180,0);
		panelNextChapter.add(new Label("��һ��",Label.CENTER));
		
		panelbookList.setBackground(Color.orange);
		panelbookList.setSize(100, 30);
		panelbookList.setLocation(290,0);
		panelbookList.add(new Label("Ŀ¼",Label.CENTER));
		
		panelbookSelf.setBackground(Color.orange);
		panelbookSelf.setSize(100, 30);
		panelbookSelf.setLocation(400,0);
		panelbookSelf.add(new Label("�������",Label.CENTER));
		
		//����
		panelFont.setBackground(Color.orange);
		panelFont.setSize(100, 30);
		panelFont.setLocation(510,0);
		//��������������б�
		 JComboBox comboBox;
	     String[] names;

         names = new String[3];
         names[0] = "΢���ź�";
         names[1] = "����";
         names[2] = "����";
         comboBox = new JComboBox(names);
         comboBox.setEditable(false);
         panelFont.add(comboBox);
         
      
     
        //�����С
        panelFontSize.setBackground(Color.orange);
        panelFontSize.setSize(60, 30);
        panelFontSize.setLocation(620,0);
 		//�������С���������б�
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
                  //System.out.println("----�����б�----"+str);
                  //////////////////////////////////////
                  ReadContentTextSize.setFontSize(str);
             }   
        };   
        comboBoxFontSize.addActionListener(listenerTextSize);//��Ӽ�����   
        /*********************************************/  
        
        
        
        
      
        //�Ķ�������ɫѡȡ���
		panelBgColor.setBackground(Color.orange);
		panelBgColor.setSize(90, 30);
		panelBgColor.setLocation(690,0);
		JButton btn=new JButton("ѡ����ɫ" ); 
		final Color color=new Color(200,200,200); 
		btn.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e)  
			{   
				Color colorReadBackground = JColorChooser.showDialog(null,"��ѡ����ϲ������ɫ" ,color);  
				if (colorReadBackground == null ) {
					colorReadBackground = Color.lightGray;  
				}
				//c.setBackground(color);  
				//c.repaint();   
				//�����Ѿ�ѡ���˱���ɫ������Ҫ����
				//System.out.println("----------��ɫѡȡ��(�ڲ��ⲿ������)-----------------"+colorReadBackground);
				//System.out.println(colorReadBackground.getRed());
				//System.out.println(colorReadBackground.getGreen());
				//System.out.println(colorReadBackground.getBlue());
				
				String value = colorReadBackground.getRed()+"-"+colorReadBackground.getGreen()+"-"+colorReadBackground.getBlue();
				ReadBgColor.setBgColor(value);
			}
		} );  
		panelBgColor.add(btn);
		
		
		
		
		//�Ķ�������ɫѡȡ���
		panelTextColor.setBackground(Color.orange);
		panelTextColor.setSize(90, 30);
		panelTextColor.setLocation(790,0);
		JButton textColor=new JButton("������ɫ" ); 
		final Color colortxt=new Color(200,200,200); 
		textColor.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e)  
			{   
				Color colorReadBackground = JColorChooser.showDialog(null,"��ѡ����ϲ������ɫ" ,colortxt);  
				if (colorReadBackground == null ) {
					colorReadBackground = Color.lightGray;  
				}
				//c.setBackground(color);  
				//c.repaint();   
				//�����Ѿ�ѡ���˱���ɫ������Ҫ����
				//System.out.println("----------��ɫѡȡ��(�ڲ��ⲿ������)-----------------"+colorReadBackground);
				//System.out.println(colorReadBackground.getRed());
				//System.out.println(colorReadBackground.getGreen());
				//System.out.println(colorReadBackground.getBlue());
				
				String value = colorReadBackground.getRed()+"-"+colorReadBackground.getGreen()+"-"+colorReadBackground.getBlue();
				ReadTextColor.setTextColor(value);
			}

			
			
		} );  
		panelTextColor.add(textColor);
		
		/***********************************************************************/
		//��������ӵ���¼�
		
		
		//��һ��
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
				// һ�����򣬴˴���ϸ˵���﷨
				//JOptionPane.showMessageDialog(null, StateJFrame.getStateJFrame(), "ע��", 0, null);
				String[] first =state.split("~~");
				int ids = Integer.parseInt(first[2])-1;
				String next = ids +"";
				String loc = first[1];
				String tit = first[0];
				String tmp = first[2];
				ShowContent.showReadCon(loc, tit, next);
			}
		});
		
		
		
		
		
		
		
		//��һ��
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
				// һ�����򣬴˴���ϸ˵���﷨
				JOptionPane.showMessageDialog(null, StateJFrame.getStateJFrame(), "ע��", 0, null);
				String[] first =state.split("~~");
				int ids = Integer.parseInt(first[2])+1;
				String next = ids +"";
				String loc = first[1];
				String tit = first[0];
				String tmp = first[2];
				ShowContent.showReadCon(loc, tit, next);
			}
		});
		
		//�������
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
				// һ�����򣬴˴���ϸ˵���﷨
				// һ�����򣬴˴���ϸ˵���﷨
				JOptionPane.showMessageDialog(null, "�������", "ע��", 0, null);
				AddBookToBookSelf.add(addID);
			}
		});
		
		
		
		/***********************************************************************/
		//��һ�����˵������뵼������
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
		//�����������Ķ�����
		 JPanel panelContent = new JPanel();
		 panelContent.setLayout(new FlowLayout(FlowLayout.LEFT));
		 panelContent.setPreferredSize(new Dimension(900,8000));//��Ҫ�������룬����panel����ѡ��С��ͬʱ��֤��ߴ���JScrollPane�Ŀ�ߣ����������JScrollPane�Ż���ֹ�����
		
		 
		 
		String con = ReadFileByBookID.readfilebyid(JFlocation,  JFtitle, tmp);
		 
		if(con != null){
				 JTextArea JTextCon = new JTextArea(con);
				 JTextCon.setEditable(false);
				 JTextCon.setLineWrap(true);
				 JTextCon.setWrapStyleWord(true);
				 //������һ�仰ǰ����������������Ͻǵľ��룬�������������һ���������ı����С
				 JTextCon.setBorder (BorderFactory.createEmptyBorder (40,100,1,750));
				 JTextCon.setColumns (30); //����һ����ʾ������
				 JTextCon.setRows (0);//�൱�������ı�������ĳ�ʼ��С,������˵һ��ֻ��д0
				 
				 
				
			
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
				 
				 JTextCon.setBackground (colorBg);//�ı�������
				 JTextCon.setForeground (colorTxt);//������ɫ
				 
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