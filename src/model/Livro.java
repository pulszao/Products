package model;

/**
 Classe para cadastrar produtos do tipo livro, com suas características específicas
 @author Lucas Pulsz
 */
public class Livro extends Produto {
    protected double margem = 1.4; // livros possuem margem padrao de 40%

    public Livro(double precoDeCusto, String codigo, String descricao) {
        this.precoDeCusto = precoDeCusto;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     Método que retorna o preço final específico da classe Livro
     @return preço final
     */
    @Override
    public double getPrecoFinal() {
        return this.precoDeCusto * margem;
    }
}
