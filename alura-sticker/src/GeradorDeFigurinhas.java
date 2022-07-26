import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
// import java.net.URL;
import java.awt.Graphics2D;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    private BufferedImage novaImagem;

    /**
     * @param nomeArquivo 
     * @throws IOException
     */
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException{

        // leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg")
        //                                 .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = (int) (altura + altura*0.2);

        novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configuar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        graphics.setFont(fonte);

        // escrever uma frase na imagem
        graphics.drawString("TOPZERA", (int) (largura*0.25), (int) (altura + altura*0.1));

        // escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

        
    }
    
}
