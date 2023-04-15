/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;


import java.util.ArrayList;


/**
 *
 * @author Sandy
 */
public class Library {
    
    //We Need to add the Array of students objects to the properties
    protected ArrayList<Book> bookList;
    protected ArrayList<Student> studentList;
    protected ArrayList<Borrowings> borrowingList;
    
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
                
            System.out.println("Element is found at index: " + mid);
            
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
        
         System.out.println("--List of books ordered alphabetically--");
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
        
         System.out.println("--List of books ordered alphabetically--");
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
        
         System.out.println("--List of books ordered alphabetically--");
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
        
         System.out.println("--List of books ordered alphabetically--");
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
    



       
    
//           
//        public void addBorrowing(String file){   
//           
//           
//            try
//            {
//                
//                // Initializing BufferedWriter
//                BufferedWriter myWriter = new BufferedWriter(new FileWriter("BorrowingList.txt"));
//                System.out.println("Adding book...");
//                
//                myWriter.write(borrowed);
//                
//               
//
//                // Closing BufferWriter 
//                myWriter.close();
//                System.out.println("Student has been added to borrowings.");
//            }
//            catch (IOException except)
//            {
//                System.out.println("Error writing this file.");
//            }
//
//        }
}

           
          // BufferedWriter myWriter = new BufferedWriter(new FileWriter(<BorrowingList.txt>, true));
           
//           String data = "This is the data in the output file";
//
//            try {
//                
//             // Creates a FileWriter
//              FileWriter file = new FileWriter("BorrowingList.txt");
//
//                
//              // Creates a BufferedWriter
//              BufferedWriter myWriter = new BufferedWriter("BorrowingList.txt");
//
//              // Writes the string to the file
//              myWriter.write(data);
//
//              // Closes the writer
//              myWriter.close();
//            }
//
//            catch (Exception e) {
//              e.getStackTrace();
//            }
           
           
       
       
       
       
       
       
       
//       public Student binarySearchStudent(ArrayList<Student> studentList,int first, int last, int studentIDsearch){
//           
//       
//        System.out.println("Sorted Array: " + studentList);
//        
//       
//        int mid = (first+last)/2;
//        
//        while (first <= last){
//            if (studentList.get(mid).getStudentID() < studentTarget){
//            first = mid + 1;
//            
//        }else if(studentList.get(mid).getStudentID() == studentTarget ){
                //return studentList.get(mid);
//            System.out.println("Element is found at index: " + mid);
//        
//        break;
//        
//        }else {
//            last = mid -1;
//        
//        }
//            mid = (first + last)/2;
//        }
//        if (first>last){
//            System.out.println("Element is not found");
//        }
//        return null;
//       
//       }
    
    



