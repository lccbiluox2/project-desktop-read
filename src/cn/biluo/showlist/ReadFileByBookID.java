package cn.biluo.showlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileByBookID {
	
	
	/**********************************************************************/
		public static String readfilebyid(String JFlocation, String JFtitle,String tmp){

			String[] AllTitleSplit = tmp.split("##");
			String filePath =JFlocation +"\\" + AllTitleSplit[0]+".txt";
			
			File file = new File(filePath);
			BufferedReader reader = null;
			String realCon = null;
			try{
				reader = new BufferedReader(new FileReader(file));
				String tempString = null;
				while(((tempString = reader.readLine()) != null)){
					realCon = realCon + "\r\n" +  tempString;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return realCon;
			
		}
	/**********************************************************************/
		
		
		
}
