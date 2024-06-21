package cn.biluo.main.Export;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadFistChapterName {
	
	//读取小说的第一章节名称
	public String readFirstChapter(String bookid){

		String tempString = null;
		try {
			String file = "mybook/"+bookid+"/chapterlist.xml";
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(file));
			
			NodeList nodes = doc.getElementsByTagName("chapterid");
			
			
			for(int i=0;i<nodes.getLength();i++)
			{
				Node node = nodes.item(i);
				if( node.getTextContent().equals("1")){
					Node parent = node.getParentNode();
					NodeList childNodes =parent.getChildNodes();
					for(int j=0;j<childNodes.getLength();j++)
					{
						Node childNode = childNodes.item(j);
						if(childNode.getNodeType() == Node.ELEMENT_NODE && childNode.getNodeName().equals("chaptername")){
							 tempString = childNode.getFirstChild().getNodeValue();
						}
					}			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tempString;
	}
}
