package com.melihcan;

import java.util.ArrayList;
import java.util.List;


public class Member implements IMember {


    private String name;
    private String memberNo;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public Member(String name,String memberNo){
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.memberNo = memberNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public void borrowBook(Book book) {
        if (book.getStatus() == EStatus.AVAILABLE) {
            book.setStatus(EStatus.BORROWED);
            borrowedBooks.add(book);
            System.out.println(book.getTitle() + " successfully borrowed by " + name);
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.setStatus(EStatus.AVAILABLE);
            borrowedBooks.remove(book);
            System.out.println(book.getTitle() + " successfully returned by " + name);
        } else {
            System.out.println("You haven't borrowed this book.");
        }
    }

    @Override
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You haven't borrowed any books.");
        } else {
            System.out.println("Books borrowed by " + name + ":");
            for (Book book : borrowedBooks) {
                System.out.println(book.getTitle());
            }
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
