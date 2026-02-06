import java.util.Scanner;

public class InputManager extends Menu {

    public InputManager() {
        Scanner sc = new Scanner(System.in);
        StorageManager storage = new StorageManager();
        storage.loadExpenses();
        enterChoice(sc);
    }

    public void enterChoice(Scanner sc) {
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                addExpense(sc);
                break;
            case "2":
                delExpense();
                break;
            case "3":
                upExpense();
                break;
            case "4":
                viewAllExpenses();
                break;
            case "5":
                viewSummary();
                break;
            case "6":
                break;
            default:
                System.out.println("Invalid option");
                enterChoice(sc);
        }
    }
    public String checkLegalFormat(Scanner sc, FormatRule format) {
        while(true) {
            String input = sc.nextLine();
            if (input.matches(format.getFormat())) {
                System.out.println("Legal format");
                return input;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    public void addExpense(Scanner sc) {
        FormatRule fDate = FormatRule.DATE;
        FormatRule fPrice = FormatRule.PRICE;

        System.out.println("Enter date (DD-MM-YYYY):");
        String date = checkLegalFormat(sc, fDate);

        System.out.println("Enter description:");
        String description = sc.nextLine();

        System.out.println("Enter category:");
        String category = sc.nextLine();

        System.out.println("Enter price (0.00):");
        double price = Double.parseDouble(checkLegalFormat(sc,fPrice));

        Expense e = new Expense(date, description, category, price);
    }

    public void delExpense() {}
    public void upExpense() {}
    public void viewAllExpenses() {}
    public void viewSummary() {}
}
