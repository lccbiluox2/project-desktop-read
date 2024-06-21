package comman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CombineFile {
	
	/**
	 *
	 * 该函数需要的列表需要的参数如下
	 * showBbookId  11
	 * ShowBookName  十方神王
	 * ShowLocation   mybook\11
	 * ShowContentchapter  4
	 * ShowAllreadyread   0
	 * exportBegin	2##第二章 欺人太甚 (暂时未用)
	 * exportformat  导出为压缩格式
	 * @param exportformat 
	 * @param exportBegin 
	 * @param exportAllreadyread 
	 * @param exportCountChapter 
	 * @param exportBookLocation 
	 * @param exportBookName 
	 * @param exportBookID *****************************************************************/
	public  String  combineFile(String exportBookID, String exportBookName, String exportBookLocation, String exportCountChapter, String exportAllreadyread, String exportBegin, String exportformat){
		  	
		String allUseFulStr = null;
		String targetFile = "ExportTemp\\"+exportBookName+".txt";
		FileWriter writer = null;
		try {
			writer = new FileWriter(targetFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
      
		try {
			for(int i = 1 ; i <= Integer.parseInt(exportCountChapter) ;i++){
				String filestr = "mybook\\"+exportBookID+"\\"+(i+".txt");
				File file = new File(filestr);
				BufferedReader reader = new BufferedReader(new FileReader(file));// 创建缓冲输入流
	            String line;
	            while ((line = reader.readLine()) != null) {
					 allUseFulStr = allUseFulStr +  "\r\n" + line;
				}
	            
	            reader.close();
			}
		
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
	        
		return exportBookName+"##"+exportBegin+"##"+exportformat;
	
	}
	
	
	
	/*******************************************************************/
	
	
	
}
