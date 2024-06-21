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
	
	
	//��ʾһ���б�ҳ��
	//�Ƚ��ļ���Ϣд�뵽mybook\book.xml�ļ���
	//String XMLfileName,xml�ļ�·��
	//String booknameDemo,�ļ���
	//String locationDemo,�ļ�λ��
	//String contentchapterDemo,���½�
	//String allreadyreadDemo�Ѿ��������½�
	String  XMLfileName = "students.xml";
	String  JFrametitle = "ʮ������";
	
	String  filename = "ʮ������";
	String  booknameDemo = "ʮ������";
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
		//������ǵ������Ϣ�����֣�λ�ã��Ķ��½ڣ�
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

		//�Ķ�������
		JPanel panel = new JPanel(); 
		// ���ݴ��ڵĴ�С�Զ��ı��С
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
		panelFlush.add(new Label("ˢ��",Label.CENTER));
		
		panelContinue.setBackground(Color.orange);
		panelContinue.setSize(100, 30);
		panelContinue.setLocation(70,0);
		panelContinue.add(new Label("�����Ķ�",Label.CENTER));
		
		panelExport.setBackground(Color.orange);
		panelExport.setSize(100, 30);
		panelExport.setLocation(180,0);
		panelExport.add(new Label("����С˵",Label.CENTER));
		
		panelbookshelf.setBackground(Color.orange);
		panelbookshelf.setSize(100, 30);
		panelbookshelf.setLocation(300,0);
		panelbookshelf.add(new Label("�������",Label.CENTER));
		
		panel.add(panelFlush);
		panel.add(panelContinue);
		panel.add(panelExport);
		panel.add(panelbookshelf);
		
		//����½��б�
		System.out.println("-----------------------����½��б�------------------------------------");
		
		ExtractionChapter mylist = new ExtractionChapter();
		ArrayList<String> arrlist = mylist.readStoryList(targetPath);
		
		System.out.println("---------------------����arrlist----------------------------------------------");
		
		for(String tmp:arrlist){
	          System.out.println(tmp);
	    }
		
		/*******************ֱ�Ӷ�ȡ����************************************/

		
		 JPanel panelContent = new JPanel();
		 panelContent.setPreferredSize(new Dimension(900,50000));//��Ҫ�������룬����panel����ѡ��С��ͬʱ��֤��ߴ���JScrollPane�Ŀ�ߣ����������JScrollPane�Ż���ֹ�����
		 for(String tmp:arrlist){
				JButton button = new JButton(tmp); 
				button.setPreferredSize(new Dimension(224, 30));//�ؼ�����,���ð��o�Ĵ�С 
				final String chapter = button.getText();
				//Ϊ��ť��ӵ���¼�
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
						
						//���밴ť���������
//						JOptionPane.showMessageDialog(null, chapter, "ע��", 0, null);
//						JOptionPane.showMessageDialog(null, filename, "ע��", 0, null);
//					
//						// һ�����򣬴˴���ϸ˵���﷨
//						JOptionPane.showMessageDialog(null, "���c���˰��o", "ע��", 0, null);
//						
						//��ʾ�Ķ�����
						
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
