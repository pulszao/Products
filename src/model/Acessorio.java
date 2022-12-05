package model;

/**
 Classe para cadastrar produtos do tipo acessório, com suas características específicas
 @author Lucas Pulsz
 */
public class Acessorio extends Produto{
    protected double margem = 1.45; // acessorios possuem margem padrao de 45%

    public Acessorio(double precoDeCusto, String codigo, String descricao) {
        this.precoDeCusto = precoDeCusto;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     Método que retorna o preço final específico da classe Acessorio
     @return preço final
     */
    @Override
    public double getPrecoFinal() {
        return this.precoDeCusto * margem;
    }
}
