package com.company;
import java.util.*;
class Library {

    private final List<String> availableBooks = new ArrayList<>(Arrays.asList(
            "How To Be Happy", "The Colour Of Earth", "The Early Earth", "Eight Walls",
            "Mouse Guard", "Wanda Vision", "Empyre", "Thor: The Devourer King",
            "Guardians Reloaded", "Immortal Hulk", "Avengers: The Final Host",
            "Black Panther", "Spider-Man: Back to Basics", "Miles Morales: Spider-Man ",
            "Who Is Iron Man?", "Doctor Strange", "Venom", "Star Wars", "Thanos",
            "X-Men: Days of Future Past", "Captain Marvel: Higher, Further, Faster, More",
            "Deadpool: Secret Invasion", "Infinity Gauntlet", "Civil War", "House of M",
            "Daredevil: Born Again", "Wolverine", "Thor"
    ));

    private final Map<String, String> issuedTo = new LinkedHashMap<>();
    
    // Add Book To Library
    public void addBook(Scanner sc) {
        System.out.println("Please type the Book name you want to add :");
        String addBookto = sc.nextLine().trim();
        while (addBookto.isEmpty()) addBookto = sc.nextLine().trim();
        System.out.println("Please Enter your name: ");
        String addname = sc.nextLine().trim();
        if (!addBookto.isEmpty()) {
            if (availableBooks.contains(addBookto) || issuedTo.containsKey(addBookto)) {
                System.out.println("That book already exists in the catalog.");
            } else {
                availableBooks.add(addBookto);
                System.out.println("Book Added 👍  (" + addBookto + ") by " + addname);
            }
        }
    }

    public void issueBook(Scanner sc) {
        System.out.println("Please Enter the book name to be issued :");
        String issuebook = sc.nextLine().trim();
        while (issuebook.isEmpty()) issuebook = sc.nextLine().trim();
        System.out.println("Please enter the person's name to issue it to:");
        String issuername = sc.nextLine().trim();
        if (issuedTo.containsKey(issuebook)) {
            System.out.println("Sorry, this book is already issued to " + issuedTo.get(issuebook));
        } else if (availableBooks.remove(issuebook)) {
            issuedTo.put(issuebook, issuername);
            System.out.println("Book Issued 👍  (" + issuebook + ") to " + issuername);
        } else {
            System.out.println("Book not found in available catalog.");
        }
    }

    public void returnBook(Scanner sc) {
        System.out.println("Enter the book name you want to return :");
        String retbook = sc.nextLine().trim();
        while (retbook.isEmpty()) retbook = sc.nextLine().trim();
        System.out.println("Please Enter your name: ");
        String retname = sc.nextLine().trim();
        if (issuedTo.containsKey(retbook)) {
            issuedTo.remove(retbook);
            availableBooks.add(retbook);
            System.out.println("Book Returned 👍  (" + retbook + ") by " + retname);
        } else {
            System.out.println("This book is not recorded as issued.");
        }
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        if (availableBooks.isEmpty()) {
            System.out.println("(none)");
        } else {
            for (String element : availableBooks) {
                System.out.println(element);
            }
        }
        System.out.println(" ");
        System.out.println("Issued Books:");
        if (issuedTo.isEmpty()) {
            System.out.println("(none)");
        } else {
            for (Map.Entry<String, String> entry : issuedTo.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
public class tuts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        System.out.println("Welcome to this Library !!");
        boolean running = true;
        while (running) {
            System.out.println("Please Enter 1 to Display the Available Books \n" +
                    "Please press 2 to Issue A Book \n" +
                    "Press 3 to Add A book \n" +
                    "Press 4 to return a Issued Book\n" +
                    "Press 5 to Exit");
            String line = sc.nextLine().trim();
            int input;
            try {
                input = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please Enter A valid input !!");
                continue;
            }
            if (input == 1) {
                lib.showAvailableBooks();
            }

            else if (input == 2) {
                lib.issueBook(sc);
            }

            else if (input == 3) {
                lib.addBook(sc);
            }

            else if (input == 4) {
                lib.returnBook(sc);
            }

            else if (input == 5) {
                running = false;
                System.out.println("Goodbye!");
            }

            else {
                System.out.println("Please Enter A valid input !!");
            }
        }
    }
}

