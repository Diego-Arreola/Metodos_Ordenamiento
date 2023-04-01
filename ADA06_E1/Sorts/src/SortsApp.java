import java.io.IOException;

public class SortsApp {
    /**
     * Método main del programa
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SortsDAO csv = new SortsDAO();
        csv.readCSV("Sorts\\filesCSV\\IMDBTop250Movies.csv");
        csv.metrics();
    }
}
