package com.melihcan;

import java.util.*;


public class Library {
    
    private List<Book> books;
    private List<Member> members;



    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();

    }

    public void addBook(Scanner scanner) {
        System.out.print("ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Başlık: ");
        String title = scanner.nextLine();
        System.out.print("Yazar: ");
        String author = scanner.nextLine();
        System.out.print("Yayın Yılı: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("kitabın türü : SCIENCE? , HISTORY? , NOVEL ");
        String type = scanner.nextLine().toUpperCase();
        System.out.println("Kitap ekleniyor...");
        switch (type){
            case "SCIENCE":
                Book bookScience = new BookScience(ISBN,title,author,publicationYear);
                books.add(bookScience);
                break;
            case "HISTORY":
                Book bookHistory = new BookHistory(ISBN,title,author,publicationYear);
                books.add(bookHistory);
                break;
            case "NOVEL":
                Book bookNovel = new Novel(ISBN,title,author,publicationYear);
                books.add(bookNovel);
                break;
        }
        System.out.println("Kitap başarıyla eklendi.");
    }

    public void addMember(Scanner scanner) {
        System.out.println("ADINIZI GİRİNİZ: ");
        String name = scanner.nextLine();
        System.out.println("ÜYE NUMARASI: ");
        String memberNo = scanner.nextLine();
        Member member = new Member(name,memberNo);
        members.add(member);
    }

    public void bookList() {
        System.out.println("KİTAP LİSTESİ: ");
      for (Book book : books){
          System.out.println(book.toString());
      }
    }

    public void borrowedBook(Scanner scanner) {
        Member member = null;
        Book book = null;
        System.out.println("ÖDÜNÇ ALINACAK KİTAP ISBN'SI: ");
        String title = scanner.nextLine();
        System.out.println("ÖDÜNÇ ALACAK ÜYE: ");
        String name = scanner.nextLine();

        for (Book b : books){
            if (b.getISBN().equals(title)){
                book = b;
                break;
            }
        }
        for (Member m : members){
            if (m.getName().equals(name)){
                member = m;
                break;
            }
        }
        if (book != null && member != null){
            books.remove(book);
            member.getBorrowedBooks().add(book);
            System.out.println(member.getName()+ " adlı kullanıcı " + book.getTitle() + " kitabı ödünç aldı.");
        }
        if (member == null){
            System.out.println("LÜTFEN ÜYE OLUNUZ.");
        }
        if (book == null){
            System.out.println("ARADIĞINIZ KİTAP MEVCUT DEĞİL.");
        }
    }

    public void returnBook(Scanner scanner) {
        Member member = null;
        Book book = null;
        System.out.println("İADE EDİLECEK KİTAP ISBN'SI: ");
        String title = scanner.nextLine();
        System.out.println("İADE EDECEK ÜYE ADI: ");
        String name = scanner.nextLine();
        for (Book b : books){
            if (b.getISBN().equals(title)){
                book = b;
                break;
            }
        }
        for (Member m : members){
            if (m.getName().equals(name)){
                member = m;
                break;
            }
        }
        if (book != null && member !=null){

            member.getBorrowedBooks().remove(book);
            books.add(book);

            System.out.println(member.getName() + " isimli üye " + book.getTitle() + " adlı kitabı iade etti.");
        }
        if (member == null){
            System.out.println("LÜTFEN ÜYE OLUNUZ.");
        }
        if (book == null){
            System.out.println("İADE EDİLMEK İSTENEN KİTAP SİSTEMDE KAYITLI DEĞİLDİR.");
        }
        if (member.getBorrowedBooks().size()==0){
            System.out.println("üzerinize kayıtlı kitap yoktur");
        }
    }

    public void showLibrary() {
        for (Book book : books){
            System.out.println(book);
        }
        for (Member member : members){
            System.out.println(member);
        }
    }
    public void memberList() {
        for (Member member : members){
            System.out.println(member);
        }
    }
}
