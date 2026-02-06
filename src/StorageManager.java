import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StorageManager {
    private static final String FILE_NAME = "expenses.csv";
    private ArrayList<Expense> expenses = new ArrayList<>();

    public StorageManager() {
        loadExpenses();
    }

    public void loadExpenses() {
        Path path = Paths.get(FILE_NAME);
        /* Creates a new file if 'FILE_NAME' cannot be found */
        if (!Files.exists(path)) { initFileCreation(); }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line; // Holds the String value of the entire line
            int lineCount = 0;

            /*
             * Reads a line until it encounters a line terminator or 'null' (end of file),
             * after which it returns the entire line as a String.
             */
            while ((line = reader.readLine()) != null) {
                // First line contains header names, therefore, don't count line 0
                if (lineCount > 0) {
                    // Splits line into multiple String types, separated by ','
                    String[] params = line.split(",");

                    // Utilise elements in 'params' to instantiate an 'Expense' object
                    expenses.add(new Expense(
                            params[0], // date
                            params[1], // name
                            params[2], // description
                            Double.parseDouble(params[3]))); // amount
                }
            }
        } catch (IOException e) {
            System.out.println("-- Error loading expenses --\n" + e.getMessage());
        }
    }

    public void initFileCreation() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.write("Date,Description,Category,Amount");
        } catch (IOException e) {
            System.out.println("-- Error writing file --\n" + e.getMessage());
        }
    }

    public void saveExpenses() {

    }
}
