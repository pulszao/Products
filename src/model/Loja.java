//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;
import excecoes.ExcecaoDeLojaCheia;
import excecoes.ProdutoNaoEncontrado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Loja implements Serializable {
    private int estoqueMax;
    private ArrayList<Produto> produtos;

    public Loja(int estoqueMax) {
        this.estoqueMax = estoqueMax;
        this.produtos = new ArrayList<Produto>();
    }

    public void adicionaProduto(Produto produtoAIncluir) throws ExcecaoDeLojaCheia {
        if (produtos.size() == estoqueMax) {
            throw new ExcecaoDeLojaCheia();
        } else {
            produtos.add(produtoAIncluir);
        }
    }

    public  ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    public  ArrayList<Produto> getProdutos(double valorMin, double valorMax) throws ProdutoNaoEncontrado {
        ArrayList<Produto> auxProdutos = new ArrayList<Produto>();

        for (Produto prod : produtos) {
            if (prod.getPrecoFinal() > valorMin && prod.getPrecoFinal() < valorMax) {
                auxProdutos.add(prod);
            }
        }

        if (auxProdutos.size() != 0) {
            return auxProdutos;
        } else {
            throw new ProdutoNaoEncontrado();
        }
    }

    public  Produto getProduto(String codigo) throws ProdutoNaoEncontrado {
        for (Produto prod : produtos) {
            if (Objects.equals(prod.getCodigo(), codigo)) {
                return prod;
            }
        }
        throw new ProdutoNaoEncontrado();
    }

    public int getTamanho() {
        return this.produtos.size();
    }

    public int getEstoqueMax() {
        return this.estoqueMax;
    }
}
