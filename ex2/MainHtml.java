package ex2;

public class MainHtml {
    public static void main(String[] args) {
        HtmlGenerator.writeHtml(
            "index.html",
            "Ma première page",
            "Bienvenue sur ma page générée par PrintWriter !"
        );
        System.out.println("Fichier index.html généré.");
    }
}
