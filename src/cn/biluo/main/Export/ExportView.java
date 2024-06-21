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
	 * 该函数需要的列表需要的参数如下
	 * showBbookId  11
	 * ShowBookName  十方神王
	 * ShowLocation   mybook\11
	 * ShowContentchapter  4
	 * ShowAllreadyread   0
	 */
	public static  int export(String showBbookId, String ShowBookName,String ShowLocation,String ShowContentchapter,String ShowAllreadyread){
		
		//为导出书籍做几个传递参数，下面要用到
		final String exportBookID = showBbookId;
		final String exportBookName = ShowBookName;
		final String exportBookLocation = ShowLocation;
		final String exportCountChapter = ShowContentchapter;
		final String exportAllreadyread = ShowAllreadyread;
	
	
	    
		JFrame mainJFrame = new JFrame("导出");
		Container con = mainJFrame.getContentPane();
			
		JPanel backgroundImg = new JPanel();
		backgroundImg.setLayout(null);
		backgroundImg.setBackground(Color.orange);
					
		//从第几章节导出
		JLabel Jlabel2 = new JLabel("从第几章节导出：");
		Jlabel2.setBounds(0, 0, 100, 30);
		JPanel exportForm = new JPanel();
		exportForm.setBounds(105, 0, 300, 30);
		exportForm.setBackground(Color.orange);
		
 		//让字体大小出现下拉列表
 		JComboBox comboBoxfrom;
 	    String[] from;
 	    from = new String[3];
 	    from[0] = "第一章节";
 	    from[1] = "第二章节";
 	    from[2] = "第三章节";
 	    comboBoxfrom = new JComboBox(from);
 	    comboBoxfrom.setSize(300, 30);
 	    comboBoxfrom.setEditable(false);
        exportForm.add(comboBoxfrom);
        
        /**********************************************/   
        ActionListener listenerBegin = new ActionListener(){   
             public void  actionPerformed(ActionEvent e) {   
                  JComboBox com = (JComboBox)e.getSource();   
                  String str = (String)com.getSelectedItem();   
                 // System.out.println("----下拉列表----"+str);
                  //////////////////////////////////////
                  ExportBeginChapter.setBeginChapter(str);
             }   
        };   
        comboBoxfrom.addActionListener(listenerBegin);//添加监听器   
        /*********************************************/  
        
        
	
		//格式
		JLabel Jlabel3 = new JLabel("选择格式：");
		Jlabel3.setBounds(0, 30, 100, 30);
		JPanel panelFormat = new JPanel();
		panelFormat.setBounds(105, 30, 300, 30);
		panelFormat.setBackground(Color.orange);
		Jlabel3.setBackground(Color.orange);
		
 		//让字体大小出现下拉列表
 		JComboBox comboBoxFontSize;
 	    String[] format;
 	    format = new String[3];
 	    format[0] = "导出为txt格式";
 	    format[1] = "导出为word格式";
 	    format[2] = "导出为压缩格式";
        comboBoxFontSize = new JComboBox(format);
        comboBoxFontSize.setSize(300, 30);
        comboBoxFontSize.setEditable(false);
        panelFormat.add(comboBoxFontSize);
      
     
        /**********************************************/   
        ActionListener listenerFormat = new ActionListener(){   
             public void  actionPerformed(ActionEvent e) {   
                  JComboBox com = (JComboBox)e.getSource();   
                  String str = (String)com.getSelectedItem();   
                 // System.out.println("----下拉列表----"+str);
                  //////////////////////////////////////
                  EcportFormat.setExportFormat(str);
             }   
        };   
        comboBoxFontSize.addActionListener(listenerFormat);//添加监听器   
        /*********************************************/  

        
        String value=comboBoxFontSize.getSelectedItem().toString();
       // System.out.println("--获取列表框内的数据---"+value);
        
        
		//按钮
		JButton EXPORT = new JButton("确认导出");
		EXPORT.setBounds(40, 80, 300, 30);
		EXPORT.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e)  
			{   
				//JOptionPane.showMessageDialog(null, "内部类事件监听监听", "注意", 0, null);
				
				
//				System.out.println("信息累计如下"+exportBookID);
//				System.out.println("信息累计如下"+exportBookName);
//				System.out.println("信息累计如下"+exportBookLocation);
//				System.out.println("信息累计如下"+exportCountChapter);
//				System.out.println("信息累计如下"+exportAllreadyread);
				
				
				String exportBegin = ExportBeginChapter.getBeginChapter();
				String exportformat = EcportFormat.getExportFormat();
				if(exportBegin == null){
					ReadFistChapterName rdf = new ReadFistChapterName();
					exportBegin = rdf.readFirstChapter(exportBookID);
				}
				
				if(exportformat == null ){
					exportformat = "导出为txt格式";//设置默认格式
				}
				
				//System.out.println("信息累计如下"+exportBegin);
				//System.out.println("信息累计如下"+exportformat);
				
				/*
				 * 该函数需要的列表需要的参数如下
				 * showBbookId  11
				 * ShowBookName  十方神王
				 * ShowLocation   mybook\11
				 * ShowContentchapter  4
				 * ShowAllreadyread   0
				 * exportBegin	2##第二章 欺人太甚 (暂时未用)
				 * exportformat  导出为压缩格式
				 */
				CombineFile com = new CombineFile();
				String next = com.combineFile(exportBookID,exportBookName,exportBookLocation,exportCountChapter,exportAllreadyread,exportBegin,exportformat);
				
				//开始把文件分到不同的格式，这里写一个控制类
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
