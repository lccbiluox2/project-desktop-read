package cn.biluo.main.daoru;

import java.awt.GraphicsConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

import comman.DaoruBookCount;



public class DaoRuView {
	private static final GraphicsConfiguration String = null;

	public void  go(){
		
		String sourcePath;
	  	JFileChooser jfc = new JFileChooser("c:/");
		jfc.showOpenDialog(null);
		File sf = jfc.getSelectedFile();
		sourcePath = sf.getAbsolutePath();//得到源文件的路径
		
	    String[] names = sourcePath.split("\\\\");
	    String yuanlaiName = names[names.length-1];
	   // System.out.println("这是原来的文件名"+names[names.length-1]);

	    //保存书的总数到daorubookCount.properties
	
	    int count = Integer.parseInt( DaoruBookCount.getCount() ); 
	   // System.out.println(count);
	    count++;
	    String countValue = count+"";
	    DaoruBookCount.setCount(countValue);
	    
	    //建立对应的文件夹,并且分割文件
	   
	    String targetPath = "mybook\\"+countValue+"\\";
	    //System.out.println(targetPath);
	    SplitFileAndSave split = new SplitFileAndSave();
	    split.splitfileandsave(sourcePath, targetPath,yuanlaiName);
	    
	 
		
	}
}
