import java.io.IOException;

public class Sorts {
    public static void main(String[] args) throws IOException {
        SortsDAO csv = new SortsDAO();
        csv.readCSV("filesCSV\\IMDBTop250Movies.csv");
        csv.metrics();
    }
}
