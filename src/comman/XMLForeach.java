package comman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLForeach 
{
	
	
	/******************************************************************/
	public static ArrayList<String> readStoryList(String bookid){
		
		ArrayList<String> arrlist = new ArrayList();
		try {
			String file = "mybook/"+bookid+"/chapterlist.xml";
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(file));
			
			
			NodeList nodes = doc.getElementsByTagName("chapterid");
			//System.out.println("总共有"+nodes.getLength()+"个人。");
			
			for(int i=0;i<nodes.getLength();i++)
			{
				Node node = nodes.item(i);
				NodeList childNodes = node.getChildNodes();
			//	System.out.println("person有"+childNodes.getLength()+"个节点。");
				
				for(int j=0;j<childNodes.getLength();j++)
				{
					String listID = null;
					String listName  = null;
					Node childNode = childNodes.item(j);
					if(childNode.getNodeType() == Node.ELEMENT_NODE && childNode.getNodeName().equals("id")){
						 listID = childNode.getFirstChild().getNodeValue();
					}
					if(childNode.getNodeType() == Node.ELEMENT_NODE && childNode.getNodeName().equals("chaptername")){
						 listName = childNode.getFirstChild().getNodeValue();
					}
					String tempString = listID +"##" +listName;
					arrlist.add(tempString);
				}			
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return arrlist;
		
	}
	/******************************************************************/
	
	
	
	/******************************************************************/
}
