package com.training.controller;

import com.mongodb.MongoClient;
import com.training.controller.employeefile.Employee;
import com.training.controller.mongodb.MongoDBCOntroller;
import com.training.controller.mongodb.MongoOperations;
import com.training.controller.postgres.SQLOperations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class MyCollection {
    public static List<Employee> e1= new ArrayList<Employee>();
    public void setEmployees(Employee[] emp){

        e1.addAll(Arrays.asList(emp));
        System.out.println(e1.size());
//        e1.forEach(e -> {
//            System.out.println("First Name : " + e.getFirstName() + ", Last Name : " + e.getLastName());
//        });
    }

//    public void getEmployeesCSV(){
//        System.out.println("CSV Writer method");
//        String filePath= "/Users/rajeshwari/IdeaProjects/EmployeeProject/src/e.csv";
//        File file = new File(filePath);
//        try (FileWriter output = new FileWriter(file)) {
//            for (Employee emp : e1) {
//                CSVFileHandler c = new CSVFileHandler();
//                c.write(emp, output);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public synchronized void writeIntoMongoDB(){
        System.out.println("Size of collection currently : " + e1.size());
        MongoDBCOntroller controller = new MongoDBCOntroller();
        MongoClient mongo = controller.startDB();
        MongoOperations operator = new MongoOperations(mongo);
        int i = 0;
        //e1.forEach(e -> {
//            operator.setData(e.getFirstName(), e.getLastName(), e.getDateOfBirth(), e.getExperience());
//        });
//        e1.forEach(e -> {
//         System.out.println("First Name : " + e.getFirstName() + ", Last Name : " + e.getLastName()); });


        for(Employee e : e1){
           // System.out.println(i++);
            if (i==201) break;
            operator.setData(e.getFirstName(), e.getLastName(), e.getDateOfBirth(), e.getExperience());
        }
    }

    public synchronized void writeInPostGres() throws ClassNotFoundException, SQLException{
        SQLOperations operator = new SQLOperations();
        Iterator<Employee> it = e1.iterator();
        int i = 0;
        for(Employee e : e1){
            i++;
            //System.out.println(i++);
            if (i>100) return;
            operator.insertIntoTable(e.getFirstName(), e.getLastName(), e.getExperience());
        }
    }

}
