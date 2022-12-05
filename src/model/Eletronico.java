package model;

/**
 Classe para cadastrar produtos do tipo eletrônicos, com suas características específicas
 @author Lucas Pulsz
 */
public class Eletronico extends Produto {
    protected double margem = 1.5; // eletronicos possuem margem padrao de 50%

    public Eletronico(double precoDeCusto, String codigo, String descricao) {
        this.precoDeCusto = precoDeCusto;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     Método que retorna o preço final específico da classe Eletronico
     @return preço final
     */
    @Override
    public double getPrecoFinal() {
        return this.precoDeCusto * margem;
    }
}
