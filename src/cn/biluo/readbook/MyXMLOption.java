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

	/* ��ָ���ڵ㴦����ڵ� */
	public void add(String XMLfileName,String booknameDemo,String locationDemo,String contentchapterDemo,String allreadyreadDemo) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(XMLfileName);
		
		/* �����ڵ� */
		Element book = document.createElement("book"); //������
        
        Element bookname = document.createElement("bookname"); //��������
        bookname.appendChild(document.createTextNode(booknameDemo)); //������������
        book.appendChild(bookname); //����������ڵ�
        
        Element location = document.createElement("location"); //�������½�
        location.appendChild(document.createTextNode(locationDemo)); 
        book.appendChild(location); 
        
        Element contentchapter = document.createElement("contentchapter"); //�������½�
        contentchapter.appendChild(document.createTextNode(contentchapterDemo)); 
        book.appendChild(contentchapter); 
        
        Element allreadyread = document.createElement("allreadyread"); //�Ѷ��½�
        allreadyread.appendChild(document.createTextNode(allreadyreadDemo)); 
        book.appendChild(allreadyread);
 
		
		/* �õ��ο��ڵ� */
		Element refNode = (Element) document.getElementsByTagName("books").item(0);
		/* ��book�ڵ�ָ��λ�� ���� �ڵ� */
		refNode.insertBefore(book, null);
		
		//baocun
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream(XMLfileName)));
	}

	
}
