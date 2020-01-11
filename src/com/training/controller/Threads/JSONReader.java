package com.training.controller.Threads;

import com.training.controller.FileHandlers.JSONFileHandler;
import com.training.controller.MyCollection;
import com.training.controller.employeefile.Employee;


public class JSONReader extends Thread {
    public JSONReader(){
        super("XML Reader Thread");
    }
    public void run(){
        JSONFileHandler xreader = new JSONFileHandler();
        Employee[] e1 = xreader.Employeeread();
        MyCollection c1 = new MyCollection();
        c1.setEmployees(e1);
    }

}