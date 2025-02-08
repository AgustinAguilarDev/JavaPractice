import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Scanner instance
        Scanner scanner = new Scanner(System.in);

        // Create file if it doesn't exists
        File file = new File("expenses.csv");
        if (!file.exists())
            CsvWriter.write("category,amount");

        // Obtain values from csv
        ArrayList<String> values = CsvReader.read();

        // Interact with the user
        String userInput = null;

        while (userInput == null || !userInput.equals("C")) {
            System.out.println("");
            System.out.println("Welcome! What do you want to do?");
            System.out.println("E = See expenses || A = Add new expenses || T = See total || C = Exit");
            userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "E":
                    for (String expense : values) {
                        System.out.println(expense);
                    }
                    ;
                    break;
                case "A":
                    System.out.println("Please, enter a category");
                    String category = scanner.nextLine();
                    System.out.println("Please, enter the amount");
                    String amount = scanner.nextLine();

                    // Validate the amount input
                    while (!Helper.isDouble(amount)) {
                        System.out.println("Please, use an appropriate format");
                        amount = scanner.nextLine();
                    }

                    // Add expense to CSV
                    CsvWriter.write(category + "," + amount);
                    // Update variable
                    values = CsvReader.read();
                    break;
                case "T":
                    System.out.println(Helper.calculateTotal(values));
                    break;
                case "C":
                    System.out.println("Program ended");
                    break;
                default:
                    System.out.println("That's not an option!");
                    break;
            }
        }

        scanner.close();
    }
}
