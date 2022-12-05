//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package excecoes;

/**
 Classe de Exception que identifica quando a loja já atingiu o limite pré definido
 @author Lucas
 */
public class ExcecaoDeLojaCheia extends Exception {
    public ExcecaoDeLojaCheia() {}

    public String getMessage() {
        return "A inclusão não aconteceu porque a loja está cheia!";
    }
}
