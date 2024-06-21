package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomCreateDoucment{
    private Document document;
    public void init() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
    
    }
    
    //创建XML
	public void createXml(String fileName,String booknameDemo,String locationDemo,String contentchapterDemo,String allreadyreadDemo) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		/* 调用这些工厂类，可以得到xml文档的DOM或SAX的解析器，从而实现对xml文档的解析 */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		/* 指定解析文件 */
		Document document = builder.parse("students.xml");
		
		
		/* 创建节点 */
		Element book = this.document.createElement("book"); //创建书
        
        Element bookname = this.document.createElement("bookname"); //创建书名
        bookname.appendChild(this.document.createTextNode(booknameDemo)); //创建书名内容
        book.appendChild(bookname); //将书名加入节点
        
        Element location = this.document.createElement("location"); //创建总章节
        location.appendChild(this.document.createTextNode(locationDemo)); 
        book.appendChild(location); 
        
        Element contentchapter = this.document.createElement("contentchapter"); //创建总章节
        contentchapter.appendChild(this.document.createTextNode(contentchapterDemo)); 
        book.appendChild(contentchapter); 
        
        Element allreadyread = this.document.createElement("allreadyread"); //已读章节
        allreadyread.appendChild(this.document.createTextNode(allreadyreadDemo)); 
        book.appendChild(allreadyread);
 
        this.document.getElementsByTagName("books").item(0).appendChild(book);

        
	
		

    }
	

    public void parserXml(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            NodeList employees = document.getChildNodes();
            for (int i = 0; i < employees.getLength(); i++) {
                Node employee = employees.item(i);
                NodeList employeeInfo = employee.getChildNodes();
                for (int j = 0; j < employeeInfo.getLength(); j++) {
                    Node node = employeeInfo.item(j);
                    NodeList employeeMeta = node.getChildNodes();
                    for (int k = 0; k < employeeMeta.getLength(); k++) {
                        System.out.println(employeeMeta.item(k).getNodeName()
                                + ":" + employeeMeta.item(k).getTextContent());
                    }
                }
            }
            System.out.println("解析完毕");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
	
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException, TransformerException{
    	DomCreateDoucment dd=new DomCreateDoucment();
        String str="students.xml";
        dd.init();
        dd.createXml(str,"北京欢迎你","mybook\\book1","200","30");    //创建xml
        //dd.parserXml(str);    //读取xml
    }
	
}