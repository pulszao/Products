//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package excecoes;

/**
 Classe de Exception que identifica quando o código do produto já está associado a um produto
 @author Lucas
 */
public class CodigoExistente extends Exception {
    public CodigoExistente() {}

    public String getMessage() {
        return "Já existe um produto com este codigo";
    }
}

