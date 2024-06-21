package cn.biluo.showlist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cn.biluo.main.Export.ExportView;

import comman.AddBookToBookSelf;
import comman.XMLForeach;



public class ShowList extends JFrame {
	

	/**************************************************************/
	/*
	 * �ú�����Ҫ���б���Ҫ�Ĳ�������
	 * showBbookId  11
	 * ShowBookName  ʮ������
	 * ShowLocation   mybook\11
	 * ShowContentchapter  4
	 * ShowAllreadyread   0
	 */
	public static void  showMyList(String showBbookId, String ShowBookName,String ShowLocation,String ShowContentchapter,String ShowAllreadyread){
		
		
		final String JFtitle = ShowBookName;
		final  String JFlocation = ShowLocation;
		
		final String addID =showBbookId;//����鵽��ܱ����ID
		
		//Ϊ�����鼮���������ݲ���������Ҫ�õ�
		final String exportBookID = showBbookId;
		final String exportBookName = ShowBookName;
		final String exportBookLocation = ShowLocation;
		final String exportCountChapter = ShowContentchapter;
		final String exportAllreadyread = ShowAllreadyread;
	
		
		
		
		
		JFrame readjf  = new JFrame();
		readjf.setSize(900, 700);
		readjf.setLocation(400, 200);
		readjf.setTitle(ShowBookName);
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
		
		
		/***********************************************************/
		//Ϊ�˵������ӵ���¼�
		
		panelbookshelf.addMouseListener(new MouseListener() {  

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
			//JOptionPane.showMessageDialog(null, "�������", "ע��", 0, null);
			AddBookToBookSelf.add(addID);
			}
		});
		
    
		panelExport.addMouseListener(new MouseListener() {  

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
			//JOptionPane.showMessageDialog(null, "�����鼮", "ע��", 0, null);
//			
//			System.out.println("------exportBookID---------"+exportBookID );
//			System.out.println("------exportBookName---------"+ exportBookName);
//			System.out.println("------exportBookLocation---------"+exportBookLocation );
//			System.out.println("------exportCountChapter---------"+ exportCountChapter);
//			System.out.println("------exportAllreadyread---------"+exportAllreadyread );
			/*
			 * �ú�����Ҫ���б���Ҫ�Ĳ�������
			 * showBbookId  11
			 * ShowBookName  ʮ������
			 * ShowLocation   mybook\11
			 * ShowContentchapter  4
			 * ShowAllreadyread   0
			 */
			ExportView.export(exportBookID, exportBookName, exportBookLocation, exportCountChapter, exportAllreadyread);
			}
		});
		
		
		
		
		
		
		panel.add(panelFlush);
		panel.add(panelContinue);
		panel.add(panelExport);
		panel.add(panelbookshelf);
		
		
		
		
		/***********************************************************/
		
		
		
		
		
		
		
		//����½��б�
		//System.out.println("-----------------------����½��б�------------------------------------");
		
		ArrayList<String> arrlist = XMLForeach.readStoryList(showBbookId);
	
		
		//System.out.println("---------------------����arrlist----------------------------------------------");
		
		
		
		/*******************ֱ�Ӷ�ȡ����************************************/

		
		 JPanel panelContent = new JPanel();
		 panelContent.setPreferredSize(new Dimension(900,50000));//��Ҫ�������룬����panel����ѡ��С��ͬʱ��֤��ߴ���JScrollPane�Ŀ�ߣ����������JScrollPane�Ż���ֹ�����
		 int i = 0;
		 String AllTitle = "";
		 for(String tmp:arrlist){
			 String tempTitle = "#";
			 i++;
			// System.out.println("------"+tmp);
			 
			String[] chapternameALL = tmp.split("##");//tempString�������½ڵ�����
			if(i % 2 != 0){
				tempTitle = tempTitle + chapternameALL[0];
			
			}else{
				tempTitle = tempTitle + chapternameALL[1];
			}
			
			if(i %2 == 0){
				AllTitle = AllTitle + "#" + tempTitle;
			}else{
				AllTitle = AllTitle + "##" + tempTitle;
				
			}
			
		 }
		// System.out.println("--------1111-----------------"+AllTitle);
		 
		 
		 String[] AllTitleSplit = AllTitle.split("###");
		 int j= 0;
		 for(final String tmp:AllTitleSplit){
			 j++;
			 if(j == 1){
				continue;
			 }
			
			//System.out.println("--------��һ��---------"+tmp+"----");
			
		 
		
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
						
						
					
						// һ�����򣬴˴���ϸ˵���﷨
					//	JOptionPane.showMessageDialog(null, tmp, "ע��", 0, null);
					//	
					//	JOptionPane.showMessageDialog(null, JFtitle, "ע��", 0, null);
					//	JOptionPane.showMessageDialog(null, JFlocation, "ע��", 0, null);
						
						//��ʾ�Ķ�����
						ShowContent.showReadCon(JFlocation,JFtitle,tmp);
						
						
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
