/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;



/**
 *
 * @author Sandy
 */
public class Borrowings {
    
    public String studentID;
    public String bookTitle;
    
    public Borrowings(String studentID, String bookTitle){
    
       this.studentID = studentID;
       this.bookTitle = bookTitle;
    
    }

    public String getStudentID() {
        return studentID;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "\nBorrowings { " + " Student ID =  " + studentID + " Book Title = " + bookTitle + "}";
    }
    
    
    
}
