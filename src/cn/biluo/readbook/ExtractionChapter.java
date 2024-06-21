package cn.biluo.readbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExtractionChapter {	
	private static final String NULL = null;
	//提取章节列表
	String filename;
	
	/*********************************************************************/
	public ArrayList<String> readStoryList(String targetPath){
		String filename = targetPath;
		System.out.println("传入的文件名"+filename);
		System.out.println();
		File file = new File(filename);
		BufferedReader reader = null;
		try{
			System.out.println("------------------以行为单位寻找章节列表---------------------------");
			reader = new BufferedReader(new FileReader(file));
			
			//创建一个map存放章节
			ArrayList<String> arrlist = new ArrayList();
			
			
			String tempString = null;
			int line =1;
			System.out.println("------------读入的数据---------------------");
			while((tempString = reader.readLine()) != null){
				line ++;
				//System.out.println("读入的数据"+tempString);
				 
				if(tempString.length() < 20  && tempString.length() > 3 && (tempString != NULL)){
					if(tempString.startsWith("第")){
					     String[] StoryName = tempString.split(" ");
					     String myStoryName = StoryName[0]; 
					     System.out.println(myStoryName);
					     if(myStoryName.endsWith("章")){
					    	 System.out.println("读入的数据"+tempString);
					    	 arrlist.add(tempString);
					     }
					}
				}
			}
			
			reader.close();
			return arrlist;
		}catch(IOException e){
			
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/*********************************************************************/
}
