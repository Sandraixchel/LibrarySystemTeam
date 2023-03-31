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
    protected String author_first;
    protected String author_last;
    protected String book_title;
    protected String genre;

    //Constructors
    public Book(String id, String author_first, String author_last, String book_title, String genre) {
        this.id = id;
        this.author_first = author_first;
        this.author_last = author_last;
        this.book_title = book_title;
        this.genre = genre;
        
    }

    
    public String getId() {
        return id;
    }

    public String getAuthor_first() {
        return author_first;
    }

    public String getAuthor_last() {
        return author_last;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" + "ID =" + id + ", Author Name =" + author_first + ", Author Last Name =" + author_last + ", Book Title =" + book_title + ", Genre =" + genre + '}';
        
    }
    
}
