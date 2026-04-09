package ordenacao;

public class QuickSort {

    public static void ordenar(Produtos[] produtos, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = obterPivo(produtos, inicio, fim);
            trocar(produtos, pivoIndex, fim); // Coloca o pivô no final
            int novaPosicaoPivo = particiona(produtos, inicio, fim);
            ordenar(produtos, inicio, novaPosicaoPivo - 1);
            ordenar(produtos, novaPosicaoPivo + 1, fim);
        }
    }

    private static int obterPivo(Produtos[] produtos, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        Produtos a = produtos[inicio];
        Produtos b = produtos[meio];
        Produtos c = produtos[fim];

        // usei double.compare() para evitar erros de precisão
        if ((Double.compare(a.getPreco(), b.getPreco()) > 0) != (Double.compare(a.getPreco(), c.getPreco()) > 0))
            return inicio;
        else if ((Double.compare(b.getPreco(), a.getPreco()) > 0) != (Double.compare(b.getPreco(), c.getPreco()) > 0))
            return meio;
        else
            return fim;
    }

    private static int particiona(Produtos[] produtos, int inicio, int fim) {
        Produtos pivo = produtos[fim];
        int cursor = inicio;

        for (int i = inicio; i < fim; i++) {
            if (Double.compare(produtos[i].getPreco(), pivo.getPreco()) < 0) { // 🔹 Correção: Usando `Double.compare()`
                trocar(produtos, i, cursor);
                cursor++;
            }
        }

        trocar(produtos, cursor, fim); // posiciona o pivô corretamente
        return cursor;
    }

    private static void trocar(Produtos[] vetor, int i, int j) {
        Produtos temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
