/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystemteam;

import java.util.Scanner;

/**
 *
 * @author Sandy
 */
public class LibrarySystemTeam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Holiii");
        
        
        //RugbyClub Menu -Editar-
        RugbyClub rugbyclub1 = new RugbyClub();
        //Creates an Array of options
        String[] menuOptions = {"List all Staff", "List staff by category", "List all Groups", "List groups by training day", "List all Players"};
        
        //To create a menu object with the menuOptions Array
        Menu menu1 = new Menu(menuOptions);
        
        //Calls the showMenu method from the menu class and out prints it
        System.out.println(menu1.showMenu("Rugby Club Menu"));
        
        //Declare a boolean variable 
        boolean inputValid;
        
        do {
            //Set the boolean variable as true so the loop can stop running when the userInput is a valid option
            inputValid = true;
            
            //method to read the userInput
            Scanner myKB = new Scanner(System.in);
            //Variable to store the userInput selection
            int selectedOption = myKB.nextInt();

            /*https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
            *Skip the new line left over by nextInt
            */
            myKB.nextLine();
            
            //If statements to filter the userInput selection and by doing so indicate the programme to do an specific action

            //it would only be true if the userInput is 0 and if so it would trigger the indicated method
            if(selectedOption == 0 ){

                 //Triggers the method that lists all staff
                rugbyclub1.listAllStaff();

                //it would only be true if the userInput is 1 and if so it would trigger the indicated method
            }else if(selectedOption == 1){

                //Prompt to ask the user to select a staff category
                System.out.println("Please enter any of the following staff categories:"
                       +"\n" + "Ground Staff" +"\n" +  "Care Taker" + "\n" + "Physio" +"\n" + "Assistant Coach"+"\n" + "Swim Teacher" +"\n" 
                        + "Attack Coach"+"\n" + "Defense Coach"+"\n" + "Kicking Coach" +"\n" + "Head Coach" );

                //To store and read userInput
                String selectedCategory = myKB.nextLine();

                 //Triggers the method which list staff by the category seleted by the user
                rugbyclub1.listStaffCategory(selectedCategory);

                //it would only be true if the userInput is 2 and if so it would trigger the indicated method
            }else if(selectedOption == 2){

                //Triggers the method which lists all groups showing the coach and the number of players in the group
                rugbyclub1.listAllGroups();

                //it would only be true if the userInput is 3 and if so it would trigger the indicated method
            }else if(selectedOption == 3){

                //Prompt to ask the user to input a training day
                System.out.println("Please enter a training day (Monday to Friday)");

                //To store and read userInput
                String selectedDay = myKB.next();

                //Triggers the method which lists all groups by the training day selected by the user
                rugbyclub1.listAllGroupsByDay(selectedDay);

                //it would only be true if the userInput is 4 and if so it would trigger the indicated method
            }else if(selectedOption == 4){

                //Triggers the method which lists all players 
                rugbyclub1.listAllPlayers();

            }else{

                System.out.println("Please enter a valid option");

                //Set the boolean to false so the loop keeps going until the userInput is valid
                inputValid = false;
            }
        //It will break out of the loop whenever the user enters a valid option
        } while (inputValid == false);
    }
    
}
