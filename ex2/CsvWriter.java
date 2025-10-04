package ex2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Générateur de fichiers CSV.
 */
public class CsvWriter {

    /**
     * Écrit un fichier CSV à partir d’un en-tête et d’une liste de lignes.
     */
    public static void writeCsv(String path, List<String> header, List<String[]> rows) {
        try (PrintWriter pw = new PrintWriter(path)) {
            pw.println(String.join(",", header)); // écrire l’en-tête
            for (String[] row : rows) {
                pw.println(String.join(",", row));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d’écrire le CSV : " + e.getMessage());
        }
    }
}
