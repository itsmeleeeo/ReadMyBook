package com.example.readmybook;

public class CourseModal {

    // variables for our book,
    // BookTitle, author, isbn, publisher,publication year, genre
    private String booktitle;
    private String author;
    private String isbn;


    // creating getter and setter methods
    public String getbooktitle() {
        return booktitle;
    }

    public void setbooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }


    // constructor
    public CourseModal(String booktitle, String author, String isbn) {
        this.booktitle = booktitle;
        this.author = author;
        this.isbn = isbn;

    }
}
