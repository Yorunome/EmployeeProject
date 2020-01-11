package com.training.controller;

import com.training.controller.Threads.*;


public class MyController {
    public static void main(String[] args) {

        try {
            CSVReader csvReader = new CSVReader();
            csvReader.start();
            //System.out.println("Current Thread: " + Thread.currentThread().getName());
//            XMLReader xmlReader = new XMLReader();
//            xmlReader.start();
            //System.out.println("Current Thread: " + Thread.currentThread().getName());
            JSONReader jsonReader = new JSONReader();
            jsonReader.start();
            csvReader.join();
            jsonReader.join();
            //xmlReader.join();
//            System.out.println("Current Thread: " + Thread.currentThread().getName());
//
//            System.out.println("Current Thread: " + Thread.currentThread().getName());
//            System.out.println("Current Thread: " + Thread.currentThread().getName());

            MongoWriterFromCollection collection = new MongoWriterFromCollection();
            collection.start();
            PGWriter pgwrite = new PGWriter();
           pgwrite.start();
            collection.join();
            //pgwrite.join();
           // System.out.println("Current Thread: " + Thread.currentThread().getName());
            //collection.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
