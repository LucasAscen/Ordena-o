
package ordenacao;

public class ShellSortMod {

    public static void ordenar(Produtos[] produtos) {
        int n = produtos.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }

        // aplicação do ShellSort com SelectSort para h > 1 e InsertSort para h = 1
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                Produtos temp = produtos[i]; // temp deve ser um objeto Produto
                int j = i;

                if (h > 1) { // selectSort quando h > 1
                    int minIndex = j;
                    for (int k = j - h; k >= 0; k -= h) {
                        if (produtos[k].getNome().compareTo(produtos[minIndex].getNome()) < 0) {

                            minIndex = k;
                        }
                    }
                    produtos[j] = produtos[minIndex];
                    produtos[minIndex] = temp;
                } else { // insertSort quando h == 1
                    while (j >= h && produtos[j - h].getNome().compareTo(temp.getNome()) > 0) {

                        produtos[j] = produtos[j - h];
                        j -= h;
                    }
                    produtos[j] = temp;
                }
            }
            h /= 3; // reduz o incremento de h
        }
    }
}
