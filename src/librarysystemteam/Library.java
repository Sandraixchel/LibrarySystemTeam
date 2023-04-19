/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Sandy
 */
public class Library {
    
    //We Need to add the Array of students objects to the properties
    protected ArrayList<Book> bookList;
    protected ArrayList<Student> studentList;
    protected ArrayList<Borrowings> borrowingList;
    protected ArrayList<WaitingList> waitingList;
    
    //We Need to add student array to the paramethers to create a library object
    public Library(ArrayList<Book> bookList, ArrayList<Student> studentList){
        
        this.bookList = bookList;
        this.studentList = studentList;
        


 
    }
  // Here we can put all of our methods either searching or sorting for books or students, so we can call them from the main 
    public static Book linearSearchBook(ArrayList<Book> bookList, String targetBook) {
         
            
            for (int i = 0; i < bookList.size() ; i++) {
                Book myBook = bookList.get(i);
                String title = myBook.getBook_title().toLowerCase();// create variables to set them to lower case 
                String name = myBook.getAuthor_name().toLowerCase();
                
                if (title.contains(targetBook.toLowerCase()) || name.contains(targetBook.toLowerCase())) 
                    return myBook;
            }
            
        return null;
    }
    public static Student linearSearchStudent(ArrayList<Student> studentList, String targetStudent) {


        for (int i = 0; i < studentList.size() ; i++) {
            Student myStudent = studentList.get(i);
            String ID = myStudent.studentID;
            String name = myStudent.student_name.toLowerCase();// create variables to set them to lower case 

            if (ID.contains(targetStudent.toLowerCase()) || name.contains(targetStudent.toLowerCase())) //ID.contains(targetStudent.toLowerCase()) ||
                return myStudent;


        }

        return null;
    }
    public static Student binarySearchStudent(ArrayList<Student> studentList,int first, int last, int studentIDsearch){
           
       
        //System.out.println("Sorted Array: " + studentList);
        
       
        int mid = (first+last)/2;
        
        while (first <= last){
            if (Integer.parseInt(studentList.get(mid).getStudentID()) < studentIDsearch){ //change them to ints
            first = mid +1;
            
        }else if(Integer.parseInt(studentList.get(mid).getStudentID()) == studentIDsearch ){
                
            //System.out.println("Element is found at index: " + mid);
            
            return studentList.get(mid);
        
        }else {
            last = mid -1;
        
        }
            mid = (first + last)/2;
        }
        if (first>last){
            System.out.println("Element is not found");
        }
        return null;
       
       }
    
    public static void bubbleSortTitle(ArrayList<Book> bookList){
        
         System.out.println("--List of books ordered alphabetically by Title--");
         int n = bookList.size();
 
         for (int i = 0; i < n - 1; i++) {      
       
            for (int j = 0; j < n - i - 1; j++) {
            if (bookList.get(j).getBook_title().compareToIgnoreCase(bookList.get(j+1).getBook_title()) > 0) {
                
                Book temp = bookList.get(j);
          
                
                bookList.set(j,bookList.get(j+1));
                bookList.set(j+1, temp);
                }
            }
        }
       
    }
    
    public static void bubbleSortAuthor(ArrayList<Book> bookList){
        
         System.out.println("--List of books ordered alphabetically by Author--");
         int n = bookList.size();
 
         for (int i = 0; i < n - 1; i++) {      
       
            for (int j = 0; j < n - i - 1; j++) {
            if (bookList.get(j).getAuthor_name().compareToIgnoreCase(bookList.get(j+1).getAuthor_name()) > 0) {
                
                Book temp = bookList.get(j);
          
                
                bookList.set(j,bookList.get(j+1));
                bookList.set(j+1, temp);
                }
            }
        }
    }
    
     public static void ArraySorted(ArrayList<Book> bookList) {
                    
                    String toPrint = "[ ";
                    for (int i = 0; i < bookList.size(); i++) {
                     toPrint += bookList.get(i) + " ";

                    }
                    toPrint += "]";
                    System.out.println(toPrint);

                }
   
       
    public static void bubbleSortStudentName(ArrayList<Student> studentList){
        
         System.out.println("--List of students ordered alphabetically by Student Name--");
         int n = studentList.size();
 
        for (int i = 0; i < n - 1; i++) {      
       
            for (int j = 0; j < n - i - 1; j++) {
            if (studentList.get(j).getStudentName().compareToIgnoreCase(studentList.get(j+1).getStudentName()) > 0) {
                
                Student temp = studentList.get(j);
          
                
                studentList.set(j,studentList.get(j+1));
                studentList.set(j+1, temp);
                }
            }
        }
    }

