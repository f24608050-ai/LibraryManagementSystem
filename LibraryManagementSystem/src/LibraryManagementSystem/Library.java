package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    void displayBook() {
        System.out.println("----------------------------");
        System.out.println("Book ID    : " + id);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Issued     : " + (issued ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    deleteBook();
                    break;

                case 7:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }

    // Add Book
    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Book Title: ");
        String title = input.nextLine();

        System.out.print("Enter Author Name: ");
        String author = input.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully!");
    }

    // Display Books
    static void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
            return;
        }

        for (Book b : books) {
            b.displayBook();
        }
    }

    // Search Book
    static void searchBook() {

        System.out.print("Enter Book ID to Search: ");
        int id = input.nextInt();

        boolean found = false;

        for (Book b : books) {

            if (b.id == id) {
                b.displayBook();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    // Issue Book
    static void issueBook() {

        System.out.print("Enter Book ID to Issue: ");
        int id = input.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (!b.issued) {
                    b.issued = true;
                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book Already Issued!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    // Return Book
    static void returnBook() {

        System.out.print("Enter Book ID to Return: ");
        int id = input.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (b.issued) {
                    b.issued = false;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book Was Not Issued!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    // Delete Book
    static void deleteBook() {

        System.out.print("Enter Book ID to Delete: ");
        int id = input.nextInt();

        for (Book b : books) {

            if (b.id == id) {
                books.remove(b);
                System.out.println("Book Deleted Successfully!");
                return;
            }
        }

        System.out.println("Book Not Found!");
    }
}
