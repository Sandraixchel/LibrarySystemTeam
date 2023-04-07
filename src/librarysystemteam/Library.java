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
    
}


