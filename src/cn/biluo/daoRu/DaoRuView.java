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
		
		//����ԭ�����ļ���
		String value = fname;
	    // ע��Ҫ��\\,Ҫ��������,yeah
	    String[] names = value.split("\\\\");
	    String yuanlaiName = names[names.length-1];
	    System.out.println("����ԭ�����ļ���"+names[names.length-1]);

		
		String sourcePath = fname;//ԭ�ļ���
		String targetPath = "mybook\\"+yuanlaiName;//�ƶ�����ļ���
		System.out.println("�ƶ�����ļ�·��");
		boolean flag = CopyFileToMybook.copy_file(sourcePath,targetPath,false);
		System.out.println(flag);
		
		
		System.out.println("-------------------��С˵�ļ���----------------------------");
		
		 String qiuName = yuanlaiName;
	        // ע��Ҫ��\\,Ҫ��������,yeah
	     String[] StoryName = qiuName.split("\\.");
	     String myStoryName = StoryName[0]; 
	  
	    
	
	    System.out.println("-------------------��ʾС˵�½��б�----------------------------");
		//��ʾһ���б�ҳ��
		//�Ƚ��ļ���Ϣд�뵽mybook\book.xml�ļ���
		//String XMLfileName,xml�ļ�·��
		//String booknameDemo,�ļ���
		//String locationDemo,�ļ�λ��
		//String contentchapterDemo,���½�
		//String allreadyreadDemo�Ѿ��������½�
		String  XMLfileName = "students.xml";
		String  filename = myStoryName;
		String  JFrametitle = myStoryName;
		String  booknameDemo = myStoryName;
		String  locationDemo = "mybook";
		String  contentchapterDemo = "28";
		String  allreadyreadDemo = "0";
		
		ShowReadList showList = new ShowReadList(XMLfileName,filename, JFrametitle, booknameDemo, locationDemo, contentchapterDemo,allreadyreadDemo);
		showList.showList(targetPath);
		
		
		System.out.println("�Ѿ�����");
		
	}
}
