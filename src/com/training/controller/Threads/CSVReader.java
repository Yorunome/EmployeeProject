package com.training.controller.Threads;

import com.training.controller.FileHandlers.CSVFileHandler;
import com.training.controller.MyCollection;
import com.training.controller.employeefile.Employee;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader extends Thread{
    public CSVReader(){
        super("CSVReader thread");
    }
    public void run(){
        System.out.println("Current Thread: "
                + Thread.currentThread().getName());
        CSVFileHandler cv1 = new CSVFileHandler();
        Employee[] e1 = cv1.read();
        MyCollection c1 = new MyCollection();
        c1.setEmployees(e1);
    }



}