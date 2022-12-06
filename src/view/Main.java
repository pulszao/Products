package view;

import excecoes.CodigoExistente;
import excecoes.ExcecaoDeLojaCheia;
import excecoes.ProdutoNaoEncontrado;
import model.*;
import persistencia.PersistenciaComSerializacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Loja loja = new Loja(30); // estoque máximo de 30 produtos
    private Scanner entrada = new Scanner(System.in);
    private PersistenciaComSerializacao persiste;

    public Main(PersistenciaComSerializacao persiste) {
        this.entrada = new Scanner(System.in);
        this.persiste = persiste;
    }

    public void menu() {
        this.loja = this.persiste.recuperarLoja();

        // variáveis locais
        int opcao, tipoNovoProduto;
        double precoNovoProduto, valorMin, valorMax;
        String descricaoNovoProduto, codigoNovoProduto, codigo, descricao;
        Produto novoProduto = null;
        ArrayList<Produto> produtos = null;

        System.out.println("0.Sair");
        System.out.println("1.Cadastrar produto");
        System.out.println("2.Mostrar todos produtos");
        System.out.println("3.Consultar preço de um produto");
        System.out.println("4.Produtos em uma faixa de preço");
        opcao = entrada.nextInt();
        while(opcao!=0) {
            switch(opcao)
            {
                case 1: // Inserir produto na tabela
                    entrada.nextLine();
                    System.out.println("Insira a descrição do produto");
                    descricaoNovoProduto = entrada.nextLine();
                    System.out.println("Insira o codigo do produto");
                    codigoNovoProduto = entrada.nextLine();
                    System.out.println("Insira o preco de custo");
                    precoNovoProduto = entrada.nextDouble();
                    System.out.println("Insira o tipo do produto:\n(0) - Acessorio\n(1) - Eletrônico\n(2) - Livro");
                    tipoNovoProduto = entrada.nextInt();

                    if (tipoNovoProduto == 0) {
                        // add Acessorio
                        novoProduto = new Acessorio(precoNovoProduto, codigoNovoProduto, descricaoNovoProduto);
                    } else if (tipoNovoProduto == 1) {
                        // add Eletronico
                        novoProduto = new Eletronico(precoNovoProduto, codigoNovoProduto, descricaoNovoProduto);
                    } else if (tipoNovoProduto == 2) {
                        // add Livro
                        novoProduto = new Livro(precoNovoProduto, codigoNovoProduto, descricaoNovoProduto);
                    }

                    try {
                        loja.verificaCodigo(codigoNovoProduto);
                        loja.adicionaProduto(novoProduto);
                    } catch (ExcecaoDeLojaCheia e) {
                        System.out.println(e.getMessage());
                    } catch (CodigoExistente e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2: // Consultar produtos cadastrados
                    System.out.println("Produtos cadastrados:");
                    produtos = loja.getProdutos();

                    for (Produto prod : produtos) {
                        codigo = prod.getCodigo();
                        descricao = prod.getDescricao();
                        System.out.printf("%s - %s\n", codigo, descricao);
                    }

                    break;

                case 3: // Consultar preço de um produto
                    entrada.nextLine();
                    System.out.println("Informe o codigo do produto:");
                    codigo = entrada.nextLine();

                    try {
                        novoProduto = loja.getProduto(codigo);
                        System.out.println("Informações do produto:\n");
                        System.out.println(novoProduto.getDescricao());
                        System.out.printf("Preco de venda: %s\n",novoProduto.getPrecoFinal());
                        System.out.printf("Preco de custo: %s\n",novoProduto.getPrecoDeCusto());
                    } catch (ProdutoNaoEncontrado e) {
                        // e.getMessage();
                        System.out.println("Não existe produto com este código!");
                    }

                    break;

                case 4: //Consultar produtos em uma faixa de preco
                    System.out.println("Informe o valor minimo:\n");
                    valorMin = entrada.nextDouble();
                    System.out.println("Informe o valor maximo:\n");
                    valorMax = entrada.nextDouble();

                    try {
                        produtos = loja.getProdutos(valorMin, valorMax);
                        for (Produto prod : produtos) {
                            codigo = prod.getCodigo();
                            descricao = prod.getDescricao();
                            precoNovoProduto = prod.getPrecoFinal();
                            System.out.printf("%s - %s - %s(preço final)\n", codigo, descricao, precoNovoProduto);
                        }
                    } catch (ProdutoNaoEncontrado e) {
                        e.getMessage();
                    }

                    break;
            }
            System.out.println("\n");
            System.out.println("0.Sair");
            System.out.println("1.Cadastrar produto");
            System.out.println("2.Mostrar todos produtos");
            System.out.println("3.Consultar preço de um produto");
            System.out.println("4.Produtos em uma faixa de preço");
            opcao = entrada.nextInt();
        }
        this.persiste.salvarLoja(this.loja);
    }
}
