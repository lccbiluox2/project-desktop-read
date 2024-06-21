package cn.biluo.main.Export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class SaveByFormat {
	
	/**
	 * @param next *****************************************************/
	public void saveToText(String next){
		//得到系统桌面路径
		FileSystemView fsv = FileSystemView.getFileSystemView();
		String targetPath = fsv.getHomeDirectory().toString();    //这便是读取桌面路径的方法了 
		
		String[] nexts = next.split("##");
		
		String targetPaths = targetPath + "\\"+nexts[0]+".txt";
		String allUseFulStr = null;
		FileWriter writer = null;
		try {
			writer = new FileWriter(targetPaths);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
      
		String filestr = "ExportTemp\\"+nexts[0]+".txt";
		try {
			File file = new File(filestr);
			BufferedReader reader = new BufferedReader(new FileReader(file));// 创建缓冲输入流
            String line;
            while ((line = reader.readLine()) != null) {
				 allUseFulStr = allUseFulStr +  "\r\n" + line;
			}
            reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 将读入的数据写入到文件中
		try {
			writer.write(allUseFulStr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//然后删除该文件夹下的临时文件
		deleteFile(filestr);
	}
	
	/*******************************************************/
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  

	/*******************************************************/
	
	
	public void saveToWord(String next){
		String[] nexts = next.split("##");
//		System.out.println("-----next---------------"+nexts[0]);
//		System.out.println("-----next---------------"+nexts[1]);
//		System.out.println("-----next---------------"+nexts[2]);
		JOptionPane.showMessageDialog(null, "此方法还未写", "注意", 0, null);
	}
	/*******************************************************/
	
	/*******************************************************/
	
	
	public void saveToCompress(String next){
		String[] nexts = next.split("##");
//		System.out.println("-----next---------------"+nexts[0]);
//		System.out.println("-----next---------------"+nexts[1]);
//		System.out.println("-----next---------------"+nexts[2]);
		JOptionPane.showMessageDialog(null, "此方法还未写", "注意", 0, null);
	}
	/*******************************************************/
	
	
	
	
	
}
