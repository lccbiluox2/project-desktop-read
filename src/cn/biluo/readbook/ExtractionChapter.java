package cn.biluo.readbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExtractionChapter {	
	private static final String NULL = null;
	//��ȡ�½��б�
	String filename;
	
	/*********************************************************************/
	public ArrayList<String> readStoryList(String targetPath){
		String filename = targetPath;
		System.out.println("������ļ���"+filename);
		System.out.println();
		File file = new File(filename);
		BufferedReader reader = null;
		try{
			System.out.println("------------------����Ϊ��λѰ���½��б�---------------------------");
			reader = new BufferedReader(new FileReader(file));
			
			//����һ��map����½�
			ArrayList<String> arrlist = new ArrayList();
			
			
			String tempString = null;
			int line =1;
			System.out.println("------------���������---------------------");
			while((tempString = reader.readLine()) != null){
				line ++;
				//System.out.println("���������"+tempString);
				 
				if(tempString.length() < 20  && tempString.length() > 3 && (tempString != NULL)){
					if(tempString.startsWith("��")){
					     String[] StoryName = tempString.split(" ");
					     String myStoryName = StoryName[0]; 
					     System.out.println(myStoryName);
					     if(myStoryName.endsWith("��")){
					    	 System.out.println("���������"+tempString);
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
