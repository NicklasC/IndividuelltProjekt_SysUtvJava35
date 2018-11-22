package com.company;

import java.sql.Connection;

public class Book extends Item {
    private String author;
    private String bookName;

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String bookName, String author){

        super(ItemClass.BOOK);
        this.bookName = bookName;
        this.author=author;
    }
    public static boolean createBook(String bookName,String bookAuthorName, String bookAuthorSurname){
        String myString = "INSERT INTO book(bookName,authorName,authorSurname,itemTypeID) Values ('" + bookName + "','" + bookAuthorName + "','" + bookAuthorSurname + "',1);";
        if (MySqlCon.myExecuteQuery(myString)) {
            return true;
        } else{
            return false;
        }
    }
}