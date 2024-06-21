package cn.biluo.bookself;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.biluo.showlist.ShowList;

import comman.ReaddaorubookList;

public class BookSelfView {
	
	public void go(){
		
		JFrame readjf  = new JFrame();
		readjf.setSize(900, 700);
		readjf.setLocation(400, 200);
		readjf.setTitle("查看书架");
		readjf.setLayout(new FlowLayout(FlowLayout.LEFT));
		readjf.setVisible(true);

		//历史导航条
		JPanel panel = new JPanel(); 
		// 根据窗口的大小自动改变大小
		panel.setLayout(null);
		panel.setBackground(Color.pink);
		//panel.setSize(900, 30);
		//设置布局后，只能这样设置大小
		panel.setPreferredSize(new Dimension(900, 30));//关键代码,设置JPanel的大小 
		panel.setLocation(0,0);
		panel.setLayout(null);
			
		JPanel paneltime = new JPanel(); 
		JPanel panelStoryName = new JPanel(); 
		JPanel panelFrom = new JPanel(); 
		JPanel panelAllChapter  = new JPanel(); 
		JPanel panelAllreadyRead = new JPanel(); 
		JPanel bookself = new JPanel(); 
		
		paneltime.setBackground(Color.orange);
		paneltime.setSize(140, 30);
		paneltime.setLocation(0,0);
		paneltime.add(new Label("书籍ID",Label.CENTER));
		
		panelStoryName.setBackground(Color.orange);
		panelStoryName.setSize(228, 30);
		panelStoryName.setLocation(142,0);
		panelStoryName.add(new Label("小说名字",Label.CENTER));
		
		panelFrom.setBackground(Color.orange);
		panelFrom.setSize(218, 30);
		panelFrom.setLocation(372,0);
		panelFrom.add(new Label("小说来源",Label.CENTER));
		
		panelAllChapter.setBackground(Color.orange);
		panelAllChapter.setSize(140, 30);
		panelAllChapter.setLocation(592,0);
		panelAllChapter.add(new Label("总章节",Label.CENTER));
		
		
		panelAllreadyRead.setBackground(Color.orange);
		panelAllreadyRead.setSize(100, 30);
		panelAllreadyRead.setLocation(734,0);
		panelAllreadyRead.add(new Label("已阅读章节",Label.CENTER));
		
		
		bookself.setBackground(Color.orange);
		bookself.setSize(50, 30);
		bookself.setLocation(836,0);
		bookself.add(new Label("书架",Label.CENTER));
		
		panel.add(paneltime);
		panel.add(panelStoryName);
		panel.add(panelFrom);
		panel.add(panelAllChapter);
		panel.add(panelAllreadyRead);
		panel.add(bookself);
		
		
		
		
		readjf.add(panel);
		
		String file = "mybook/daorubookList.xml";
		ArrayList<String> arrlist = ReaddaorubookList.onSelf(file);
		for (String tmp : arrlist) {
		
			String[] arr = tmp.split("##");
//			System.out.println(arr[0]);
//			System.out.println(arr[1]);
//			System.out.println(arr[2]);
//			System.out.println(arr[3]);
//			System.out.println(arr[4]);
//			System.out.println(arr[5]);
//			System.out.println(arr[6]);
//			
	
			String space1 = "    ";
			String space2 = "               |";
			String space3 = "                  |";
			String space4 = "                    |";
			String space5 = "                    |";
			String space6 = "        |";
			String space7 = "    ";
			
			String historyTxt = space1+arr[1]+space2+arr[2]+space3+arr[3]+space4+arr[4]+space5+arr[5]+space6+arr[6]+space7;
			
			//为转到列表页面做准备(书架列表点击列表)
			final String aalist = arr[1];
			final String bblist = arr[2].split("\\.")[0];
			final String cclist = arr[3];
			final String ddlist = arr[4];
			final String eelist = arr[5];
			
		
			
			JButton panelHistory = new JButton(historyTxt); 
			panelHistory.setFont (new Font ("SansSerif", Font.PLAIN, 22));
			panelHistory.setSize(900, 60);
			panelHistory.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelHistory.addMouseListener(new MouseListener() {  

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
					//JOptionPane.showMessageDialog(null, "查看书架", "注意", 0, null);
					
					/*
					 * 该函数需要的列表需要的参数如下
					 * showBbookId  11
					 * ShowBookName  十方神王
					 * ShowLocation   mybook\11
					 * ShowContentchapter  4
					 * ShowAllreadyread   0
					 */
					ShowList.showMyList(aalist, bblist, cclist, ddlist, eelist);
				}
			});
			
			
			readjf.add(panelHistory);
			
		}
		
		
		
		
		
		
	}
}
