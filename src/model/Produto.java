package model;

import java.io.Serializable;

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

    public double getPrecoFinal() {
        return precoDeCusto * margem;
    }
}
