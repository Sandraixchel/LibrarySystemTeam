/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;

/**
 *
 * @author Sandy
 */
public class Student {
    
    //PROPERTIES
    protected String student;
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected String country;
    protected String date;

    
    //CONSTRUCTORS
    public Student(String student, String firstName, String lastName, String gender, String country, String date) {
        this.student = student;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.date = date;
        
     //METHODS
     
     
     
    }

    public String getStudent() {
        return student;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Student{" + "student=" + student + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", country=" + country + ", date=" + date + '}';
    }
    
    
    
    
    
    
    
    
    
}
