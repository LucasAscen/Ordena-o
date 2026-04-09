package main;

import ordenacao.Produtos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

    public static Produtos[] carregarProdutos(String nomeArquivo) {
        List<Produtos> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.trim().split(" # ");

                if (partes.length == 5) {
                    String nome = partes[0];
                    String fabricante = partes[1];
                    double preco = Double.parseDouble(partes[2].replace(",", ".")); // de , para .
                    String validade = partes[3];
                    String tipo = partes[4];

                    produtos.add(new Produtos(nome, fabricante, preco, validade, tipo));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return produtos.toArray(new Produtos[0]);
    }
}
