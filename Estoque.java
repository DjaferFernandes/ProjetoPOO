import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Produto, Integer> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public int verificarEstoque(Produto produto) {
        return produtos.getOrDefault(produto, 0);
    }

    public void atualizarEstoque(Produto produto, int quantidade) {
        produtos.put(produto, quantidade);
    }
}