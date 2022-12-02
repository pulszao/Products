package model;

public class Eletronico extends Produto {
    protected double margem = 1.5; // eletronicos possuem margem padrao de 50%

    public Eletronico(double precoDeCusto, String codigo, String descricao) {
        this.precoDeCusto = precoDeCusto;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public double getPrecoFinal() {
        return this.precoDeCusto * margem;
    }
}
