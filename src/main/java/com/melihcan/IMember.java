package com.melihcan;

import com.melihcan.Book;

public interface IMember {

    void borrowBook(Book book);
    void returnBook(Book book);
    void displayBorrowedBooks();

}
