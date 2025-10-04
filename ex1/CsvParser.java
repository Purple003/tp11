package ex1;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CsvParser {
    public static List<Record> readCsv(String path) throws IOException {
        List<Record> records = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            br.readLine(); // sauter l'en-tête si présente
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double score = Double.parseDouble(parts[2].trim());
                    records.add(new Record(id, name, score));
                }
            }
        }
        return records;
    }

    public static void writeCsv(List<Record> records, String path) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            bw.write("id,name,score");
            bw.newLine();
            for (Record r : records) {
                bw.write(r.getId() + "," + r.getName() + "," + r.getScore());
                bw.newLine();
            }
        }
    }
}
