/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystemteam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static librarysystemteam.Library.linearSearchBook;
import static librarysystemteam.Library.linearSearchBorrowings;
import static librarysystemteam.Library.linearSearchStudent;
import static librarysystemteam.Library.binarySearchStudent;

/**
 *
 * @author Sandy
 */
public class LibrarySystemTeam {

    
    //@SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        ArrayList<WaitingList> waitingLists = new ArrayList<>();

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

        System.out.println(borrowingsList);

        Library myLibrary = new Library(bookList, studentList); //Creates our library with students and books arrays

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
                                Student selected_searched_student = binarySearchStudent(studentList, 0, studentList.size(), selected_ID);
                                System.out.println(selected_searched_student);
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
                         System.out.println("Test:" + checkBorrowings);
                         
                        if (searched_book_Title.book_title.equals(checkBorrowings)) { //are the titles identical? equals instead of contains in case there is another book with the same word

                            System.out.println("Sorry, this book is borrowed by another student.");//Then it needs to be added to a waiting list (queue)
                            // Adding to queue
                            myLibrary.addWaitingList(waitingLists, searched_book_Title, selected_id);
                            
                            System.out.println("Student " + selected_id + "added to Waiting List.");
                            
                            for (WaitingList waitingList : waitingLists) {
                                System.out.println(waitingList.getBook().book_title + " " + waitingList.getQueue());
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

//                    try ( BufferedReader myBuffer = new BufferedReader(new FileReader("BorrowingList.txt"))) { //To read the file
//
//                    String line; // To store each line of the file
//                    line = myBuffer.readLine();//Assign line variable the first line value so when we start our while loop starts from second line
//
//                    while ((line = myBuffer.readLine()) != null) { // while loop  to go through the file line by line until line is equals to null
//                        String[] values = line.split(","); // String Array to store the separated values on the line
//                        //System.out.println(values[1]) Test;
//
//                        //Variables to store values an pass them to the new book object 
//                        String student_id = values[0];
//                        String book_title = values[1];
//                        
//                        Queue borrowings2 = new Queue(100);
//                        String myBorrowedBook = (student_id + book_title);// Create a String
//                            
//                        if(selected_title.equals(book_title)){
//                            
//                    try{
//
//                        // Initializing BufferedWriter
//                        BufferedWriter myWriter = new BufferedWriter(new FileWriter("WaitingList.txt", true));
//                        System.out.println("Adding book to Waiting List...");
//
//                        myWriter.write("\n" + myBorrowedBook);
//
//                        // Closing BufferWriter 
//                        myWriter.close();
//                        System.out.println("Added to Waiting List.");
//
//                    }
//                    catch (IOException except)
//                    {
//                        System.out.println("Error writing this file.");
//                            
//    
//                        }
//                    }else{
//                        borrowings.Enqueue(myBorrowedBook); // adding book objects to a Queue
//                        }
//                    }
//                } catch (FileNotFoundException ex) {
//                    System.out.println("File not found");
//
//                } catch (IOException ex) {
//                    System.out.println("IOException");
//                }
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
                    
                    
                    
                    Borrowings example = new Borrowings(studentID, bookTitle);
                    borrowingsList = myLibrary.returnBook(example, borrowingsList);
                    System.out.println(borrowingsList);
                    
                    String following = myLibrary.followingWaitingList(waitingLists, bookTitle);
                    System.out.println("Following :" + following );
                    break;    

                default:
                    System.out.println("Please enter a valid option");
                    //Set the boolean to false so the loop keeps going until the userInput is valid
                    inputValid = false;
                    break;
            }

        } while (inputValid != false);

    }
}
