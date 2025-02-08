import java.io.BufferedWriter;
import java.io.FileWriter;

public class CsvWriter {
    // This method adds a line to our expenses.csv file
    public static void write(String line) {
        try {
            // Create a BufferedWritter pointing to the expenses.csv file
            BufferedWriter bw = new BufferedWriter(new FileWriter("expenses.csv", true));

            // Write line provided in argument
            bw.write(line);
            bw.newLine();

            // Close BufferedWriter
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
