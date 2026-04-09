package ordenacao;

public class HeapIterativo {

    // para ordenar os produtos por data de validade
    public static void ordenar(Produtos[] produtos) {
        int tamanho = produtos.length;

        construirMaxHeap(produtos, tamanho);

        // ordenação iterativa
        for (int i = tamanho - 1; i >= 1; i--) {
            trocar(produtos, 0, i); // Move o produto mais antigo para o final
            maxHeapifyIterativo(produtos, 0, i); // Ajusta o heap sem recursão
        }
    }

    // construção do Max-Heap
    private static void construirMaxHeap(Produtos[] produtos, int tamanho) {
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            maxHeapifyIterativo(produtos, i, tamanho);
        }
    }

    // iterativa do Heapify
    private static void maxHeapifyIterativo(Produtos[] produtos, int indice, int tamanho) {
        while (true) {
            int maior = indice;
            int esquerda = 2 * indice + 1;
            int direita = 2 * indice + 2;

            if (esquerda < tamanho
                    && produtos[esquerda].getDataFabricacao().compareTo(produtos[maior].getDataFabricacao()) > 0) {
                maior = esquerda;
            }

            if (direita < tamanho
                    && produtos[direita].getDataFabricacao().compareTo(produtos[maior].getDataFabricacao()) > 0) {
                maior = direita;
            }

            if (maior == indice) {
                break;
            }

            trocar(produtos, indice, maior);
            indice = maior;
        }
    }

    // função para trocar dois elementos
    private static void trocar(Produtos[] produtos, int i, int j) {
        Produtos temp = produtos[i];
        produtos[i] = produtos[j];
        produtos[j] = temp;
    }
}
