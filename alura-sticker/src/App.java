import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //request api filmes
        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // String url = "https://api.nasa.gov/planetary/apod?api_key=7fsEZheS0NWdWpRt6hCWtbzN9tEGxJHT2CZ5vN21&start_date=2022-07-20&end_date=2022-07-24";
        String url = "http://localhost:8080/linguagens";
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        

        //extrair os dados do json
        ExtratorDeConteudo extratorNasa = new ExtratorDeConteudoDoIMDB();
        List<Conteudo> conteudos = extratorNasa.extraiConteudos(json);


        //exibir e manipular
        var geradora = new GeradorDeFigurinhas();
        int counter = 0;
        for (Conteudo conteudo : conteudos) {

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "output/" + conteudo.getTitulo() + ".png";
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            counter++;
            if (counter > 5) break;
        }
    }
}
