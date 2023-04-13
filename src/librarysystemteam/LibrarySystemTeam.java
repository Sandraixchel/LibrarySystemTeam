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
import static librarysystemteam.Library.linearSearchStudent;


/**
 *
 * @author Sandy
 */
public class LibrarySystemTeam {

    //@SuppressWarnings("empty-statement")
    public static void main(String[] args) {

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
            line = myBuffer.readLine();//Assign line variable the first line value so when we start our while loop starts from second line

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

        Library myLibrary = new Library(bookList, studentList); //Creates our library with students and books arrays

        //System.out.println(studentList); //Test to check studentArray
        //Creates an Array of options for the menu
        String[] menuOptions = {"Search for a book", "Search for a student", "List all books", "List all students"};

        //To create a menu object with the menuOptions Array
        Menu menuLibrary = new Menu(menuOptions);

        //Calls the showMenu method from the menu class and out prints it
        System.out.println(menuLibrary.showMenu("Library System Menu"));

        boolean inputValid;

        do {
            //Set the boolean variable as true so the loop can stop running when the userInput is a valid option
            inputValid = true;

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
                        
                    }   break;
            //It will break out of the loop whenever the user enters a valid option
                case 1:
                    System.out.println("Please enter a student name or student ID");
                    String selected_student = myScanner.nextLine();
                    //Library.linearSearchBook(bookList, selected_title_author);
                    Student searchedStudent = linearSearchStudent(studentList, selected_student);
                    if (searchedStudent == null) {
                        System.out.println("Sorry, we couldn't find that student. Please enter another student name or ID ");

                    } else {
                        System.out.println(searchedStudent);

                    }
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
                            Library.bubbleSortAutor(bookList);

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
                            Library.bubbleSortName(studentList);

                            // Printing the array after sorted
                            Library.ArraySortedStudent(studentList);
                        } else if (selectedOption3 == 1) {

                            System.out.println("By ID");
                            
                            //Calling the method
                            Library.bubbleSortID(studentList);

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
                    String selected_id = myScanner.nextLine();
                    //Library.linearSearchBook(bookList, selected_title_author);
                    Student searched_id = linearSearchStudent(studentList, selected_id);
                    if (searched_id == null) {
                        System.out.println("Sorry, we couldn't find that student. Please enter another student ID again.");

                    }else {
                        System.out.println(searched_id);

                    }
 
                    System.out.println("Please enter a book title");
                    String selected_title= myScanner.nextLine();
                    //Library.linearSearchBook(bookList, selected_title_author);
                    Book searchedTitle = linearSearchBook(bookList, selected_title);
                    if (searchedTitle == null) {
                        System.out.println("Sorry, we couldn't find that book. Please enter a book title again");
                        
                    } else {
                        System.out.println(searchedTitle);

                    
                    Queue Borrowings = new Queue(100); //Creating a queue to save borrowed books
                    String borrowed = (selected_id + selected_title);
                    Borrowings.Enqueue(borrowed);
                    
                    try{

                    // Initializing BufferedWriter
                    BufferedWriter myWriter = new BufferedWriter(new FileWriter("BorrowingList.txt"));
                    System.out.println("Adding book...");

                    myWriter.write(borrowed);



                    // Closing BufferWriter 
                    myWriter.close();
                    System.out.println("Student has been added to borrowings.");
                }
                catch (IOException except)
                {
                    System.out.println("Error writing this file.");
                }
                    
                    
                        
                    }   break;
                    
                    
                    
                default:
                    System.out.println("Please enter a valid option");
                    //Set the boolean to false so the loop keeps going until the userInput is valid
                    inputValid = false;
                    break;
            }

            }while (inputValid == false);
           

        } 
    }




/**
 * @param args the command line arguments
 */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        System.out.println("Holiii");
//        
//        
//        //RugbyClub Menu -Editar-
//        RugbyClub rugbyclub1 = new RugbyClub();
//        //Creates an Array of options
//        String[] menuOptions = {"List all Staff", "List staff by category", "List all Groups", "List groups by training day", "List all Players"};
//        
//        //To create a menu object with the menuOptions Array
//        Menu menu1 = new Menu(menuOptions);
//        
//        //Calls the showMenu method from the menu class and out prints it
//        System.out.println(menu1.showMenu("Rugby Club Menu"));
//        
//        //Declare a boolean variable 
//        boolean inputValid;
//        
//        do {
//            //Set the boolean variable as true so the loop can stop running when the userInput is a valid option
//            inputValid = true;
//            
//            //method to read the userInput
//            Scanner myKB = new Scanner(System.in);
//            //Variable to store the userInput selection
//            int selectedOption = myKB.nextInt();
//
//            /*https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
//            *Skip the new line left over by nextInt
//            */
//            myKB.nextLine();
//            
//            //If statements to filter the userInput selection and by doing so indicate the programme to do an specific action
//
//            //it would only be true if the userInput is 0 and if so it would trigger the indicated method
//            if(selectedOption == 0 ){
//
//                 //Triggers the method that lists all staff
//                rugbyclub1.listAllStaff();
//
//                //it would only be true if the userInput is 1 and if so it would trigger the indicated method
//            }else if(selectedOption == 1){
//
//                //Prompt to ask the user to select a staff category
//                System.out.println("Please enter any of the following staff categories:"
//                       +"\n" + "Ground Staff" +"\n" +  "Care Taker" + "\n" + "Physio" +"\n" + "Assistant Coach"+"\n" + "Swim Teacher" +"\n" 
//                        + "Attack Coach"+"\n" + "Defense Coach"+"\n" + "Kicking Coach" +"\n" + "Head Coach" );
//
//                //To store and read userInput
//                String selectedCategory = myKB.nextLine();
//
//                 //Triggers the method which list staff by the category seleted by the user
//                rugbyclub1.listStaffCategory(selectedCategory);
//
//                //it would only be true if the userInput is 2 and if so it would trigger the indicated method
//            }else if(selectedOption == 2){
//
//                //Triggers the method which lists all groups showing the coach and the number of players in the group
//                rugbyclub1.listAllGroups();
//
//                //it would only be true if the userInput is 3 and if so it would trigger the indicated method
//            }else if(selectedOption == 3){
//
//                //Prompt to ask the user to input a training day
//                System.out.println("Please enter a training day (Monday to Friday)");
//
//                //To store and read userInput
//                String selectedDay = myKB.next();
//
//                //Triggers the method which lists all groups by the training day selected by the user
//                rugbyclub1.listAllGroupsByDay(selectedDay);
//
//                //it would only be true if the userInput is 4 and if so it would trigger the indicated method
//            }else if(selectedOption == 4){
//
//                //Triggers the method which lists all players 
//                rugbyclub1.listAllPlayers();
//
//            }else{
//
//                System.out.println("Please enter a valid option");
//
//                //Set the boolean to false so the loop keeps going until the userInput is valid
//                inputValid = false;
//            }
//        //It will break out of the loop whenever the user enters a valid option
//        } while (inputValid == false);
//    }

