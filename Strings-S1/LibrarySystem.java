class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // static variables
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 0;

    // constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookId = generateBookId();
        this.isAvailable = true; // new book is always available
        totalBooks++;
        availableBooks++;
    }

    // static method to generate unique book IDs
    private static String generateBookId() {
        bookCounter++;
        return String.format("B%03d", bookCounter); // B001, B002...
    }

    // issue book
    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        } else {
            return false;
        }
    }

    // return book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    // display book details
    public void displayBookInfo() {
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Available? : " + (isAvailable ? "Yes" : "No"));
        System.out.println("----------------------------------");
    }

    // getters
    public String getBookId() {
        return bookId;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    // static getters
    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}


class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued; // store book IDs
    private int bookCount;

    private static int memberCounter = 0;

    // constructor
    public Member(String memberName, int maxBooksAllowed) {
        this.memberName = memberName;
        this.memberId = generateMemberId();
        this.booksIssued = new String[maxBooksAllowed];
        this.bookCount = 0;
    }

    // static method to generate member IDs
    private static String generateMemberId() {
        memberCounter++;
        return String.format("M%03d", memberCounter); // M001, M002...
    }

    // borrow book
    public void borrowBook(Book book) {
        if (bookCount == booksIssued.length) {
            System.out.println(memberName + " cannot borrow more books (limit reached).");
            return;
        }
        if (book.issueBook()) {
            booksIssued[bookCount] = book.getBookId();
            bookCount++;
            System.out.println(memberName + " successfully borrowed " + book.getBookId());
        } else {
            System.out.println("Book " + book.getBookId() + " is not available!");
        }
    }

    // return book
    public void returnBook(String bookId, Book[] books) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                // shift remaining books left
                for (int j = i; j < bookCount - 1; j++) {
                    booksIssued[j] = booksIssued[j + 1];
                }
                booksIssued[bookCount - 1] = null;
                bookCount--;

                // update book object
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        break;
                    }
                }

                System.out.println(memberName + " returned book " + bookId);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(memberName + " does not have book " + bookId);
        }
    }

    // display member details
    public void displayMemberInfo() {
        System.out.println("Member ID   : " + memberId);
        System.out.println("Name        : " + memberName);
        System.out.print("Books Issued: ");
        if (bookCount == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < bookCount; i++) {
                System.out.print(booksIssued[i] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
    }
}


public class LibrarySystem {
    public static void main(String[] args) {
        // create some books
        Book[] books = new Book[3];
        books[0] = new Book("Java Programming", "James Gosling");
        books[1] = new Book("Data Structures", "Donald Knuth");
        books[2] = new Book("Operating Systems", "Silberschatz");

        // create members
        Member[] members = new Member[2];
        members[0] = new Member("Alice", 2);
        members[1] = new Member("Bob", 1);

        // show initial book info
        System.out.println("=== Available Books ===");
        for (Book b : books) {
            b.displayBookInfo();
        }

        // transactions
        members[0].borrowBook(books[0]); // Alice borrows Java
        members[1].borrowBook(books[0]); // Bob tries same book (should fail)
        members[1].borrowBook(books[1]); // Bob borrows DS
        members[0].borrowBook(books[2]); // Alice borrows OS

        // display members
        System.out.println("=== Member Info ===");
        for (Member m : members) {
            m.displayMemberInfo();
        }

        // return a book
        members[0].returnBook("B001", books); // Alice returns Java

        // display final state
        System.out.println("=== Final Book Info ===");
        for (Book b : books) {
            b.displayBookInfo();
        }

        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}

