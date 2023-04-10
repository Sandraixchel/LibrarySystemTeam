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
    protected String studentID;
    protected String student_name;
    protected String gender;
    protected String country;
    protected String age;

    
    //CONSTRUCTORS
    public Student(String studentID, String firstName, String lastName, String gender, String country, String age) {
        this.studentID = studentID;
        this.student_name = firstName + " " + lastName; //Concatinating Strings 
        this.gender = gender;
        this.country = country;
        this.age = age;
        
     //METHODS
      
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return student_name;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return age;
    }

    @Override
    public String toString() {
        return "\nStudent {" + " ID= " + studentID + ", Name= " + student_name + ", Gender= " + gender + ", Country= " + country + ", Age = " + age + '}';
    }
    
    
    
    
    
    
    
    
    
}
