/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystemteam;


import librarysystemteam.utils.DataLoader;
import librarysystemteam.utils.Borrowings;
import librarysystemteam.utils.WaitingList;
import java.util.ArrayList;


/**
 *
 * @author Sandy
 */
public class LibrarySystemTeam {

    
    
    public static void main(String[] args) {
        

        DataLoader fileLoader = new DataLoader();//Create a new data loader object
        
        ArrayList<Book> bookList = fileLoader.loadBooks() ;//To call in the file loader method from the data loader class populate the Array with the MOCK_DATA.CVS file

        ArrayList<Student> studentList = fileLoader.loadStudent();//To call in the file loader method from the data loader class and populate the Array with the test.txt file

        ArrayList<Borrowings> borrowingsList = fileLoader.loadBorrowings();//To call in the file loader method from the data loader class and populate the Array with the Borrowings.txt file
        
        ArrayList<WaitingList> waitingLists = new ArrayList<>();// To create an Array List to store the waiting list
        
        LibraryController myLibraryStarter = new LibraryController(bookList,studentList,borrowingsList,waitingLists);//Create a new LibraryController object and pass on all the created ArrayLists as arguments
        
        myLibraryStarter.runMenu();//Calls in the Library Controller method to start the menu
        
        
    }
}
