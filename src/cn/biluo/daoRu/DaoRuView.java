package cn.biluo.daoRu;

import java.awt.GraphicsConfiguration;
import java.io.File;

import javax.swing.JFileChooser;

import cn.biluo.readbook.ShowReadList;



public class DaoRuView {
	private static final GraphicsConfiguration String = null;

	public void  go(){
		String fname;
	  	JFileChooser jfc;
	  	File sf;
		jfc = new JFileChooser("c:/");
		jfc.showOpenDialog(null);
		sf = jfc.getSelectedFile();
		fname = sf.getAbsolutePath();
		System.out.println(fname);
		String resl = "fname";
		
		//这是原来的文件名
		String value = fname;
	    // 注意要加\\,要不出不来,yeah
	    String[] names = value.split("\\\\");
	    String yuanlaiName = names[names.length-1];
	    System.out.println("这是原来的文件名"+names[names.length-1]);

		
		String sourcePath = fname;//原文件名
		String targetPath = "mybook\\"+yuanlaiName;//移动后的文件名
		System.out.println("移动后的文件路径");
		boolean flag = CopyFileToMybook.copy_file(sourcePath,targetPath,false);
		System.out.println(flag);
		
		
		System.out.println("-------------------求小说文件名----------------------------");
		
		 String qiuName = yuanlaiName;
	        // 注意要加\\,要不出不来,yeah
	     String[] StoryName = qiuName.split("\\.");
	     String myStoryName = StoryName[0]; 
	  
	    
	
	    System.out.println("-------------------显示小说章节列表----------------------------");
		//显示一个列表页面
		//先将文件信息写入到mybook\book.xml文件中
		//String XMLfileName,xml文件路径
		//String booknameDemo,文件名
		//String locationDemo,文件位置
		//String contentchapterDemo,总章节
		//String allreadyreadDemo已经读过的章节
		String  XMLfileName = "students.xml";
		String  filename = myStoryName;
		String  JFrametitle = myStoryName;
		String  booknameDemo = myStoryName;
		String  locationDemo = "mybook";
		String  contentchapterDemo = "28";
		String  allreadyreadDemo = "0";
		
		ShowReadList showList = new ShowReadList(XMLfileName,filename, JFrametitle, booknameDemo, locationDemo, contentchapterDemo,allreadyreadDemo);
		showList.showList(targetPath);
		
		
		System.out.println("已经导入");
		
	}
}
