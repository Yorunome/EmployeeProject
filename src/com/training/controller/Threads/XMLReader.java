package com.training.controller.Threads;

import com.training.controller.FileHandlers.XMLFileHandler;
import com.training.controller.MyCollection;
import com.training.controller.employeefile.Employee;


public class XMLReader extends Thread {
    public XMLReader(){
        super("XML Reader Thread");
    }
    public void run(){
        XMLFileHandler xreader = new XMLFileHandler();
        Employee[] e1 = xreader.read();
        MyCollection c1 = new MyCollection();
        c1.setEmployees(e1);
    }

}


