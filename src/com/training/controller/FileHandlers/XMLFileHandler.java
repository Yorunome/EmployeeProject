package com.training.controller.FileHandlers;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.training.controller.employeefile.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
public  class XMLFileHandler {
    static int count=0;
    static Employee[] employee;
    public XMLFileHandler ()
    {
        employee=new Employee[100];
        try
        {
            employee[count]=new Employee();
            File file = new File("/Users/rajeshwari/Downloads/employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("employee");
//
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    employee[count].setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    employee[count].setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent());
                    Double d= Double.parseDouble(eElement.getElementsByTagName("experience").item(0).getTextContent());
                    employee[count].setDateOfBirth(date);
                    employee[count].setExperience(d);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Employee[] read()
    {
        return employee;
    }
    /*public Employee write();
    {
    }
    */
}