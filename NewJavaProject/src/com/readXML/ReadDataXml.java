package com.readXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadDataXml {

	public static void main(String[] args) {
		String path= System.getProperty("user.dir")+"\\Files\\Student.xml";
		try {
			File src = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse(src);
			doc.getDocumentElement().normalize();
			
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("student");
			
			for(int i=0; i<nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("\nCurrent Element :"+nNode.getNodeName());
				if(nNode.getNodeType()==Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Student Roll No : "+ eElement.getAttribute("rollno"));
					System.out.println("First Name : "+eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("First Name : "+eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("First Name : "+eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("First Name : "+eElement.getElementsByTagName("marks").item(0).getTextContent());
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
