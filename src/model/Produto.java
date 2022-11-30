package model;

/**
    Classe abstrata utilizada para representar os produtos e seus atributos obrigatórios
*/
abstract class Produto {
    protected double precoDeCusto;
    protected double margem;
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
