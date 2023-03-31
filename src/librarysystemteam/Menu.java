/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;

/**
 *
 * @author Sandy
 */
public class Menu {
    
    //VetClinic 
    
    private String[] optionList;
    
    
    public Menu(String[] options){
        
        //Setting the value for the optionList (Which is the Array options)
        this.optionList = options;
    }
    
    //Constructor to create showMenu method
    public String showMenu(String header){
        
        
        String menu = "***** " + header + " ******** \n";
        
        for (int count = 0; count < optionList.length; count++){
            
            menu = menu.concat("\n" + count +") " + optionList[count] + ".");
        }
        
        return menu;
    }  
}
