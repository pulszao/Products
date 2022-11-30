//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Loja implements Serializable {
    private int estoqueMax;
    private ArrayList<Produto> produtos;

    public Loja(int estoqueMax) {
        this.estoqueMax = estoqueMax;
        this.produtos = new ArrayList<Produto>();
    }

    public void incluirProduto(Produto produtoAIncluir){}

    public int getTamanho() {
        return this.produtos.size();
    }

    public int getEstoqueMax() {
        return this.estoqueMax;
    }
}
