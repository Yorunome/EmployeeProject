package com.training.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.training.controller.employeefile.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//public class XMLFileHandler {
//    public static void main(String[] args) {
//        String filePath = "employee.xml";
//        File xmlFile = new File(filePath);
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder;
//        try {
//            dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(xmlFile);
//            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            NodeList nodeList = doc.getElementsByTagName("Employee");
//            //now XML is loaded as Document in memory, lets convert it to Object List
//            List<Employee> empList = new ArrayList<Employee>();
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                empList.add(getEmployee(nodeList.item(i)));
//            }
//            //lets print Employee list information
//            for (Employee emp : empList) {
//                System.out.println(emp.toString());
//            }
//        } catch (SAXException | ParserConfigurationException | IOException e1) {
//            e1.printStackTrace();
//        }
//    }
//    private static Employee getEmployee(Node node) {
//        //XMLReaderDOM domReader = new XMLReaderDOM();
//        Employee emp = new Employee();
//        if (node.getNodeType() == Node.ELEMENT_NODE) {
//            Element element = (Element) node;
//            emp.setFirstName(getTagValue("firstName", element));
//            emp.setLastName(getTagValue("lastName", element));
//            emp.setExperience(Integer.parseInt(getTagValue("experience", element)));
//            //emp.setDateOfBirth(getTagValue("dateOfBirth", element));
//
//        }
//        return emp;
//    }
//    private static String getTagValue(String tag, Element element) {
//        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
//        Node node = (Node) nodeList.item(0);
//        return node.getNodeValue();
//    }
//}
