package cn.biluo.readbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadThree {
	
	
	/************��ȡ�������½�******************************************************************************************/
	public String readNow(String filename,String chapter){
		
		String filenames = filename+".txt";
		System.out.println(filenames);
		File file = new File(filenames);
		BufferedReader reader = null;
		
		String readContent = null;//�洢������������������
		try{
			System.out.println("------------------����Ϊ��λ��ȡ���ݵ��Ķ����---------------------------");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			
			System.out.println("------------���������---------------------");
			
			/************************************************************/
			boolean flag = true;//���岻������ȡ�ı�־
			while(((tempString = reader.readLine()) != null) && (flag)){
				
				//�жϿ�ʼ��ȡ�ĵط�
					if(tempString.length() < 20  && tempString.length() > 3 && (tempString != "")){
						if(tempString.startsWith("��")){
						     String[] StoryName = tempString.split(" ");
						     String myStoryName = StoryName[0]; 
						     if(myStoryName.endsWith("��")){
						    	 if(chapter.startsWith(myStoryName)){
						    		 System.out.println("���������-----2"+tempString);
						    		 
						    		 readContent = readContent+ tempString+"\r\n";
						    		 //������Ϊ����ʾÿ�½ڵı���
						    		 
						    		 /*******************/
						    		 //�жϽ�����ȡ�ĵط�
						    		 String readString = null;
						    		 String readStringChapter = null ;
						    		 while(( readStringChapter = reader.readLine()) != null  && (flag) ){
						    			  String[] readEnd = readStringChapter.split(" ");
										  String readEndFirst = StoryName[0];
						    			 if(readStringChapter.startsWith("��") && (readEndFirst.endsWith("��")) ){
										    	//˵����������һ�½ڵĿ�ʼ
										    	 flag =false;
										     
						    			 }else{
										    	//���߾ͽ���ȡ����������ʾ
												 System.out.println("���������------3"+readStringChapter);
												 //�������⣬����ö�������ݻ���
												readContent = readContent + readStringChapter+"\r\n";
												
										 }
						    		 }
						    		 
						    		 /*******************/
						    	 }
						    	
						     }
						}
					}
			}
			
			
			
			/************************************************************/
			reader.close();
		}catch(IOException e){}
		finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {e.printStackTrace();}
			}
		}
		
		
		return readContent;
		
	}
	
	
	
	
	/************��ȡ����һ�½�******************************************************************************************/
	public String readNextChapter(String filename,String chapter){
		
		String filenames = filename+".txt";
		System.out.println(filenames);
		File file = new File(filenames);
		BufferedReader reader = null;
		
		int count = 0;//�����Ѷ����½�
		
		String readContent = null;//�洢������������������
		String nextTitle = null;
		try{
			System.out.println("------------------����Ϊ��λ��ȡ���ݵ��Ķ����--------1-------------------");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			
			System.out.println("------------���������---------2------------");
			
			/************************************************************/
			boolean flag = true;//���岻������ȡ�ı�־
			while(((tempString = reader.readLine()) != null) && (flag)){
				
				//�жϿ�ʼ��ȡ�ĵط�
					if(tempString.length() < 20  && tempString.length() > 3 && (tempString != "")){
						if(tempString.startsWith("��")){
						     String[] StoryName = tempString.split(" ");
						     String myStoryName = StoryName[0]; 
						     if(myStoryName.endsWith("��")){
						    	 if(chapter.startsWith(myStoryName)){
						    		 System.out.println("���������------3---"+tempString);
						    		 
						    		 count++;
						    		 System.out.println("���������------4---"+readContent);
						    		 if(count == 2){//˵���Ѿ���ʼ��ȡ��һ�½ڵĿ�ʼ
						    			 System.out.println("���������------5---"+readContent);
						    			 readContent = readContent+ tempString+"\r\n";
						    		 }
						    		 //������Ϊ����ʾÿ�½ڵı���
						    		 
						    		 /*******************/
						    		 //�жϽ�����ȡ�ĵط�
						    		 String readString = null;
						    		 String readStringChapter = null ;
						    		 while(( readStringChapter = reader.readLine()) != null  && (flag) ){
						    			  String[] readEnd = readStringChapter.split(" ");
										  String readEndFirst = StoryName[0];
						    			 if(readStringChapter.startsWith("��") && (readEndFirst.endsWith("��")) ){
										    	//˵����������һ�½ڵĿ�ʼ
						    				 count++;
						    				 
								    		 if(count == 3){//˵���Ѿ���ʼ��ȡ����һ�½ڵĿ�ʼ����Ҫֹͣ��ȡ
								    			 flag =false;
								    		 }
								    		
								    		 nextTitle = nextTitle + readStringChapter+"#";
								    		
								    		
										     
						    			 }else{
						    				
						    				 
						    			
						    				 if(count > 1){//˵���Ѿ���ʼ��ȡ����һ�½ڵĿ�ʼ����Ҫֹͣ��ȡ

											    	//���߾ͽ���ȡ����������ʾ
													 System.out.println("���������------6"+readStringChapter);
													 //�������⣬����ö�������ݻ���
													readContent = readContent + readStringChapter+"\r\n";
								    		 }
												
										 }
						    		 }
						    		 
						    		 /*******************/
						    	 }
						    	
						     }
						}
					}
			}
			
			
			
			/************************************************************/
			reader.close();
		}catch(IOException e){}
		finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {e.printStackTrace();}
			}
		}
		
		readContent = readContent+"#"+nextTitle;
		System.out.println("-----��һ�Ŷ�ȡ����������-----7----"+readContent);
		return readContent;
		
	}
	
	
}
