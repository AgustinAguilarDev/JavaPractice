import java.util.ArrayList;

public class Helper {
    // This method checks if a string can be parsed as Double
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // This method gets the sum of the amounts part in the array of expenses
    public static double calculateTotal(ArrayList<String> values) {
        double total = 0;
        try {
            // Iterate list, get amonuts, parse them to double, add them to the total
            for (String string : values) {
                String[] separatedValues = string.split(",");
                String amount = separatedValues[1];
                // Check if amount is parsable
                if (isDouble(amount))
                    total += Double.parseDouble(amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
