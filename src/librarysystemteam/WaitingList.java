/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;

/**
 *
 * @author Sandy
 */
public class WaitingList {
    
    private Book book;
    private Queue queue;

    public WaitingList() {
    }

    public WaitingList(Book book) {
        this.book = book;
    }
    
    

    public WaitingList(Book book, Queue queue) {
        this.book = book;
        this.queue = queue;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "WaitingList{" + "book=" + book + ", queue=" + queue + '}';
    }
    
    
}
