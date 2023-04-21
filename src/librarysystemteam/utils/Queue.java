package librarysystemteam.utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sandy
 * 
 * 
 */
    public class Queue{
        
        
    public interface ArrayQueue {

    /**
     * Adds an element at the back of the queue
     *
     * @param newElement
     * @return false is capacity full
     */
    public boolean Enqueue(String newElement);

    /**
     * Removes an element from the front of the queue
     *
     * @return null if queue is empty
     */
    public String Dequeue();

    /**
     * First element of the queue without removing it
     *
     * @return null if empty
     */
    public String First();

    /**
     * Last element of the queue without removing it
     *
     * @return null if empty
     */
    public String Last();

    /**
     * Number of elements in the queue
     *
     * @return
     */
    public int size();

    /**
     * True if there is no elements in the queue
     *
     * @return
     */
    public boolean isEmpty();

}



    
    private String[] data;
    private int queueSize;
    private int capacity;
    private int frontElement;
    private int backElement;
    

    public Queue (int capacity){
        this.capacity = capacity;
        this.data= new String [capacity];
        this.queueSize = 0;
        this.frontElement = -1;
        this.backElement = -1;
           
}

    
    public boolean Enqueue(String newElement) {
        
        if(queueSize >= capacity){
            return false;
        }
        
        if (frontElement==-1){
            frontElement++;
        }
            
        
        backElement++;
        data[backElement] = newElement;
        queueSize++;
        return true;
                
        
    }

    
    public String Dequeue() {
        
        String toReturn = data[frontElement];
        data [frontElement] = null;
        frontElement++;
        //queueSize--;
        return toReturn;
    }

    
    public String First() {
        
        if (queueSize ==0){
            return null;
        }
        String first = data[frontElement];
        return first;
    }

    
    public String Last() {
        
        if (queueSize ==0){
            return null;
        }
        String back = data[backElement];
        return back;
        
    }

    
    public int size() {
        
        return queueSize;
    }

    
    public boolean isEmpty() {
        
        if (queueSize == 0){
        
            return true;
        }
            return false;
        
    }
    
    public String toString(){
        
        String toReturn = "[";
         
         for (int i = frontElement; i<= backElement; i++){ //To loop through my queue
             toReturn += data [i] + " ";
         
         }
         
         toReturn += "]";
         
         return toReturn;
    
    }
}
