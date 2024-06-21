package test;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLcurd {

	/**
	 * <���> <��> <����>��������1</����> <����>��������1</����> </��> <��> <����>��������2</����>
	 * <����>��������3</����> <�ۼ�>22.0Ԫ</�ۼ�> </��> </���>
	 */

	// ��ָ��Ԫ��ĩβ��ӽڵ�

	public void add() throws Exception {
		/* ������Щ�����࣬���Եõ�xml�ĵ���DOM��SAX�Ľ��������Ӷ�ʵ�ֶ�xml�ĵ��Ľ��� */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		/* ָ�������ļ� */
		Document document = builder.parse("students.xml");
		/* �����ڵ� */
		Element price = document.createElement("�ۼ�");
		price.setTextContent("12333.00Ԫ");
		/* �Ѵ����Ľڵ㣬�ҵ���һ������,���ص���NodeList ���� */
		Element book = (Element) document.getElementsByTagName("book").item(0);
		book.appendChild(price);
		/* �ص㣡���� �Ѹ��º���ڴ�д�ص�xml�ĵ� javax.xml.transform.TransformerFactory */
		TransformerFactory tffactory = TransformerFactory.newInstance();
		/* ����ִ�д� Source �� Result �ĸ��Ƶ��� Transformer */
		Transformer tf = tffactory.newTransformer();
		/*
		 * �� XML Source ת��Ϊ Result public abstract void transform(Source
		 * xmlSource, Result outputTarget)
		 */
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("students.xml")));
	}

	// ��ָ���ڵ㴦����ڵ�

	
	/* ��ָ���ڵ㴦����ڵ� */
	public void add2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("students.xml");
		
		/* �����ڵ� */
		Element book = document.createElement("book"); //������
        
        Element bookname = document.createElement("bookname"); //��������
        bookname.appendChild(document.createTextNode("�������")); //������������
        book.appendChild(bookname); //����������ڵ�
        
        Element location = document.createElement("location"); //�������½�
        location.appendChild(document.createTextNode("c:\\ccc")); 
        book.appendChild(location); 
        
        Element contentchapter = document.createElement("contentchapter"); //�������½�
        contentchapter.appendChild(document.createTextNode("1000000")); 
        book.appendChild(contentchapter); 
        
        Element allreadyread = document.createElement("allreadyread"); //�Ѷ��½�
        allreadyread.appendChild(document.createTextNode("900")); 
        book.appendChild(allreadyread);
 
		
		/* �õ��ο��ڵ� */
		Element refNode = (Element) document.getElementsByTagName("books").item(0);
		/* ��book�ڵ�ָ��λ�� ���� �ڵ� */
		refNode.insertBefore(book, null);
		
		//baocun
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("students.xml")));
	}

	
	
	
	
	
	
	// ��xml�ĵ����������<�� ></��>�����name="rsl"

	
	/* ��xml�ĵ����������<�� ></��>�����name="rsl" */
	public void add3() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("book.xml");
		/* �õ��ڵ� */
		Element bookname = (Element) document.getElementsByTagName("����")
				.item(0);
		/* ������� */
		bookname.setAttribute("name", "rsl");
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("book.xml")));
	}

	// ��xml�ĵ���ɾ���ڵ�

	
	/* ��xml�ĵ���ɾ���ڵ� */
	public void delete() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("book.xml");
		/* �õ�Ҫɾ���ڵ� */
		Element price = (Element) document.getElementsByTagName("�ۼ�").item(0);
		/* ������� */
		// xxx Element book = (Element)
		// document.getElementsByTagName("��").item(0);
		// book.removeChild(price);
		/* ɾ�� */
		price.getParentNode().removeChild(price);
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("book.xml")));
	}

	// ��xml�ĵ��и��¼۸�

	
	/* ��xml�ĵ��и��¼۸� */
	public void update() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("book.xml");
		/* �õ�Ҫ���½ڵ� */
		Element price = (Element) document.getElementsByTagName("�ۼ�").item(0);
		/* ���� */
		price.setTextContent("1000000000");
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("book.xml")));
	}
	
	public static void main(String[] args) throws Exception { 
		XMLcurd df =new XMLcurd();
		df.add2();
	} 
	
}
