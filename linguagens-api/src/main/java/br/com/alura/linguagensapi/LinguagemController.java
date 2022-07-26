package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    //https://github.com/abrahamcalf/programming-languages-logos
    private List<Linguagem> linguagens = List.of(
        new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
        new Linguagem("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2)

    );

    @GetMapping(value = "/linguagem-preferida")
    public String processaLinguagem(){
        return "Oi, Java";
    }

    @GetMapping(value = "/linguagens")
    public List<Linguagem> obterLinguagens(){
        return linguagens;
    }
}
