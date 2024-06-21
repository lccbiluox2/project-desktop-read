package comman;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReaddaorubookList {
	
	/******************判断是否已经阅读************************************************/
	public static ArrayList<String> readdaorubooklist(String filePath){
		
		ArrayList<String> arrlist = new ArrayList<String>();
		try {
			
			
			
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(filePath));
			
			
			NodeList nodes = doc.getElementsByTagName("allreadyread");
			System.out.println("allreadyread有"+nodes.getLength()+"个节点。");
			
			for(int i=0;i<nodes.getLength();i++)
			{
				Node node = nodes.item(i);
				String txt = node.getTextContent();
				System.out.println("----"+txt+"----"+i);
				
				int num = Integer.parseInt(txt);
				
				if(num > 0){
					String tempString = null;
					Node parent = node.getParentNode();
					NodeList ChildNodes = parent.getChildNodes();			
					for (int j = 0; j < ChildNodes.getLength(); j++) {
						Node childnode = ChildNodes.item(j);
						
						String childtxt = childnode.getTextContent();
						System.out.println("---------"+childtxt);
						tempString = tempString +"##" +childtxt;
					}
					arrlist.add(tempString);
					
				}
		
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return arrlist;
		
		
	}
	/******************************************************************/
	
	
	/******************判断是否已经阅读************************************************/
	public static ArrayList<String> onSelf(String filePath){
		
		ArrayList<String> arrlist = new ArrayList<String>();
		try {
			
			
			
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(filePath));
			
			
			NodeList nodes = doc.getElementsByTagName("bookself");
			//System.out.println("allreadyread有"+nodes.getLength()+"个节点。");
			
			for(int i=0;i<nodes.getLength();i++)
			{
				Node node = nodes.item(i);
				String txt = node.getTextContent();
				System.out.println("----"+txt+"----"+i);
				
				if(txt.equals("在架")){
					String tempString = null;
					Node parent = node.getParentNode();
					NodeList ChildNodes = parent.getChildNodes();			
					for (int j = 0; j < ChildNodes.getLength(); j++) {
						Node childnode = ChildNodes.item(j);
						
						String childtxt = childnode.getTextContent();
						System.out.println("---------"+childtxt);
						tempString = tempString +"##" +childtxt;
					}
					arrlist.add(tempString);
					
				}
		
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return arrlist;
		
		
	}
	/******************************************************************/
}