    public static void bubbleSortStudentID(ArrayList<Student> studentList){
        
         System.out.println("--List of students ordered by student ID");
         int n = studentList.size();
 
        for (int i = 0; i < n - 1; i++) {      
       
            for (int j = 0; j < n - i - 1; j++) {//Fix with ID
            if (studentList.get(j).getStudentID().compareToIgnoreCase(studentList.get(j+1).getStudentID()) > 0) {
                
                Student temp = studentList.get(j);
          
                
                studentList.set(j,studentList.get(j+1));
                studentList.set(j+1, temp);
                }
            }
        }
    }


    public static void ArraySortedStudent(ArrayList<Student> studentList) {

            String toPrint = "[ ";
            for (int i = 0; i < studentList.size(); i++) {
             toPrint += studentList.get(i) + " ";

            }
            toPrint += "]";
            System.out.println(toPrint);

        }
    public static String linearSearchBorrowings(ArrayList<Borrowings> borrowingsList, String targetBorrowing) {
         
            
            for (int i = 0; i < borrowingsList.size() ; i++) {
                Borrowings myBorrowing = borrowingsList.get(i);
                String title = myBorrowing.bookTitle.toLowerCase();// create variables to set them to lower case 
                //String name = myBorrowing.studentID.toLowerCase();
                
                if (title.contains(targetBorrowing.toLowerCase())) //|| name.contains(targetBorrowing)
                    return myBorrowing.bookTitle;
            }
            
        return null;
        
        
    }
    
    
    public void followingWaitingList(ArrayList<WaitingList> waitingList, String bookTitle){
        for (int i = 0; i < waitingList.size(); i++) {
            if(waitingList.get(i).getBook().book_title.equalsIgnoreCase(bookTitle)){
                // A waiting List exists
               String following_student = waitingList.get(i).getQueue().Dequeue();
               System.out.println("Following student:" + following_student);
                
            }
            
        }
        //return following_student;
    }
    
    public boolean addWaitingList(ArrayList<WaitingList> waitingList, Book book, String StudentID){
        for (int i = 0; i < waitingList.size(); i++) {
            if(waitingList.get(i).getBook().book_title.equalsIgnoreCase(book.getBook_title())){
                // adding to waiting List
                waitingList.get(i).getQueue().Enqueue(StudentID);

                return true;
            }
            
        }
        
                            Queue waiting_list = new Queue(100);
                            waiting_list.Enqueue(StudentID);
                            waitingList.add(new WaitingList(book));
        return true;
    }
    
        public ArrayList<Borrowings> returnBook(String searched_studentID, String searched_bookTitle, ArrayList<Borrowings> borrowingsList){
        boolean found = false;
        for (int i = 0; i < borrowingsList.size(); i++) {
            if(borrowingsList.get(i).studentID.equalsIgnoreCase(searched_studentID)
                    && borrowingsList.get(i).bookTitle.toLowerCase().contains(searched_bookTitle.toLowerCase())
                    ){
                System.out.println("This book has been returned");
                borrowingsList.remove(i);
                found = true;
                break;
            }
            
        }
        if(found == false){
            System.out.println("Book not found.");
        }
        
        return borrowingsList;
    }
   public void rewriteBorrowingsToFile(ArrayList<Borrowings> borrowingsList){ //To rewrite the whole filw with the current borrowings list, use when returning a borrowing
       
          
        try {
            
            BufferedWriter myWriter;
            myWriter = new BufferedWriter(new FileWriter("BorrowingList.txt", false));
            myWriter.write("ID,Book Title");
            
            for(Borrowings borrowed : borrowingsList ){ //To go through the borrowings list Array one by one
                
            myWriter.write("\n" +borrowed.studentID + ","+ borrowed.bookTitle);
            
            }           
          myWriter.close();// Closing BufferWriter
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println("Adding book...");
     
   }
   
   public void writeWaitingList(ArrayList<WaitingList> waitingList){ //Needs to be fixed
   
   
       try {
            
            BufferedWriter myWriter;
            myWriter = new BufferedWriter(new FileWriter("WaitingList.txt", true));
            myWriter.write("ID,Book Title");
            
            for(WaitingList nextWaiting : waitingList ){ //To go through the borrowings list Array one by one
                
           // myWriter.write("\n" +nextWaiting. + ","+ borrowed.bookTitle);
            
            }           
          myWriter.close();// Closing BufferWriter
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println("Adding book...");
   
   }
   
   public void listStudentBorrowings(ArrayList<Borrowings> borrowingsList, String searchedStudent){
        
        //System.out.println("The student:" + searchedStudent + " has borrowed: ");
        
       for (Borrowings studentBorrowings : borrowingsList){ //Creates a loop to go through the borrowings List line by line 
       
           if(searchedStudent.equals(studentBorrowings.studentID)){ //if the user input is equals to the a student ID in our Borrowings List it will print the Book title
               
               System.out.println("The student:" + studentBorrowings.studentID + " has borrowed: " + studentBorrowings.bookTitle);
           }else{
           
           
           }
           
       
       
       }
       
   
   
   }
   
   
}


       
    
 

           
       
       
       
       
       
       
       
    
    



