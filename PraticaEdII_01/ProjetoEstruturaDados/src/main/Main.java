package main;

import ordenacao.HeapIterativo;
import ordenacao.ListaEncadeada;
import ordenacao.Produtos;
import ordenacao.QuickSort;
import ordenacao.ShellSortMod;

public class Main {
    public static void main(String[] args) {

        // pra ler os produtos do arquivo gerado
        Produtos[] produtos = LeitorArquivo.carregarProdutos("produtos_1000.txt");

        // Escolher o algoritmo de ordenação via entrada do usuário
        System.out.println("\nEscolha o algoritmo de ordenacao:");
        System.out.println("1 - ShellSort");
        System.out.println("2 - QuickSort");
        System.out.println("3 - HeapSort");
        System.out.println("4 - Insertion Sort (Lista Encadeada)");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                ShellSortMod.ordenar(produtos);
                break;
            case 2:
                QuickSort.ordenar(produtos, 0, produtos.length - 1);
                break;
            case 3:
                HeapIterativo.ordenar(produtos);
                break;
            case 4:
                ListaEncadeada lista = new ListaEncadeada();
                for (Produtos p : produtos) {
                    lista.inserirOrdenado(p);
                }
                lista.exibir();
                scanner.close();
                return;
            default:
                System.out.println("Opção inválida.");

        }

        // exibir os produtos ordenados
        /*
         * StringBuilder resultado = new StringBuilder("Produtos ordenados:\n");
         * for (Produtos p : produtos) {
         * resultado.append(p).append("\n");
         * }
         * 
         * JOptionPane.showMessageDialog(null, resultado.toString(),
         * "Resultados da Ordenação",
         * 
         * JOptionPane.INFORMATION_MESSAGE);
         */

        System.out.println("\nProdutos após a ordenação:");
        for (Produtos p : produtos) {
            System.out.println(p.toString());  // Força uso do toString()
        }

        scanner.close();
    }
}
