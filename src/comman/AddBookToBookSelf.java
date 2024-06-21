package comman;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AddBookToBookSelf {

	

	/*********************************************************/
	public static void add(String bookID){
		try {
			String file = "mybook/daorubookList.xml";
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
	
			//得到要修改的节点
			NodeList bookidnodes = (NodeList) document.getElementsByTagName("bookid");
			for(int i=0;i<bookidnodes.getLength();i++)
			{
				Node node = bookidnodes.item(i);
				if(node.getTextContent().equals(bookID)){
					Node parent = node.getParentNode();
					Node allready = parent.getChildNodes().item(5);
					allready.setTextContent("在架");
				}
			}
			//把更新的内容写回到xml中，因为这些操作都还在内存中
			TransformerFactory tfffactory=TransformerFactory.newInstance();
			Transformer tf  = tfffactory.newTransformer();
			
			tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("mybook/daorubookList.xml")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	/*********************************************************/
	
	
}
