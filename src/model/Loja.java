//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;
import excecoes.CodigoExistente;
import excecoes.ExcecaoDeLojaCheia;
import excecoes.ProdutoNaoEncontrado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


/**
 Classe para armazenar todos os produtos cadastrados
 @author Lucas Pulsz
 */
public class Loja implements Serializable {
    private int estoqueMax;
    private ArrayList<Produto> produtos;

    public Loja(int estoqueMax) {
        this.estoqueMax = estoqueMax;
        this.produtos = new ArrayList<Produto>();
    }

    /**
     Método que adiciona um novo produto à loja
     @param produtoAIncluir novo produto a ser incluido
     */
    public void adicionaProduto(Produto produtoAIncluir) throws ExcecaoDeLojaCheia {
        if (produtos.size() == estoqueMax) {
            throw new ExcecaoDeLojaCheia();
        } else {
            produtos.add(produtoAIncluir);
        }
    }

    /**
     Método para verificar se já existe um produto com o código informado no cadastro
     @param codigo codigo a ser verificado
     */
    public void verificaCodigo(String codigo) throws CodigoExistente {
        for (Produto prod : produtos) {
            if (prod.getCodigo().equals(codigo)) {
                throw new CodigoExistente();
            }
        }
    }

    public  ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    /**
     Método que retorna todos os produtos dentro de uma faixa de valor
     @param valorMin valor mínimo na pesquisa
     @param valorMax valor mínimo na pesquisa
     */
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

    /**
     Método que retorna um produto com o código informado
     @param codigo código do produto desejado
     */
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
