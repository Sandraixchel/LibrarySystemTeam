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
    
    public static void bubbleSortTitle(ArrayList<Book> bookList){
        
         System.out.println("--List of books ordered alphabetically--");
//         int n = bookList.size();
//         
//         Book temp = null;
//         
//        for (int i = 0; i < n - 1; i++) {      
//           
//            Book myBook2 = bookList.get(i);
//            String sorttitle = myBook2.getBook_title().toLowerCase();
//            
//            for (int j = 0; j < n - i - 1; j++) {
//            if (sorttitle(j).equals(sorttitle(j + 1))) {
//                continue;
//            }
//            if (!bookList.get(j).equals(bookList.get(j + 1)) && bookList.get(j).hashCode() > boolean [j + 1].hashCode()) {
//                bookList.set(j, bookList.get(j));
//                bookList.set(j, bookList.get(j + 1));
//                bookList.set(j + 1, temp);
//            }
//        }
//    }
        
//            }
//        

//        do{
//            swapped = false;
//            for (int i = 0; i < n - 1; i++) {
//                if(bookList.get(i).equals(bookList.get(i +1))) > 0{
//                    swapped = true;
//                    temp = bookList.get(i);
//                    bookList.set(i, bookList.get(i+1));
//                    bookList.set(i + 1,temp);
//                }
//                
//            }
//            
//            
//        } while(swapped);
         
    
    
    
    
//        public static void bubbleSortName(ArrayList<Book> bookList){

//        String sortname = myBook2.getAuthor_name().toLowerCase();
//            
//        }
           
    }
    
    public static void bubbleSortAutor(ArrayList<Book> bookList){
        
    }
    
     public static void ArraySorted(ArrayList<Book> bookList) {
                    
                    String toPrint = "[ ";
                    for (int i = 0; i < bookList.size(); i++) {
                     toPrint += bookList.get(i) + " ";

                    }
                    toPrint += "]";
                    System.out.println(toPrint);

                }
       public static Student linearSearchStudent(ArrayList<Student> studentList, String targetStudent) {
         
            
            for (int i = 0; i < studentList.size() ; i++) {
                Student myStudent = studentList.get(i);
                String ID = myStudent.studentID;
                String name = myStudent.student_name.toLowerCase();// create variables to set them to lower case 
                
                if (ID.contains(targetStudent.toLowerCase()) || name.contains(targetStudent.toLowerCase())) 
                    return myStudent;
                
               
            }
            
        return null;
    }
       
       public static void bubbleSortName(ArrayList<Student> studentList){


       }

       public static void bubbleSortID(ArrayList<Student> studentList){
           
//           
//        int n = studentList.size();
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                Student myStudent = studentList.get(i);
//                String ID = myStudent.studentID;
//                if (studentList.get(j).getStudentID().compareTo(ID)(studentList.get(j+1).getStudentID() > 0) {
//                    
//                    Student temp = studentList.get(j);
//                    studentList.set(j, studentList.get(j+1));
//                    studentList.set(j+1, temp);
//                }
//            }
//        }
//    
//        
//        System.out.println("--Array Sorted--");
       


       }


        public static void ArraySortedStudent(ArrayList<Student> studentList) {

                String toPrint = "[ ";
                for (int i = 0; i < studentList.size(); i++) {
                 toPrint += studentList.get(i) + " ";

                }
                toPrint += "]";
                System.out.println(toPrint);

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
           
           
       
       
       
       
       
       
       
//       public static int binarySearchStudent(ArrayList<Student> studentList,int first, int last, int studentTarget){
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
//        return -1;
//       
//       }
    
    



