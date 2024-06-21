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
		
		//���浽���ļ��ĸ������
		 final String titleXML = "mybook\\daorubookList.xml";
		 String bookids = null;
		 String booknames = null;
		 String locations = null;
		 String contentchapters = null;
		 final String allreadyreads = "0";
		

		 
		 
		//����һ��map����½�
		ArrayList<String> arrlist = new ArrayList<String>();;//��� 
//		System.out.println("sourcePath:"+sourcePath);
//		System.out.println("targetPath:"+targetPath);
		
		File targetFile = new File(targetPath);
		if(!targetFile.exists()){
			while(!targetFile.mkdirs()){
				System.out.println("����ֻҪû���������ļ��о�һֱ����");
			}
		}
		
		//��ȡ�ļ����ҷָ�
		/************************************************************************/
		int id = 0;//�����ܹ��ж����½�
		File file = new File(sourcePath);
		BufferedReader reader = null;
		String readContent = null;//�洢������������������
		try {
			//System.out.println("------------------����Ϊ��λ��ȡ���ݵ��Ķ����---------------------------");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			//System.out.println("------------���������---------------------");
				while(((tempString = reader.readLine()) != null)){
					//�жϿ�ʼ��ȡ�ĵط�
					//System.out.println("tempString--------------------1-----"+tempString);
					readContent = readContent + "\r\n" + tempString ;
					//System.out.println("readContent--------------------22-----"+readContent);
					
					if(tempString.length() < 20  && tempString.length() > 3 && (tempString != "")){
						
						
						
						if( (tempString.startsWith("��")) ){
							
							String[] chapternameALL = tempString.split(" ");//tempString�������½ڵ�����
							String chapertnameHalf = chapternameALL[0]; //�½ڵ�ǰһ��
							
							     if( (chapertnameHalf.endsWith("��")) ){
							    	 
							    	//�����ļ���ָ�����ļ���
							    	 String darubooklistXML = DaoruBookCount.getCount();
							    	 String darubooklistXMLPath = "mybook\\"+darubooklistXML;
							    	 id++;//�½�ͳ��
							    	// System.out.println("-----darubooklistXMLPath----------"+darubooklistXMLPath);
							    	// System.out.println("------------------------------");
							    	 //�ƶ�ÿ�����Ӧ���½�xml�ļ�����Ӧ���½�
							    	 String everyxml = darubooklistXMLPath+"\\chapterlist.xml";
							    	 //System.out.println(everyxml);
							    	 //�ƶ��ļ�
							    	 FileOption.copy_file("mybook\\chapterlist.xml", everyxml, false);
							    	 
							    	 
							    	 //д�뱣���½����ĵ�ÿһ��ר�ŵĵ��ļ���
							    	/* <?xml version="1.0" encoding="UTF-8" standalone="no"?>
							    	   <book>
							    	 	<chapterid>
							    	 	  	<id>1</id>
							    	 	   	<chaptername>��һ�� ��������</chaptername>
							    	 	</chapterid>
							    	 	<chapterid>
							    	 		<id>2</id>
							    	 		<chaptername>�ڶ��� ����̫��</chaptername>
							    	    </book>
							    	 */
							    	 String XMLfileName = darubooklistXMLPath+"\\chapterlist.xml";
							    	 saveToThisDirXML( XMLfileName, id, tempString);
							    	// System.out.println("---���ڶ�ȡ���½�------------"+id);
							    	 
							    	 //���浼���鼮����Ϣ
							    	 /*<?xml version="1.0" encoding="UTF-8" standalone="no"?>
										<books>
											<book>
												<bookid>69</bookid>
    											<bookname>ʮ������</bookname>
    											<location>mybook</location>
    											<contentchapter>28</contentchapter>
    											<allreadyread>0</allreadyread>
											</book>
										</books> 
							    	  */
							    	
							    	 bookids = darubooklistXML;
							    	 booknames = yuanlaiName;
							    	 locations = darubooklistXMLPath;
							    	 
							    	  
							    	  //�ָ��ļ����Ҵ洢����Ӧ���ļ���
							    	 
							    	 //����Ķ�һ�� ��ô�ð��������
							    	// Ϊ�˷ָ�ÿ���½�
							    	 readContent = readContent + "###";
							    
							    	 
							    	  
							     }
						     }
						}
					}
				
				//System.out.println("---��ȡ���---�����½�------"+id);
			//	System.out.println("---������ȡ�������½�------"+readContent);
				String[] readContents = readContent.split("###");//tempString�������½ڵ�����
				//System.out.println("---�ָ��ļ���׼������----------readContents---------------"+readContents.length);
				//�����ļ���ָ�����ļ���
		    	String fuDirCount = DaoruBookCount.getCount();
		    	String fuDir = "mybook\\"+fuDirCount;
		    	//System.out.println("---�ָ��ļ���׼������----------fuDirCount---------------"+fuDirCount);
		    	//System.out.println("---�ָ��ļ���׼������-------------fuDir-----------"+fuDir);
				for(int i = 1;i <= id ;i++){
					String readContentsHalf = readContents[i]; //���ݵ�ǰһ��
					String textId = i +"";
					String mylocation = fuDir+"\\" + textId + ".txt" ;
				//	System.out.println("---�ָ��ļ���׼������-----------textId-------------"+textId);
				//	System.out.println("---�ָ��ļ���׼������-----------mylocation--------------"+mylocation);
				//	System.out.println("---�ָ��ļ���׼������-----------readContentsHalf-------------"+readContentsHalf);
					splitandsavefile( mylocation , textId, readContentsHalf);
				}
				
				
				
				//�����鼮����Ϣ���ļ���
				contentchapters = id +"";
				
//				System.out.println("---����book�ļ����������------"+bookids);
//				System.out.println("---����book�ļ����������------"+booknames);
//				System.out.println("---����book�ļ����������------"+locations);
//				System.out.println("---����book�ļ����������------"+contentchapters);
//				System.out.println("---����book�ļ����������------"+allreadyreads);
				
				saveToTotalXML(titleXML,bookids,booknames,locations,contentchapters,allreadyreads);
				
				
				//��ʾ�б�
				String showBbookId = DaoruBookCount.getCount() + "";
				String ShowBookName = "ʮ������";
				String ShowLocation = "mybook\\"+DaoruBookCount.getCount() + "";
				String ShowContentchapter = "4";
				String ShowAllreadyread = "0";
				ShowList.showMyList(showBbookId, ShowBookName, ShowLocation, ShowContentchapter, ShowAllreadyread);
				
		} catch (IOException e) {e.printStackTrace();}
		return arrlist;
	}
		/****************�����½����ĵ�ÿһ��ר�ŵĵ��ļ���***********************************************************/
	private void saveToThisDirXML(String darubooklistXMLPath,int id,String tempString) {
		String idstr = id + "";
		//System.out.println(darubooklistXMLPath+"*****************");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(darubooklistXMLPath);
			
			/* �����ڵ� */
			Element chapterId = document.createElement("chapterid"); //�����ڵ�id
			
			Element ids = document.createElement("id"); //��������
		    ids.appendChild(document.createTextNode(idstr)); //������������
		    chapterId.appendChild(ids); //����������ڵ�
		        
	        Element chapterName = document.createElement("chaptername"); //��������
	        chapterName.appendChild(document.createTextNode(tempString)); //������������
	        chapterId.appendChild(chapterName); //����������ڵ�
			/* �õ��ο��ڵ� */
			Element refNode = (Element) document.getElementsByTagName("book").item(0);
			/* ��book�ڵ�ָ��λ�� ���� �ڵ� */
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
			
			/* �����ڵ� */
			Element book = document.createElement("book"); //������
	        
			Element bookids = document.createElement("bookid"); //��������
			bookids.appendChild(document.createTextNode(bookid)); //������������
		    book.appendChild(bookids); //����������ڵ�
		        
			
	        Element booknames = document.createElement("bookname"); //��������
	        booknames.appendChild(document.createTextNode(bookname)); //������������
	        book.appendChild(booknames); //����������ڵ�
	        
	        Element locations = document.createElement("location"); //�������½�
	        locations.appendChild(document.createTextNode(location)); 
	        book.appendChild(locations); 
	        
	        Element contentchapters = document.createElement("contentchapter"); //�������½�
	        contentchapters.appendChild(document.createTextNode(contentchapter)); 
	        book.appendChild(contentchapters); 
	        
	        Element allreadyreads = document.createElement("allreadyread"); //�Ѷ��½�
	        allreadyreads.appendChild(document.createTextNode(allreadyread)); 
	        book.appendChild(allreadyreads);
	        
	        Element bookself = document.createElement("bookself"); //�Ѷ��½�
	        bookself.appendChild(document.createTextNode("���ڼ�")); 
	        book.appendChild(bookself);
			
			/* �õ��ο��ڵ� */
			Element refNode = (Element) document.getElementsByTagName("books").item(0);
			/* ��book�ڵ�ָ��λ�� ���� �ڵ� */
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
			//System.out.println("----------д��ÿ��TXT�ļ��ɹ�------------10-------");
		}catch (IOException e){
			//System.out.println("----------д��ÿ��TXT�ļ�ʧ��------------10-------");
			e.printStackTrace();
		}finally{
			if(out != null){
				try{
					out.close();
				}catch (IOException e){
					System.out.println("----------����ʧ��------------10-------");
					e.printStackTrace();
				}
			}
		}
	}


	/****************************************************************************/
}
