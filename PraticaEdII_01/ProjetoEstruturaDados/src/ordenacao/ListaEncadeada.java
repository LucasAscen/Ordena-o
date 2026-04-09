package ordenacao;

public class ListaEncadeada {
    private NoProduto primeiro;

    // Método para inserir ordenado (Insertion Sort na inserção)
    public void inserirOrdenado(Produtos produto) {
        NoProduto novoNo = new NoProduto(produto);
        if (primeiro == null || produto.getNome().compareTo(primeiro.produto.getNome()) < 0) {
            novoNo.proximo = primeiro;
            primeiro = novoNo;
        } else {
            NoProduto atual = primeiro;
            while (atual.proximo != null
                    && produto.getNome().compareTo(atual.proximo.produto.getNome()) > 0) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
        }
    }

    // exibir a lista ordenada
    public void exibir() {
        NoProduto atual = primeiro;
        System.out.println("Lista encadeada ordenada por nome:");
        while (atual != null) {
            System.out.println(atual.produto);
            atual = atual.proximo;
        }
    }
}

// aqui é um auxiliar para representar os nós da lista
class NoProduto {
    Produtos produto;
    NoProduto proximo;

    public NoProduto(Produtos produto) {
        this.produto = produto;
        this.proximo = null;
    }
}
