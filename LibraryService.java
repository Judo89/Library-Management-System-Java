import java.util.ArrayList;
public class LibraryService {

    private ArrayList<Book> books;

    public LibraryService() {
        books = FileManager.loadBooks();
    }

    private boolean isIdExists(int id) {
        return books.stream().anyMatch(b -> b.getId() == id);
    }

    public void addBook(Book book) {
        if (isIdExists(book.getId())) {
            System.out.println("Error: Book ID already exists!");
            return;
        }
        books.add(book);
        FileManager.saveBooks(books);
        System.out.println("Book added successfully.");
    }

    public Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public void borrowBook(int id) {
        Book book = findBook(id);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isAvailable()) {
            System.out.println("Book already borrowed.");
        } else {
            book.borrow();
            FileManager.saveBooks(books);
            System.out.println("Book borrowed.");
        }
    }

    public void returnBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("This book was not borrowed.");
            return;
        }

        book.giveBack();
        FileManager.saveBooks(books);
        logAction("Book " + id + " returned");
        System.out.println("Book returned successfully.");
    }



    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        books.forEach(System.out::println);
    }

    // 3️⃣ Advanced Search
    public void searchByTitle(String keyword) {
        books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(System.out::println);
    }
    private void logAction(String action) {
        FileManager.log(action + " at " + java.time.LocalDateTime.now());
    }

}

