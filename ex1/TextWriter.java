package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {
    public static void copyWithSummary(String src, String dest) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(src));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                count++;
            }
            bw.write("Nombre total de lignes copiées : " + count);
        }
    }
}
