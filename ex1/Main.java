package ex1;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== Lecture input.txt ===");
            TextReader.readLines("input.txt");

            System.out.println("\n=== Copie avec résumé ===");
            TextWriter.copyWithSummary("input.txt", "output.txt");

            System.out.println("\n=== Lecture CSV et filtrage ===");
            List<Record> all = CsvParser.readCsv("data.csv");
            List<Record> passed = all.stream()
                                     .filter(r -> r.getScore() >= 50)
                                     .collect(Collectors.toList());
            CsvParser.writeCsv(passed, "passed.csv");

            System.out.println("\n=== Sérialisation ===");
            ObjectSerializer.serialize(all, "records.ser");

            System.out.println("\n=== Désérialisation ===");
            List<Record> loaded = ObjectSerializer.deserialize("records.ser");
            loaded.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
