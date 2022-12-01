package view;

import excecoes.ExcecaoDeLojaCheia;
import excecoes.ProdutoNaoEncontrado;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Loja loja = new Loja(30); // estoque máximo de 30 produtos
    private Scanner entrada = new Scanner(System.in);

    public void menu() {
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
                    break;

                case 2: // Consultar produtos cadastrados
                    break;

                case 3: // Consultar preço de um produto
                    break;

                case 4: //Consultar produtos em uma faixa de preco
                    break;
            }
            System.out.println("0.Sair");
            System.out.println("1.Cadastrar produto");
            System.out.println("2.Mostrar todos produtos");
            System.out.println("3.Consultar preço de um produto");
            System.out.println("4.Produtos em uma faixa de preço");
            opcao = entrada.nextInt();
        }


    }

}