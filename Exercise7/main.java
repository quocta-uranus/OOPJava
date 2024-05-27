package Exercise7;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so quyen sach : ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("Nhap thong tin cua quyen sach " + (i + 1) + ":");

            System.out.print("Tieu de: ");
            String title = scanner.nextLine();

            System.out.print("Tac gia: ");
            String author = scanner.nextLine();

            System.out.print("Nha xuat ban: ");
            String publisher = scanner.nextLine();

            System.out.print("Nam: ");
            int year = scanner.nextInt();
            scanner.nextLine();  

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Vui long nhap so chuong : ");
            int numberOfChapters = scanner.nextInt();
            scanner.nextLine(); 

            String[] chapters = new String[numberOfChapters];
            for (int j = 0; j < numberOfChapters; j++) {
                System.out.print("Chuong: " + (j + 1) + " Tieu de ");
                chapters[j] = scanner.nextLine();
            }

            Book book = new Book(title, author, publisher, year, isbn, Arrays.asList(chapters));
            bookManager.addBook(book);
        }

     
        System.out.println("Danh sach sach sau khi nhap :");
        bookManager.displayBooks();

        bookManager.sortBooksByTitle();
        System.out.println("\nDanh sach sach sap xep theo tieu de :");
        bookManager.displayBooks();

        bookManager.sortBooksByAuthor();
        System.out.println("\nDanh sach sach sap xep theo tac gia :");
        bookManager.displayBooks();

        bookManager.sortBooksByPublisher();
        System.out.println("\nDanh sach sach sap xep theo nha xuat ban :");
        bookManager.displayBooks();

        bookManager.sortBooksByYear();
        System.out.println("\nDanh sach sach sap xep theo nam xuat ban :");
        bookManager.displayBooks();
    }
}
