/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static librarysystemteam.Library.binarySearchStudent;
import static librarysystemteam.Library.linearSearchBook;
import static librarysystemteam.Library.linearSearchBorrowings;
import static librarysystemteam.Library.linearSearchStudent;

/**
 *
 * @author Sandy
 */
public class LibraryController {

    protected ArrayList<Book> bookList;
    protected ArrayList<Student> studentList;
    protected ArrayList<Borrowings> borrowingsList;
    protected ArrayList<WaitingList> waitingLists;

    public LibraryController(ArrayList<Book> bookList, ArrayList<Student> studentList, ArrayList<Borrowings> borrowingsList, ArrayList<WaitingList> waitingLists) {
        this.bookList = bookList;
        this.studentList = studentList;
        this.borrowingsList = borrowingsList;
        this.waitingLists = waitingLists;
    }

    public void runMenu() {

        Library myLibrary = new Library(bookList, studentList, borrowingsList); //Creates our library with students and books arrays

        //System.out.println(studentList); //Test to check studentArray
        //Creates an Array of options for the menu
        String[] menuOptions = {"Search for a book", "Search for a student", "List all books", "List all students", "Register borrowed books", "Register returned books", "Check student borrowings"};

        //To create a menu object with the menuOptions Array
        Menu menuLibrary = new Menu(menuOptions);
       
        boolean inputValid;

        do {
            //Set the boolean variable as true so the loop can stop running when the userInput is a valid option
            inputValid = true;            
            //Calls the showMenu method from the menu class and out prints it
            System.out.println(menuLibrary.showMenu("Library System Menu"));

            //To read the user Input
            Scanner myScanner = new Scanner(System.in);
            //Variable to store user input selection
            int selectedOption = myScanner.nextInt();

            myScanner.nextLine();

            switch (selectedOption) {
                case 0:
                    System.out.println("Please enter a title or author name");
                    String selected_title_author = myScanner.nextLine();
                    //Library.linearSearchBook(bookList, selected_title_author);
                    Book searchedBook = linearSearchBook(bookList, selected_title_author);
                    if (searchedBook == null) {
                        System.out.println("Sorry, we couldn't find that book. Please enter a title or author name");

                    } else {
                        System.out.println(searchedBook);

                    }
                    break;
                //It will break out of the loop whenever the user enters a valid option
                case 1:
                    String[] menuOptionsSearch = {"Student name", "Student ID"};
                    Menu menuSearch = new Menu(menuOptionsSearch);
                    System.out.println(menuSearch.showMenu("List students by:"));
                    boolean inputValidSearch;
                    do {
                        inputValidSearch = true;
                        Scanner myKB = new Scanner(System.in);
                        int selectedOptionSearch = myScanner.nextInt();
                        myScanner.nextLine();

                        if (selectedOptionSearch == 0) {

                            System.out.println("Please enter a Student Name");
                            String selected_student = myScanner.nextLine();
                            //Library.linearSearchBook(bookList, selected_title_author);
                            Student searchedStudent = linearSearchStudent(studentList, selected_student);
                            if (searchedStudent == null) {
                                System.out.println("Sorry, we couldn't find that student. Please enter another student name or ID ");

                            } else {
                                System.out.println(searchedStudent);

                            }
                            
                        }
                        
                        if (selectedOptionSearch == 1) {
                                System.out.println("Please enter a Student ID");
                                int selected_ID = myScanner.nextInt();
                                Student selected_searched_student = binarySearchStudent(studentList, 0, studentList.size()-1, selected_ID);
                               
                                if (selected_searched_student != null){
                                    
                                System.out.println(selected_searched_student);
                                }
                            }

                    } while (inputValidSearch == false);

                    break;
                case 2:
                    String[] menuOptions2 = {"Title", "Author Name"};
                    Menu menuList = new Menu(menuOptions2);
                    System.out.println(menuList.showMenu("List books by:"));
                    boolean inputValid2;
                    do {
                        inputValid2 = true;
                        Scanner myScanner2 = new Scanner(System.in);
                        int selectedOption2 = myScanner.nextInt();
                        myScanner.nextLine();

                        if (selectedOption2 == 0) {

                            System.out.println("By title");
                            //Calling the method
                            Library.bubbleSortTitle(bookList);

                            // Printing the array after sorted
                            Library.ArraySorted(bookList);
                        } else if (selectedOption2 == 1) {

                            System.out.println("By Author Name");
                            //Calling the method
                            Library.bubbleSortAuthor(bookList);

                            // Printing the array after sorted
                            Library.ArraySorted(bookList);

                        } else {

                            System.out.println("Please enter a valid option");
                            inputValid2 = false;

                        }

                    } while (inputValid2 == false);
                    break;
                case 3:
                    String[] menuOptions3 = {"Student Name", "ID"};
                    Menu menuList3 = new Menu(menuOptions3);
                    System.out.println(menuList3.showMenu("List students by:"));
                    boolean inputValid3;
                    do {
                        inputValid3 = true;
                        Scanner myScanner3 = new Scanner(System.in);
                        int selectedOption3 = myScanner.nextInt();
                        myScanner.nextLine();

                        if (selectedOption3 == 0) {

                            System.out.println("By Student Name");

                            //Calling the method
                            Library.bubbleSortStudentName(studentList);

                            // Printing the array after sorted
                            Library.ArraySortedStudent(studentList);
                        } else if (selectedOption3 == 1) {

                            System.out.println("By ID");

                            //Calling the method
                            Library.bubbleSortStudentID(studentList);

                            // Printing the array after sorted
                            Library.ArraySortedStudent(studentList);
                        } else {

                            System.out.println("Please enter a valid option");
                            inputValid3 = false;
                        }

                    } while (inputValid3 == false);

                    break;

                case 4:

                    System.out.println("Please enter student ID");
                    String selected_id = myScanner.next();
                    //Library.linearSearchBook(bookList, selected_title_author);
                    Student searchedID = linearSearchStudent(studentList, selected_id);
                    if (searchedID == null) {
                        System.out.println("Sorry, we couldn't find that student. Please enter another student ID again.");
                    } else {
                        System.out.println(searchedID);

                    }

                    System.out.println("Please enter a book title");
                    String selected_title = myScanner.next();
                    //Library.linearSearchBook(bookList, selected_title_author);

                    Book searched_book_Title = linearSearchBook(bookList, selected_title);

                    if (searched_book_Title == null) {
                        System.out.println("Sorry, we couldn't find that book. Please enter a book title again");
                    } else {
                        System.out.println(searched_book_Title);

                        String checkBorrowings = linearSearchBorrowings(borrowingsList,selected_title );
                         //System.out.println("Test:" + checkBorrowings);
                         
                        if (searched_book_Title.book_title.equals(checkBorrowings)) { //are the titles identical? equals instead of contains in case there is another book with the same word

                            System.out.println("Sorry, this book is borrowed by another student.");//Then it needs to be added to a waiting list (queue)
                            // Adding to queue
                            myLibrary.addWaitingList(waitingLists, searched_book_Title, selected_id);                           
                            
                            System.out.println("Student " + selected_id + " added to Waiting List.");
                            
                            for (WaitingList waitingList2 : waitingLists) {
                                System.out.println("The waiting list for the book " + waitingList2.getBook().book_title + " is(Student ID's):  " + waitingList2.getQueue());
                            }
                                    
                            
                        } else {

                            String borrowed = (searchedID.studentID + "," + searched_book_Title.getBook_title());//To add student ID plus title ID

                            try {

                                // Initializing BufferedWriter
                                BufferedWriter myWriter = new BufferedWriter(new FileWriter("BorrowingList.txt", true));
                                System.out.println("Adding book...");

                                myWriter.write("\n" + borrowed);

                                // Closing BufferWriter 
                                myWriter.close();
                                System.out.println("Student has been added to borrowings.");

                                Borrowings myBorrowing = new Borrowings(searchedID.getStudentID(), searched_book_Title.getBook_title());// Create a book object for the current line to add it to the Array

                                borrowingsList.add(myBorrowing); // adding borrowing objects to ArrayList to have in memory while running the programme

                            } catch (IOException except) {
                                System.out.println("Error writing this file.");
                            }
                        }

                    }
                    break;      
                case 5:
                    System.out.println("Borrowings");
                    System.out.println(borrowingsList);
                    // return book  -->  id student and book title
                    System.out.println("Enter ID:");
                    String studentID = myScanner.nextLine();
                    
                    System.out.println("Enter Title:");
                    String bookTitle = myScanner.nextLine();
                    
                    //Borrowings example = new Borrowings(studentID, bookTitle);
                    //borrowingsList = myLibrary.returnBook(example, borrowingsList);
                    
                    //Calls in the returnBook method
                    borrowingsList = myLibrary.returnBook(studentID, bookTitle, borrowingsList);
                    System.out.println(borrowingsList);
                    
                    myLibrary.followingWaitingList(waitingLists, bookTitle);
                    //System.out.println("Following :" + following_student );
                    
                    myLibrary.rewriteBorrowingsToFile(borrowingsList);//Method to rewrite borrowings into the txt file excluding the book that was just returned
                    
                    break;    

                   
                case 6:
                    System.out.println("Please enter student ID:");
                    String searchedStudent = myScanner.nextLine();
                    
                    myLibrary.listStudentBorrowings(borrowingsList, searchedStudent);
                    
                
                    break;
                    
                   default:
                    System.out.println("Please enter a valid option");
                    //Set the boolean to false so the loop keeps going until the userInput is valid
                   
                    inputValid = true;
                    
            }

        } while (inputValid != false);
    }

}
