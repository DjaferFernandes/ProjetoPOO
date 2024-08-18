import java.time.LocalDateTime;
import java.util.List;

public class Venda implements Entidade {
    private int id;
    private LocalDateTime data;
    private double total;
    private Cliente cliente;
    private List<ItemDeVenda> itensDeVenda;

    public Venda(int id, Cliente cliente, List<ItemDeVenda> itensDeVenda) {
        this.id = id;
        this.data = LocalDateTime.now();
        this.cliente = cliente;
        this.itensDeVenda = itensDeVenda;
        calcularTotal();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return "Venda #" + id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemDeVenda> getItensDeVenda() {
        return itensDeVenda;
    }

    public void calcularTotal() {
        this.total = itensDeVenda.stream().mapToDouble(ItemDeVenda::getSubtotal).sum();
    }
}
