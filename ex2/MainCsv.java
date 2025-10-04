package ex2;

import java.util.Arrays;
import java.util.List;

public class MainCsv {
    public static void main(String[] args) {
        List<String> header = Arrays.asList("id", "nom", "score");
        List<String[]> rows = List.of(
            new String[]{"1", "Alice", "85"},
            new String[]{"2", "Bob", "92"},
            new String[]{"3", "Carol", "78"}
        );

        CsvWriter.writeCsv("report.csv", header, rows);
        System.out.println("Fichier report.csv généré avec succès !");
    }
}
