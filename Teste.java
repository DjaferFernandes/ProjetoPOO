import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Teste {

    private static final Logger logger = Logger.getLogger(Teste.class.getName());

    public static void main(String[] args) {

        // Criando categorias
        Categoria categoriaRoupa = new Categoria(1, "Roupas");
        Categoria categoriaEletronico = new Categoria(2, "Eletrônicos");

        // Criando produtos
        Produto camisa = new Produto(1, "Camisa Polo", "Camisa de algodão", 79.90, "M", "Azul", 50, categoriaRoupa);
        Produto celular = new Produto(2, "Smartphone", "Celular com tela AMOLED", 1999.90, "Único", "Preto", 30, categoriaEletronico);

        // Criando o estoque e adicionando produtos
        Estoque estoque = new Estoque();
        estoque.atualizarEstoque(camisa, camisa.getQuantidadeEmEstoque());
        estoque.atualizarEstoque(celular, celular.getQuantidadeEmEstoque());

        // Log de estoque inicial
        logger.info("Estoque inicial de " + camisa.getNome() + ": " + estoque.verificarEstoque(camisa) + " unidades.");
        logger.info("Estoque inicial de " + celular.getNome() + ": " + estoque.verificarEstoque(celular) + " unidades.");

        // Criando cliente
        Cliente cliente = new Cliente(1, "João Silva", "joao.silva@email.com");

        // Criando itens de venda
        ItemDeVenda item1 = new ItemDeVenda(camisa, 2);
        ItemDeVenda item2 = new ItemDeVenda(celular, 1);

        // Criando a lista de itens de venda
        List<ItemDeVenda> itensDeVenda = new ArrayList<>();
        itensDeVenda.add(item1);
        itensDeVenda.add(item2);

        // Criando a venda
        Venda venda = new Venda(1, cliente, itensDeVenda);
        cliente.adicionarCompra(venda);

        // Log da venda
        logger.info("Venda realizada para o cliente " + cliente.getNome() + ", total: R$ " + venda.getTotal());

        // Atualizando o estoque após a venda
        estoque.atualizarEstoque(camisa, camisa.getQuantidadeEmEstoque() - item1.getQuantidade());
        estoque.atualizarEstoque(celular, celular.getQuantidadeEmEstoque() - item2.getQuantidade());

        // Log do estoque após a venda
        logger.info("Estoque de " + camisa.getNome() + " após a venda: " + estoque.verificarEstoque(camisa) + " unidades.");
        logger.info("Estoque de " + celular.getNome() + " após a venda: " + estoque.verificarEstoque(celular) + " unidades.");
    }
}