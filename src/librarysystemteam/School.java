/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;

import java.util.ArrayList;

/**
 *
 * @author KAREN
 */
class School {
    
     //We Need to add the Array of students objects to the properties
    protected ArrayList<Student> studentList;
    
    //We Need to add student array to the paramethers to create a library object
    public School(ArrayList<Student> studentList){
        
        this.studentList = studentList;
        

    }
    
}
