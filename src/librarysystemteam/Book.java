/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemteam;

/**
 *
 * @author Sandy
 */
public class Book {
    
     //Properties
    protected String id ;
    protected String book_title;
    protected String genre;
    protected String author_name;

    //Constructors
    public Book(String id, String author_first, String author_last, String book_title, String genre) {
        this.id = id;
        this.author_name = author_first + " " + author_last;//Concatinating Strings 
        this.book_title = book_title;
        this.genre = genre;
        
    }

    public String getAuthor_name() {
        return author_name;
    }
    
    public String getId() {
        return id;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "\nBook{" + "ID = " + id + ", Author Name = " + author_name + ", Book Title = " + book_title + ", Genre = " + genre + '}';
        
    }
    
}
