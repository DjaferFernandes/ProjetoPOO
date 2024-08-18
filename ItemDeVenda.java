public class ItemDeVenda {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemDeVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void calcularSubtotal() {
        this.subtotal = produto.getPreco() * quantidade;
    }
}