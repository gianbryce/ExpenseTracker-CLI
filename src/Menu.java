public class Menu {

    final private String OPTIONS =
        "1) Add expense\n" +
        "2) Delete expense\n" +
        "3) Update expense\n" +
        "4) View all expenses\n" +
        "5) View summary of expenses\n" +
        "6) Save and exit";

    public Menu() { printMenu(); }

    public void printMenu() {
        System.out.println(OPTIONS);
    }
 }