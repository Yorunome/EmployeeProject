package com.training.controller.employeefile;

import java.util.Date ;

public class Employee {
    String firstName ;
    String lastName ;
    String middleName ;
    Date dateOfBirth ;
    String title ;
    String departmentName ;
    double experience ;

    /*public Employee(String firstName, String lastName, Date dateOfBirth, double experience){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
    }*/

    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unchecked")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "ESOP{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", title='" + title + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", experience=" + experience +
                '}';
    }

    @Deprecated
    public String deprecatedMethod(){
        return "Test";
    }

     /*Employee createEmployee() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String middleName = getMiddleName();
        Date date = getDateOfBirth();
        String title = getTitle();
        String department = getDepartmentName();
        double experience = getExperience();

        // create and return book of this metadata
        return new Employee(firstName, lastName, date, experience);
    }*/

}