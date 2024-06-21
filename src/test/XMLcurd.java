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
	 * <书架> <书> <书名>这是书名1</书名> <作者>这是作者1</作者> </书> <书> <书名>这是书名2</书名>
	 * <作者>这是作者3</作者> <售价>22.0元</售价> </书> </书架>
	 */

	// 在指定元素末尾添加节点

	public void add() throws Exception {
		/* 调用这些工厂类，可以得到xml文档的DOM或SAX的解析器，从而实现对xml文档的解析 */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		/* 指定解析文件 */
		Document document = builder.parse("students.xml");
		/* 创建节点 */
		Element price = document.createElement("售价");
		price.setTextContent("12333.00元");
		/* 把创建的节点，挂到第一本书上,返回的是NodeList 集合 */
		Element book = (Element) document.getElementsByTagName("book").item(0);
		book.appendChild(price);
		/* 重点！！！ 把更新后的内存写回到xml文档 javax.xml.transform.TransformerFactory */
		TransformerFactory tffactory = TransformerFactory.newInstance();
		/* 创建执行从 Source 到 Result 的复制的新 Transformer */
		Transformer tf = tffactory.newTransformer();
		/*
		 * 将 XML Source 转换为 Result public abstract void transform(Source
		 * xmlSource, Result outputTarget)
		 */
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("students.xml")));
	}

	// 在指定节点处插入节点

	
	/* 在指定节点处插入节点 */
	public void add2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("students.xml");
		
		/* 创建节点 */
		Element book = document.createElement("book"); //创建书
        
        Element bookname = document.createElement("bookname"); //创建书名
        bookname.appendChild(document.createTextNode("万股至尊")); //创建书名内容
        book.appendChild(bookname); //将书名加入节点
        
        Element location = document.createElement("location"); //创建总章节
        location.appendChild(document.createTextNode("c:\\ccc")); 
        book.appendChild(location); 
        
        Element contentchapter = document.createElement("contentchapter"); //创建总章节
        contentchapter.appendChild(document.createTextNode("1000000")); 
        book.appendChild(contentchapter); 
        
        Element allreadyread = document.createElement("allreadyread"); //已读章节
        allreadyread.appendChild(document.createTextNode("900")); 
        book.appendChild(allreadyread);
 
		
		/* 得到参考节点 */
		Element refNode = (Element) document.getElementsByTagName("books").item(0);
		/* 往book节点指定位置 插入 节点 */
		refNode.insertBefore(book, null);
		
		//baocun
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("students.xml")));
	}

	
	
	
	
	
	
	// 在xml文档中添加属性<书 ></书>中添加name="rsl"

	
	/* 在xml文档中添加属性<书 ></书>中添加name="rsl" */
	public void add3() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("book.xml");
		/* 得到节点 */
		Element bookname = (Element) document.getElementsByTagName("书名")
				.item(0);
		/* 添加属性 */
		bookname.setAttribute("name", "rsl");
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("book.xml")));
	}

	// 在xml文档中删除节点

	
	/* 在xml文档中删除节点 */
	public void delete() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("book.xml");
		/* 得到要删除节点 */
		Element price = (Element) document.getElementsByTagName("售价").item(0);
		/* 添加属性 */
		// xxx Element book = (Element)
		// document.getElementsByTagName("书").item(0);
		// book.removeChild(price);
		/* 删除 */
		price.getParentNode().removeChild(price);
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("book.xml")));
	}

	// 在xml文档中更新价格

	
	/* 在xml文档中更新价格 */
	public void update() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("book.xml");
		/* 得到要更新节点 */
		Element price = (Element) document.getElementsByTagName("售价").item(0);
		/* 更新 */
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
