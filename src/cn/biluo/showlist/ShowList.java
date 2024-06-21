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
	 * 该函数需要的列表需要的参数如下
	 * showBbookId  11
	 * ShowBookName  十方神王
	 * ShowLocation   mybook\11
	 * ShowContentchapter  4
	 * ShowAllreadyread   0
	 */
	public static void  showMyList(String showBbookId, String ShowBookName,String ShowLocation,String ShowContentchapter,String ShowAllreadyread){
		
		
		final String JFtitle = ShowBookName;
		final  String JFlocation = ShowLocation;
		
		final String addID =showBbookId;//添加书到书架必须的ID
		
		//为导出书籍做几个传递参数，下面要用到
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
		
		
		/***********************************************************/
		//为菜单面板添加点击事件
		
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
				
				// 一个弹框，此处不细说其语法
			//JOptionPane.showMessageDialog(null, "加入书架", "注意", 0, null);
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
				
				// 一个弹框，此处不细说其语法
			//JOptionPane.showMessageDialog(null, "导出书籍", "注意", 0, null);
//			
//			System.out.println("------exportBookID---------"+exportBookID );
//			System.out.println("------exportBookName---------"+ exportBookName);
//			System.out.println("------exportBookLocation---------"+exportBookLocation );
//			System.out.println("------exportCountChapter---------"+ exportCountChapter);
//			System.out.println("------exportAllreadyread---------"+exportAllreadyread );
			/*
			 * 该函数需要的列表需要的参数如下
			 * showBbookId  11
			 * ShowBookName  十方神王
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
		
		
		
		
		
		
		
		//添加章节列表
		//System.out.println("-----------------------添加章节列表------------------------------------");
		
		ArrayList<String> arrlist = XMLForeach.readStoryList(showBbookId);
	
		
		//System.out.println("---------------------遍历arrlist----------------------------------------------");
		
		
		
		/*******************直接读取数据************************************/

		
		 JPanel panelContent = new JPanel();
		 panelContent.setPreferredSize(new Dimension(900,50000));//主要是这句代码，设置panel的首选大小，同时保证宽高大于JScrollPane的宽高，这样下面的JScrollPane才会出现滚动条
		 int i = 0;
		 String AllTitle = "";
		 for(String tmp:arrlist){
			 String tempTitle = "#";
			 i++;
			// System.out.println("------"+tmp);
			 
			String[] chapternameALL = tmp.split("##");//tempString现在是章节的总体
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
			
			//System.out.println("--------第一次---------"+tmp+"----");
			
		 
		
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
						
						
					
						// 一个弹框，此处不细说其语法
					//	JOptionPane.showMessageDialog(null, tmp, "注意", 0, null);
					//	
					//	JOptionPane.showMessageDialog(null, JFtitle, "注意", 0, null);
					//	JOptionPane.showMessageDialog(null, JFlocation, "注意", 0, null);
						
						//显示阅读界面
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
