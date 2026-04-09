package ordenacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Produtos {
    private String nome;

    public String getNome() {
        return nome;
    }

    private String fabricante;

    public String getFabricante() {
        return fabricante;
    }

    private Double preco;

    public Double getPreco() {
        return preco;
    }

    private LocalDate dataFabricacao;

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    private String tipo;


    public String getTipo() {
        return tipo;
    }

    public Produtos(String nome, String fabricante, Double preco, String dataFabricacao, String tipo) { // recebo
                                                                                                               // a data
                                                                                                               // como
                                                                                                               // string
                                                                                                               // e
                                                                                                               // depois
                                                                                                               // converto,
                                                                                                               // foi o
                                                                                                               // unico
                                                                                                               // jeito
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.dataFabricacao = LocalDate.parse(dataFabricacao, DateTimeFormatter.ofPattern("ddMMyyyy"));
        this.tipo = tipo;
    }

        @Override
        public String toString() {
            return nome + " | " + fabricante + " | R$" + String.format("%.2f", preco) + " | " + dataFabricacao + " | " + tipo;
        }
    }

