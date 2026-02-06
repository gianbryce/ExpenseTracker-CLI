public class Expense {
    private String date;
    private String description;
    private String category;
    private double price;

    public Expense(String date, String description, String category, double price) {
        this.date = date;
        this.description = description;
        this.category = category;
        this.price = price;
    }
    @Override
    public String toString() {
        return date + "," + description + "," + category + "," + price;
    }
}
