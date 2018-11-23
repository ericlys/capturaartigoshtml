package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class app {
    public static void main(String[] args) throws IOException {
        //cria uma variável do tipo String para armazenar a url da página desejada;
        String url = "https://www1.folha.uol.com.br/mundo/2018/11/moradores-da-california-abrem-suas-casas-para-receber-desabrigados-por-fogo-na-acao-de-gracas.shtml";
        //instância uma variável do tipo Document para salvar os dados da página html buscada;
        Document doc = null;

        try {
            // conecta usando a api Jsoup, e recupera a página da url buscada.
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("erro ao buscar a pagina!!");
        }

        // Pegar o titulo da página
        String title = doc.title();
        System.out.println("Título: " + title);
        System.out.println();

        // Pegar a descrição da página
        String description = doc.select("meta[name='description']").attr("content");
        System.out.println("Descrição: " + description);
        System.out.println();


        // Pegar texto do elemento com ID
        String text = doc.select("p").text();
        System.out.println(text);



        //gravar em arquivo txt
        File file = new File("C:\\Users\\Ericlys\\Desktop\\textopaginahtml.txt");
        if(!file.exists()) {
            file.createNewFile();
        }

        PrintWriter writer = new PrintWriter(file);

        writer.print(title + "\r\n" + "\r\n" + description + "\r\n" + "\r\n" + text);

        System.out.println("Escrita completa.");
        writer.close();

    }

}
