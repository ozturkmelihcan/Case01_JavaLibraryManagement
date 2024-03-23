package com.melihcan;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        displayMenu();

    }

    public static void displayMenu(){
        Library library = new Library();
        Member member=null;

        while (true) {
            System.out.println("Kütüphane Otomasyon Sistemi");
            System.out.println("1. KİTAP EKLE");
            System.out.println("2. ÜYE EKLE");
            System.out.println("3. KİTAPLARI LİSTELE");
            System.out.println("4. ÜYELERİ LİSTELE");
            System.out.println("5. KİTAP ÖDÜNÇ AL");
            System.out.println("6. KİTAP İADE ET");
            System.out.println("7. KÜTÜPHANE DURUMUNU GÖSTER");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminizi yapınız: ");

            int key = scanner.nextInt();
            scanner.nextLine();

            switch (key) {
                case 1:
                    library.addBook(scanner);
                    break;
                case 2:
                    library.addMember(scanner);
                    break;
                case 3:
                    library.bookList();
                    break;
                case 4:
                    library.memberList();
                    break;
                case 5:
                    library.borrowedBook(scanner);
                    break;
                case 6:
                    library.returnBook(scanner);
                    break;
                case 7:
                    library.showLibrary();
                    break;
                case 0:
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }

    }


}