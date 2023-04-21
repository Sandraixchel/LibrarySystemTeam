/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam.utils;

import librarysystemteam.utils.Borrowings;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import librarysystemteam.Book;
import librarysystemteam.Student;

/**
 *
 * @author Sandy
 */
public class DataLoader {

    public DataLoader() {
    }

    public ArrayList<Book> loadBooks() {

        ArrayList<Book> bookList = new ArrayList<Book>();//Create an Book objects Array
        try ( BufferedReader myBuffer = new BufferedReader(new FileReader("MOCK_DATA.csv"))) { //To read the file

            String line; // To store each line of the file
            line = myBuffer.readLine();//Assign line variable the first line value so when we start our while loop starts from second line

            while ((line = myBuffer.readLine()) != null) { // while loop  to go through the file line by line until line is equals to null
                String[] values = line.split(","); // String Array to store the separated values on the line
                //System.out.println(values[1]) Test;

                //Variables to store values an pass them to the new book object 
                String id = values[0];
                String author_first = values[1];
                String author_last = values[2];
                String book_title = values[3];
                String genre = values[4];

                Book myBook = new Book(id, author_first, author_last, book_title, genre);// Create a book object for the current line 

                bookList.add(myBook); // adding book objects to ArrayList
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        } catch (IOException ex) {
            System.out.println("IOException");
            
        }
        
        return bookList;
    }
    
    public ArrayList<Student> loadStudent(){
        
        ArrayList<Student> studentList = new ArrayList<Student>();//Create a Student objects Array
        //ArrayList<int> studentIDList = new ArrayList<int>();//Create a Student objects Array

        try ( BufferedReader myBuffer = new BufferedReader(new FileReader("test.txt"))) { //To read the file

            String line; // To store each line of the file
            //line = myBuffer.readLine();//Assign line variable the first line value so when we start our while loop starts from second line

            while ((line = myBuffer.readLine()) != null) { // while loop  to go through the file line by line until line is equals to null
                String[] values = line.split(","); // String Array to store the separated values on the line
                //System.out.println(values[1]) Test;

                //Variables to store values an pass them to the new book object 
                String studentID = values[0]; //Convert String to int
                //int studentID = Integer.parseInt(values[0]); //Convert String to int
                String firstName = values[1];
                String lastName = values[2];
                String gender = values[3];
                String country = values[4];
                String date = values[5];

                Student myStudent = new Student(studentID, firstName, lastName, gender, country, date);// Create a student object for the current line 
                //StudentID myStudentID = new StudentID (studentID);

                studentList.add(myStudent); // adding student objects to ArrayList
                //studentIDList.add(myStudent.getStudentID());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        } catch (IOException ex) {
            System.out.println("IOException");
        }
        return studentList;
        
    }
    
    public ArrayList<Borrowings> loadBorrowings(){
     ArrayList<Borrowings> borrowingsList = new ArrayList<Borrowings>();//Create an borrowing object Array
        try ( BufferedReader myBuffer = new BufferedReader(new FileReader("BorrowingList.txt"))) { //To read the file

            String line; // To store each line of the file
            line = myBuffer.readLine();//Assign line variable the first line value so when we start our while loop starts from second line

            while ((line = myBuffer.readLine()) != null) { // while loop  to go through the file line by line until line is equals to null
                String[] values = line.split(","); // String Array to store the separated values on the line
                //System.out.println(values[1]) Test;

                //Variables to store values an pass them to the new book object 
                String student_id = values[0];
                String book_title = values[1];

                Borrowings myBorrowing = new Borrowings(student_id, book_title);// Create a book object for the current line 

                borrowingsList.add(myBorrowing); // adding borrowing objects to ArrayList
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        } catch (IOException ex) {
            System.out.println("IOException");
        }
    
        return borrowingsList;
    
    }
    
}

        
    


