//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    LibraryService service = new LibraryService();

    while (true) {
        System.out.println("1.Add Book");
        System.out.println("2.Borrow Book");
        System.out.println("3.Return Book");
        System.out.println("4.Display");
        System.out.println("5.search");
        System.out.println("6.Exit");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Title: ");
                String title = sc.nextLine();
                service.addBook(new Book(id, title));
                break;

            case 2:
                System.out.print("Book ID: ");
                service.borrowBook(sc.nextInt());
                break;

            case 3:
                System.out.print("Book ID: ");
                service.returnBook(sc.nextInt());
                break;

            case 4:
                service.displayBooks();
                break;

            case 5:
                sc.nextLine();
                System.out.print("Enter book title keyword: ");
                service.searchByTitle(sc.nextLine());
                break;
            case 6:
                return;
        }
    }
}
