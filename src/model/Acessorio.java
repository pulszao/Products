package model;

public class Acessorio extends Produto{
    protected double margem = 1.45; // acessorios possuem margem padrao de 45%

    public Acessorio(double precoDeCusto, String codigo, String descricao) {
        this.precoDeCusto = precoDeCusto;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public double getPrecoFinal() {
        return this.precoDeCusto * margem;
    }
}
