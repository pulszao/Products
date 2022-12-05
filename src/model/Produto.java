package model;

import java.io.Serializable;

/**
 Classe abstrata utilizada para representar os produtos e seus atributos obrigatórios
 @author Lucas Pulsz
 */
public abstract class Produto implements Serializable {
    protected double margem = 1.3; // margem padrao eh de 30%
    protected double precoDeCusto;
    protected String codigo;
    protected String descricao;

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoDeCusto() {
        return precoDeCusto;
    }

    /**
     Função para retornar preço final do produto
     @return preço de custo x margem de lucro
     */
    public double getPrecoFinal() {
        return precoDeCusto * margem;
    }
}
