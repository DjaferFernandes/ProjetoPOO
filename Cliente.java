import java.util.ArrayList;
import java.util.List;

public class Cliente implements Entidade {
    private int id;
    private String nome;
    private String email;
    private List<Venda> historicoDeCompras;

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.historicoDeCompras = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Venda> getHistoricoDeCompras() {
        return historicoDeCompras;
    }

    public void adicionarCompra(Venda venda) {
        historicoDeCompras.add(venda);
    }
}