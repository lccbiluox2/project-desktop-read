package cn.biluo.main.Export;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comman.CombineFile;

public class ExportView {
	
	/***********************************************/
	/*
	 * �ú�����Ҫ���б���Ҫ�Ĳ�������
	 * showBbookId  11
	 * ShowBookName  ʮ������
	 * ShowLocation   mybook\11
	 * ShowContentchapter  4
	 * ShowAllreadyread   0
	 */
	public static  int export(String showBbookId, String ShowBookName,String ShowLocation,String ShowContentchapter,String ShowAllreadyread){
		
		//Ϊ�����鼮���������ݲ���������Ҫ�õ�
		final String exportBookID = showBbookId;
		final String exportBookName = ShowBookName;
		final String exportBookLocation = ShowLocation;
		final String exportCountChapter = ShowContentchapter;
		final String exportAllreadyread = ShowAllreadyread;
	
	
	    
		JFrame mainJFrame = new JFrame("����");
		Container con = mainJFrame.getContentPane();
			
		JPanel backgroundImg = new JPanel();
		backgroundImg.setLayout(null);
		backgroundImg.setBackground(Color.orange);
					
		//�ӵڼ��½ڵ���
		JLabel Jlabel2 = new JLabel("�ӵڼ��½ڵ�����");
		Jlabel2.setBounds(0, 0, 100, 30);
		JPanel exportForm = new JPanel();
		exportForm.setBounds(105, 0, 300, 30);
		exportForm.setBackground(Color.orange);
		
 		//�������С���������б�
 		JComboBox comboBoxfrom;
 	    String[] from;
 	    from = new String[3];
 	    from[0] = "��һ�½�";
 	    from[1] = "�ڶ��½�";
 	    from[2] = "�����½�";
 	    comboBoxfrom = new JComboBox(from);
 	    comboBoxfrom.setSize(300, 30);
 	    comboBoxfrom.setEditable(false);
        exportForm.add(comboBoxfrom);
        
        /**********************************************/   
        ActionListener listenerBegin = new ActionListener(){   
             public void  actionPerformed(ActionEvent e) {   
                  JComboBox com = (JComboBox)e.getSource();   
                  String str = (String)com.getSelectedItem();   
                 // System.out.println("----�����б�----"+str);
                  //////////////////////////////////////
                  ExportBeginChapter.setBeginChapter(str);
             }   
        };   
        comboBoxfrom.addActionListener(listenerBegin);//��Ӽ�����   
        /*********************************************/  
        
        
	
		//��ʽ
		JLabel Jlabel3 = new JLabel("ѡ���ʽ��");
		Jlabel3.setBounds(0, 30, 100, 30);
		JPanel panelFormat = new JPanel();
		panelFormat.setBounds(105, 30, 300, 30);
		panelFormat.setBackground(Color.orange);
		Jlabel3.setBackground(Color.orange);
		
 		//�������С���������б�
 		JComboBox comboBoxFontSize;
 	    String[] format;
 	    format = new String[3];
 	    format[0] = "����Ϊtxt��ʽ";
 	    format[1] = "����Ϊword��ʽ";
 	    format[2] = "����Ϊѹ����ʽ";
        comboBoxFontSize = new JComboBox(format);
        comboBoxFontSize.setSize(300, 30);
        comboBoxFontSize.setEditable(false);
        panelFormat.add(comboBoxFontSize);
      
     
        /**********************************************/   
        ActionListener listenerFormat = new ActionListener(){   
             public void  actionPerformed(ActionEvent e) {   
                  JComboBox com = (JComboBox)e.getSource();   
                  String str = (String)com.getSelectedItem();   
                 // System.out.println("----�����б�----"+str);
                  //////////////////////////////////////
                  EcportFormat.setExportFormat(str);
             }   
        };   
        comboBoxFontSize.addActionListener(listenerFormat);//��Ӽ�����   
        /*********************************************/  

        
        String value=comboBoxFontSize.getSelectedItem().toString();
       // System.out.println("--��ȡ�б���ڵ�����---"+value);
        
        
		//��ť
		JButton EXPORT = new JButton("ȷ�ϵ���");
		EXPORT.setBounds(40, 80, 300, 30);
		EXPORT.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e)  
			{   
				//JOptionPane.showMessageDialog(null, "�ڲ����¼���������", "ע��", 0, null);
				
				
//				System.out.println("��Ϣ�ۼ�����"+exportBookID);
//				System.out.println("��Ϣ�ۼ�����"+exportBookName);
//				System.out.println("��Ϣ�ۼ�����"+exportBookLocation);
//				System.out.println("��Ϣ�ۼ�����"+exportCountChapter);
//				System.out.println("��Ϣ�ۼ�����"+exportAllreadyread);
				
				
				String exportBegin = ExportBeginChapter.getBeginChapter();
				String exportformat = EcportFormat.getExportFormat();
				if(exportBegin == null){
					ReadFistChapterName rdf = new ReadFistChapterName();
					exportBegin = rdf.readFirstChapter(exportBookID);
				}
				
				if(exportformat == null ){
					exportformat = "����Ϊtxt��ʽ";//����Ĭ�ϸ�ʽ
				}
				
				//System.out.println("��Ϣ�ۼ�����"+exportBegin);
				//System.out.println("��Ϣ�ۼ�����"+exportformat);
				
				/*
				 * �ú�����Ҫ���б���Ҫ�Ĳ�������
				 * showBbookId  11
				 * ShowBookName  ʮ������
				 * ShowLocation   mybook\11
				 * ShowContentchapter  4
				 * ShowAllreadyread   0
				 * exportBegin	2##�ڶ��� ����̫�� (��ʱδ��)
				 * exportformat  ����Ϊѹ����ʽ
				 */
				CombineFile com = new CombineFile();
				String next = com.combineFile(exportBookID,exportBookName,exportBookLocation,exportCountChapter,exportAllreadyread,exportBegin,exportformat);
				
				//��ʼ���ļ��ֵ���ͬ�ĸ�ʽ������дһ��������
				FileFormatControl sort = new FileFormatControl();
				sort.fileFormatControl(next);
				
			}
		} );  
		
		
		backgroundImg.add(EXPORT);
		
		
		
		backgroundImg.add(Jlabel2);
		backgroundImg.add(exportForm);
		backgroundImg.add(Jlabel3);
		backgroundImg.add(panelFormat);
		
	    mainJFrame.add(backgroundImg);
	    
		mainJFrame.setLocation(600, 300);
		mainJFrame.setSize(400, 150);
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return 0;
		
	}
	/***********************************************/
	
	
	
}
