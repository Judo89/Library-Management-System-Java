import java.io.*;
import java.util.ArrayList;
public class FileManager {
    private static final String FILE_NAME =
            System.getProperty("user.dir") + "/books.txt";

    public static void saveBooks(ArrayList<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                writer.write(b.getId() + "," + b.getTitle() + "," + b.isAvailable());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    public static ArrayList<Book> loadBooks() {
        ArrayList<Book> books = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return books;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book(
                        Integer.parseInt(data[0]),
                        data[1]
                );
                if (!Boolean.parseBoolean(data[2])) {
                    book.borrow();
                }
                books.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error loading books.");
        }
        return books;
    }
    public static void log(String message) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("borrow_log.txt", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing log.");
        }
    }

}
