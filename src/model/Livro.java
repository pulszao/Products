package model;

public class Livro extends Produto {
    protected double margem = 1.4; // livros possuem margem padrao de 40%

    public Livro(double precoDeCusto, String codigo, String descricao) {
        this.precoDeCusto = precoDeCusto;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public double getPrecoFinal() {
        return this.precoDeCusto * margem;
    }
}
