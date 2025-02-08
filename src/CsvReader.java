import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CsvReader {
    // This method reads the contents of our expenses.csv file
    public static ArrayList<String> read() {
        String line = "";
        ArrayList<String> values = new ArrayList<String>();

        try {
            // Create a BufferedReader pointing to the expenses.csv file
            BufferedReader br = new BufferedReader(new FileReader("expenses.csv"));

            // This while loop checks that the next line is not empty, and then adds it to
            // the vaules array
            while ((line = br.readLine()) != null) {
                values.add(line);
            }

            // Close BufferedReader
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }
}
