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
        panelFontSize.setSize(100, 30);
        panelFontSize.setLocation(620,0);
 		//�������С���������б�
 		JComboBox comboBoxFontSize;
 	    String[] FontSzie;
 
 	    FontSzie = new String[3];
 	    FontSzie[0] = "�ش�";
   		FontSzie[1] = "�е�";
  		FontSzie[2] = "С";
        comboBoxFontSize = new JComboBox(FontSzie);
        comboBoxFontSize.setEditable(false);
        panelFontSize.add(comboBoxFontSize);
          
		
        //�Ķ�������ɫѡȡ���
		panelBgColor.setBackground(Color.orange);
		panelBgColor.setSize(100, 30);
		panelBgColor.setLocation(730,0);
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
				System.out.println("----------��ɫѡȡ��(�ڲ��ⲿ������)-----------------"+colorReadBackground);
				
			}   
			
		} );  
		panelBgColor.add(btn);
		
		
		
		
		//��һ�����˵������뵼������
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
				// һ�����򣬴˴���ϸ˵���﷨
				JOptionPane.showMessageDialog(null, "���c���˰��o", "ע��", 0, null);
				int flag = 2;//���ö��ĵط� 1 ����ǰ������½� 2�����һ�� 3 �����һ�½�
				ShowReadContent rdc = new ShowReadContent();
				rdc.showReadCon(filename, chapter,flag);
				
			}
		});
		
		
		/*********************************************************************/
		//�����������Ķ�����
		 JPanel panelContent = new JPanel();
		 panelContent.setLayout(new FlowLayout(FlowLayout.LEFT));
		 panelContent.setPreferredSize(new Dimension(900,8000));//��Ҫ�������룬����panel����ѡ��С��ͬʱ��֤��ߴ���JScrollPane�Ŀ�ߣ����������JScrollPane�Ż���ֹ�����
		
		 
		 
		 
		 ReadThree readthree = new ReadThree();
		 String readContent = null;
		 System.out.println("------------�Ķ�����------------------"+readnow);
		 if(readnow == 1){
			 System.out.println("------------�Ķ�����-------��ȡ��ǰ-----------"+readnow);
			 readContent = readthree.readNow(filename, chapter);
		 }else if(readnow == 2){
			 System.out.println("------------�Ķ�����--------��ȡ��һ��----------"+readnow);
			 readContent = readthree.readNextChapter(filename, chapter);
			 String[] readEnd = readContent.split("#");
			 System.out.println("-----------�ָ��ĳ���---------"+readEnd.length);
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
			 System.out.println("------------�Ķ�����----------��ȡ��һ��--------"+readnow);
			 readContent = readthree.readNow(filename, chapter);
			
		 }
		 System.out.println("---------�����Ķ�����������----------------"+readContent);
		
		 
		if(readContent != null){
			 JTextArea JTextCon = new JTextArea(readContent);
			 JTextCon.setEditable(false);
			 JTextCon.setLineWrap(true);
			 JTextCon.setWrapStyleWord(true);
			 //������һ�仰ǰ����������������Ͻǵľ��룬�������������һ���������ı����С
			 JTextCon.setBorder (BorderFactory.createEmptyBorder (40,100,1,750));
			 JTextCon.setColumns (30); //����һ����ʾ������
			 JTextCon.setRows (0);//�൱�������ı�������ĳ�ʼ��С,������˵һ��ֻ��д0
			 Color colorBg = new  Color(153,204,255);
			 Color colorTxt = new  Color(0,0,0);
			 JTextCon.setBackground (colorBg);//�ı�������
			 JTextCon.setForeground (colorTxt);//������ɫ
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

