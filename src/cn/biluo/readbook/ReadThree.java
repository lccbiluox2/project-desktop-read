package cn.biluo.readbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadThree {
	
	
	/************读取你点击的章节******************************************************************************************/
	public String readNow(String filename,String chapter){
		
		String filenames = filename+".txt";
		System.out.println(filenames);
		File file = new File(filenames);
		BufferedReader reader = null;
		
		String readContent = null;//存储读出的所有有用数据
		try{
			System.out.println("------------------以行为单位读取数据到阅读面板---------------------------");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			
			System.out.println("------------读入的数据---------------------");
			
			/************************************************************/
			boolean flag = true;//定义不继续读取的标志
			while(((tempString = reader.readLine()) != null) && (flag)){
				
				//判断开始读取的地方
					if(tempString.length() < 20  && tempString.length() > 3 && (tempString != "")){
						if(tempString.startsWith("第")){
						     String[] StoryName = tempString.split(" ");
						     String myStoryName = StoryName[0]; 
						     if(myStoryName.endsWith("章")){
						    	 if(chapter.startsWith(myStoryName)){
						    		 System.out.println("读入的数据-----2"+tempString);
						    		 
						    		 readContent = readContent+ tempString+"\r\n";
						    		 //这里是为了显示每章节的标题
						    		 
						    		 /*******************/
						    		 //判断结束读取的地方
						    		 String readString = null;
						    		 String readStringChapter = null ;
						    		 while(( readStringChapter = reader.readLine()) != null  && (flag) ){
						    			  String[] readEnd = readStringChapter.split(" ");
										  String readEndFirst = StoryName[0];
						    			 if(readStringChapter.startsWith("第") && (readEndFirst.endsWith("章")) ){
										    	//说明读到了下一章节的开始
										    	 flag =false;
										     
						    			 }else{
										    	//否者就将读取到的数据显示
												 System.out.println("读入的数据------3"+readStringChapter);
												 //遇到问题，如何让读入的数据换行
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
	
	
	
	
	/************读取你下一章节******************************************************************************************/
	public String readNextChapter(String filename,String chapter){
		
		String filenames = filename+".txt";
		System.out.println(filenames);
		File file = new File(filenames);
		BufferedReader reader = null;
		
		int count = 0;//计算已读的章节
		
		String readContent = null;//存储读出的所有有用数据
		String nextTitle = null;
		try{
			System.out.println("------------------以行为单位读取数据到阅读面板--------1-------------------");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			
			System.out.println("------------读入的数据---------2------------");
			
			/************************************************************/
			boolean flag = true;//定义不继续读取的标志
			while(((tempString = reader.readLine()) != null) && (flag)){
				
				//判断开始读取的地方
					if(tempString.length() < 20  && tempString.length() > 3 && (tempString != "")){
						if(tempString.startsWith("第")){
						     String[] StoryName = tempString.split(" ");
						     String myStoryName = StoryName[0]; 
						     if(myStoryName.endsWith("章")){
						    	 if(chapter.startsWith(myStoryName)){
						    		 System.out.println("读入的数据------3---"+tempString);
						    		 
						    		 count++;
						    		 System.out.println("读入的数据------4---"+readContent);
						    		 if(count == 2){//说明已经开始读取下一章节的开始
						    			 System.out.println("读入的数据------5---"+readContent);
						    			 readContent = readContent+ tempString+"\r\n";
						    		 }
						    		 //这里是为了显示每章节的标题
						    		 
						    		 /*******************/
						    		 //判断结束读取的地方
						    		 String readString = null;
						    		 String readStringChapter = null ;
						    		 while(( readStringChapter = reader.readLine()) != null  && (flag) ){
						    			  String[] readEnd = readStringChapter.split(" ");
										  String readEndFirst = StoryName[0];
						    			 if(readStringChapter.startsWith("第") && (readEndFirst.endsWith("章")) ){
										    	//说明读到了下一章节的开始
						    				 count++;
						    				 
								    		 if(count == 3){//说明已经开始读取下下一章节的开始这里要停止读取
								    			 flag =false;
								    		 }
								    		
								    		 nextTitle = nextTitle + readStringChapter+"#";
								    		
								    		
										     
						    			 }else{
						    				
						    				 
						    			
						    				 if(count > 1){//说明已经开始读取下下一章节的开始这里要停止读取

											    	//否者就将读取到的数据显示
													 System.out.println("读入的数据------6"+readStringChapter);
													 //遇到问题，如何让读入的数据换行
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
		System.out.println("-----下一张读取的所有数据-----7----"+readContent);
		return readContent;
		
	}
	
	
}
