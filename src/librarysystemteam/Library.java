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
    
    //We Need to add student array to the paramethers to create a library object
    public Library(ArrayList<Book> bookList){
        
        this.bookList = bookList;


 
    }
  // Here we can put all of our methods either searching or sorting for books or students, so we can call them from the main 
    public static Book linearSearch(ArrayList<Book> bookList, String targetBook) {
         
            
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
         int n = bookList.size();
         
         Book temp;
         
//        for (int i = 0; i < n - 1; i++) {      
//           
//            Book myBook2 = bookList.get(i);
//            String sorttitle = myBook2.getBook_title().toLowerCase();
//            
//            for (int j = 0; j < n - i - 1; j++) {
//            if (bookList[j].equals(bookList[j + 1])) {
//                continue;
//            }
//            if (!bookList[j].equals(bookList[j + 1]) && bookList[j].hashCode() > boolean [j + 1].hashCode()) {
//                temp = bookList[j];
//                bookList[j] = bookList[j + 1];
//                bookList[j + 1] = temp;
//            }
//        }
//    }
//            
//
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
    
     public static void ArraySorted(ArrayList<Book> bookList) {

                    String toPrint = "[ ";
                    for (int i = 0; i < bookList.size(); i++) {
                     toPrint += bookList.get(i) + " ";

                    }
                    toPrint += "]";
                    System.out.println(toPrint);

                }
    
    
}


