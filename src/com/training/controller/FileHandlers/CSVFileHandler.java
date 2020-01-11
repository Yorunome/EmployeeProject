package com.training.controller.FileHandlers;

import com.opencsv.CSVWriter;
import com.training.controller.employeefile.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVFileHandler {
    static int count;
    static Employee[] employee;

    public CSVFileHandler() {
        count = 0;

    }

    public Employee[] read() {
        employee = new Employee[100];
        String csvFile = "/Users/rajeshwari/Downloads/employee.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                employee[count] = new Employee();
                // use comma as separator
                String[] ReadFromCSV = line.split(cvsSplitBy);
                //System.out.println(ReadFromCSV[0]);
                employee[count].setFirstName(ReadFromCSV[0]);
                employee[count].setLastName(ReadFromCSV[1]);
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ReadFromCSV[2]);
                employee[count].setDateOfBirth(date);
                Double d = Double.parseDouble(ReadFromCSV[3]);
                employee[count].setExperience(d);
                count++;
                //return employee;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException p) {
            p.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return employee;

    }

    public void write(Employee e, FileWriter output)
    {

        try {

            CSVWriter writer = new CSVWriter(output);
            String[] header = { "firstName", "lastName", "dateOfJoining", "experience" };
            writer.writeNext(header);
            String numberAsString = Double.toString(e.getExperience());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String[] s={e.getFirstName(),e.getLastName(),numberAsString};
            //System.out.println(e.getFirstName());
            writer.writeNext(s);
            writer.flush();
            //writer.close();
        }
        catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }



}

