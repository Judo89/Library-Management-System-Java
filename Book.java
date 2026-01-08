public class Book {
    private int id;
    private String title;
    private boolean available;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void giveBack() {
        available = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title +
                ", Available: " + (available ? "Yes" : "No");
    }
    public String getTitle() {
        return title;
    }

}
