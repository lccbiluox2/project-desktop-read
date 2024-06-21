package cn.biluo.main.daoru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.biluo.showlist.ShowList;

import comman.DaoruBookCount;
import comman.FileOption;

public class SplitFileAndSave {
	

	
	private static final String String = null;
	/**************************************************************/
	/*
	 * 
	 */
	public ArrayList<String> splitfileandsave(String sourcePath,String targetPath,String yuanlaiName){
		
		//保存到总文件的各项参数
		 final String titleXML = "mybook\\daorubookList.xml";
		 String bookids = null;
		 String booknames = null;
		 String locations = null;
		 String contentchapters = null;
		 final String allreadyreads = "0";
		

		 
		 
		//创建一个map存放章节
		ArrayList<String> arrlist = new ArrayList<String>();;//存放 
//		System.out.println("sourcePath:"+sourcePath);
//		System.out.println("targetPath:"+targetPath);
		
		File targetFile = new File(targetPath);
		if(!targetFile.exists()){
			while(!targetFile.mkdirs()){
				System.out.println("这里只要没创建出来文件夹就一直创建");
			}
		}
		
		//读取文件并且分割
		/************************************************************************/
		int id = 0;//计算总共有多少章节
		File file = new File(sourcePath);
		BufferedReader reader = null;
		String readContent = null;//存储读出的所有有用数据
		try {
			//System.out.println("------------------以行为单位读取数据到阅读面板---------------------------");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			//System.out.println("------------读入的数据---------------------");
				while(((tempString = reader.readLine()) != null)){
					//判断开始读取的地方
					//System.out.println("tempString--------------------1-----"+tempString);
					readContent = readContent + "\r\n" + tempString ;
					//System.out.println("readContent--------------------22-----"+readContent);
					
					if(tempString.length() < 20  && tempString.length() > 3 && (tempString != "")){
						
						
						
						if( (tempString.startsWith("第")) ){
							
							String[] chapternameALL = tempString.split(" ");//tempString现在是章节的总体
							String chapertnameHalf = chapternameALL[0]; //章节的前一半
							
							     if( (chapertnameHalf.endsWith("章")) ){
							    	 
							    	//保存文件到指定的文件夹
							    	 String darubooklistXML = DaoruBookCount.getCount();
							    	 String darubooklistXMLPath = "mybook\\"+darubooklistXML;
							    	 id++;//章节统计
							    	// System.out.println("-----darubooklistXMLPath----------"+darubooklistXMLPath);
							    	// System.out.println("------------------------------");
							    	 //移动每本书对应的章节xml文件到对应的章节
							    	 String everyxml = darubooklistXMLPath+"\\chapterlist.xml";
							    	 //System.out.println(everyxml);
							    	 //移动文件
							    	 FileOption.copy_file("mybook\\chapterlist.xml", everyxml, false);
							    	 
							    	 
							    	 //写入保存章节信心到每一个专门的的文件夹
							    	/* <?xml version="1.0" encoding="UTF-8" standalone="no"?>
							    	   <book>
							    	 	<chapterid>
							    	 	  	<id>1</id>
							    	 	   	<chaptername>第一章 少年林天</chaptername>
							    	 	</chapterid>
							    	 	<chapterid>
							    	 		<id>2</id>
							    	 		<chaptername>第二章 欺人太甚</chaptername>
							    	    </book>
							    	 */
							    	 String XMLfileName = darubooklistXMLPath+"\\chapterlist.xml";
							    	 saveToThisDirXML( XMLfileName, id, tempString);
							    	// System.out.println("---正在读取的章节------------"+id);
							    	 
							    	 //保存导入书籍的信息
							    	 /*<?xml version="1.0" encoding="UTF-8" standalone="no"?>
										<books>
											<book>
												<bookid>69</bookid>
    											<bookname>十方神王</bookname>
    											<location>mybook</location>
    											<contentchapter>28</contentchapter>
    											<allreadyread>0</allreadyread>
											</book>
										</books> 
							    	  */
							    	
							    	 bookids = darubooklistXML;
							    	 booknames = yuanlaiName;
							    	 locations = darubooklistXMLPath;
							    	 
							    	  
							    	  //分割文件并且存储到相应的文件夹
							    	 
							    	 //如果阅读一章 那么久把内容清空
							    	// 为了分割每个章节
							    	 readContent = readContent + "###";
							    
							    	 
							    	  
							     }
						     }
						}
					}
				
				//System.out.println("---读取完毕---共有章节------"+id);
			//	System.out.println("---真正读取的内容章节------"+readContent);
				String[] readContents = readContent.split("###");//tempString现在是章节的总体
				//System.out.println("---分割文件的准备工作----------readContents---------------"+readContents.length);
				//保存文件到指定的文件夹
		    	String fuDirCount = DaoruBookCount.getCount();
		    	String fuDir = "mybook\\"+fuDirCount;
		    	//System.out.println("---分割文件的准备工作----------fuDirCount---------------"+fuDirCount);
		    	//System.out.println("---分割文件的准备工作-------------fuDir-----------"+fuDir);
				for(int i = 1;i <= id ;i++){
					String readContentsHalf = readContents[i]; //内容的前一半
					String textId = i +"";
					String mylocation = fuDir+"\\" + textId + ".txt" ;
				//	System.out.println("---分割文件的准备工作-----------textId-------------"+textId);
				//	System.out.println("---分割文件的准备工作-----------mylocation--------------"+mylocation);
				//	System.out.println("---分割文件的准备工作-----------readContentsHalf-------------"+readContentsHalf);
					splitandsavefile( mylocation , textId, readContentsHalf);
				}
				
				
				
				//保存书籍总信息到文件中
				contentchapters = id +"";
				
//				System.out.println("---向总book文件中添加数据------"+bookids);
//				System.out.println("---向总book文件中添加数据------"+booknames);
//				System.out.println("---向总book文件中添加数据------"+locations);
//				System.out.println("---向总book文件中添加数据------"+contentchapters);
//				System.out.println("---向总book文件中添加数据------"+allreadyreads);
				
				saveToTotalXML(titleXML,bookids,booknames,locations,contentchapters,allreadyreads);
				
				
				//显示列表
				String showBbookId = DaoruBookCount.getCount() + "";
				String ShowBookName = "十方神王";
				String ShowLocation = "mybook\\"+DaoruBookCount.getCount() + "";
				String ShowContentchapter = "4";
				String ShowAllreadyread = "0";
				ShowList.showMyList(showBbookId, ShowBookName, ShowLocation, ShowContentchapter, ShowAllreadyread);
				
		} catch (IOException e) {e.printStackTrace();}
		return arrlist;
	}
		/****************保存章节信心到每一个专门的的文件夹***********************************************************/
	private void saveToThisDirXML(String darubooklistXMLPath,int id,String tempString) {
		String idstr = id + "";
		//System.out.println(darubooklistXMLPath+"*****************");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(darubooklistXMLPath);
			
			/* 创建节点 */
			Element chapterId = document.createElement("chapterid"); //创建节点id
			
			Element ids = document.createElement("id"); //创建书名
		    ids.appendChild(document.createTextNode(idstr)); //创建书名内容
		    chapterId.appendChild(ids); //将书名加入节点
		        
	        Element chapterName = document.createElement("chaptername"); //创建书名
	        chapterName.appendChild(document.createTextNode(tempString)); //创建书名内容
	        chapterId.appendChild(chapterName); //将书名加入节点
			/* 得到参考节点 */
			Element refNode = (Element) document.getElementsByTagName("book").item(0);
			/* 往book节点指定位置 插入 节点 */
			refNode.insertBefore(chapterId, null);
			
			//baocun
			TransformerFactory tffactory = TransformerFactory.newInstance();
			Transformer tf = tffactory.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult(
					new FileOutputStream(darubooklistXMLPath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/***************************************************************************/
	
	
	

	private void saveToTotalXML(String XMLfileName,String bookid, String bookname,
			String location, String contentchapter, String allreadyread) {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(XMLfileName);
			
			/* 创建节点 */
			Element book = document.createElement("book"); //创建书
	        
			Element bookids = document.createElement("bookid"); //创建书名
			bookids.appendChild(document.createTextNode(bookid)); //创建书名内容
		    book.appendChild(bookids); //将书名加入节点
		        
			
	        Element booknames = document.createElement("bookname"); //创建书名
	        booknames.appendChild(document.createTextNode(bookname)); //创建书名内容
	        book.appendChild(booknames); //将书名加入节点
	        
	        Element locations = document.createElement("location"); //创建总章节
	        locations.appendChild(document.createTextNode(location)); 
	        book.appendChild(locations); 
	        
	        Element contentchapters = document.createElement("contentchapter"); //创建总章节
	        contentchapters.appendChild(document.createTextNode(contentchapter)); 
	        book.appendChild(contentchapters); 
	        
	        Element allreadyreads = document.createElement("allreadyread"); //已读章节
	        allreadyreads.appendChild(document.createTextNode(allreadyread)); 
	        book.appendChild(allreadyreads);
	        
	        Element bookself = document.createElement("bookself"); //已读章节
	        bookself.appendChild(document.createTextNode("不在架")); 
	        book.appendChild(bookself);
			
			/* 得到参考节点 */
			Element refNode = (Element) document.getElementsByTagName("books").item(0);
			/* 往book节点指定位置 插入 节点 */
			refNode.insertBefore(book, null);
			
			//baocun
			TransformerFactory tffactory = TransformerFactory.newInstance();
			Transformer tf = tffactory.newTransformer();
			
			tf.transform(new DOMSource(document), new StreamResult(
					new FileOutputStream(XMLfileName)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param string4 
	 * @param string3 
	 * @param string2 **************************************************************************/

	private void splitandsavefile(String mylocation , String  myid,String mycontent) {
		// TODO Auto-generated method stub
		
		
		File targetFile = new File(mylocation);
		OutputStream out = null;
		try{
			out =  new FileOutputStream(targetFile);
			
			byte[] bytes = mycontent.getBytes();
			out.write(bytes);
			//System.out.println("----------写入每个TXT文件成功------------10-------");
		}catch (IOException e){
			//System.out.println("----------写入每个TXT文件失败------------10-------");
			e.printStackTrace();
		}finally{
			if(out != null){
				try{
					out.close();
				}catch (IOException e){
					System.out.println("----------关流失败------------10-------");
					e.printStackTrace();
				}
			}
		}
	}


	/****************************************************************************/
}
