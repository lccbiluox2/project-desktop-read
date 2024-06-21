package cn.biluo.readbook;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class MyXMLOption {

	/* 在指定节点处插入节点 */
	public void add(String XMLfileName,String booknameDemo,String locationDemo,String contentchapterDemo,String allreadyreadDemo) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(XMLfileName);
		
		/* 创建节点 */
		Element book = document.createElement("book"); //创建书
        
        Element bookname = document.createElement("bookname"); //创建书名
        bookname.appendChild(document.createTextNode(booknameDemo)); //创建书名内容
        book.appendChild(bookname); //将书名加入节点
        
        Element location = document.createElement("location"); //创建总章节
        location.appendChild(document.createTextNode(locationDemo)); 
        book.appendChild(location); 
        
        Element contentchapter = document.createElement("contentchapter"); //创建总章节
        contentchapter.appendChild(document.createTextNode(contentchapterDemo)); 
        book.appendChild(contentchapter); 
        
        Element allreadyread = document.createElement("allreadyread"); //已读章节
        allreadyread.appendChild(document.createTextNode(allreadyreadDemo)); 
        book.appendChild(allreadyread);
 
		
		/* 得到参考节点 */
		Element refNode = (Element) document.getElementsByTagName("books").item(0);
		/* 往book节点指定位置 插入 节点 */
		refNode.insertBefore(book, null);
		
		//baocun
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream(XMLfileName)));
	}

	
}
