import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

public class TestesCaixaPreta {

	@Test
	void testCalculoTotal() {
		Produto produto1 = new Produto("Café", 10.0, 50);
		Produto produto2 = new Produto("Chá", 5.0, 30);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto1, 2); // 2 * 10.0
		pedido.adicionarProduto(produto2, 3); // 3 * 5.0

		assertEquals(35.0, pedido.calcularTotal()); // Total = 20 + 15
	}

	/**
	 * Teste de aplicação de desconto.
	 * Verifica se o desconto é aplicado corretamente ao total do pedido.
	 */
	@Test
	void testAplicacaoDesconto() {
		Produto produto = new Produto("Café", 10.0, 50);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto, 5); // 5 * 10.0 = 50
		pedido.aplicarDesconto(10.0); // 10% de desconto

		assertEquals(45.0, pedido.calcularTotal()); // Total com desconto = 50 * 0.9
	}

	/**
	 * Teste de aplicação de desconto negativo.
	 * Verifica se a aplicação de um desconto negativo é tratada corretamente.
	 */
	@Test
	void testDescontoNegativo() {
		Produto produto = new Produto("Café", 10.0, 50);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto, 5); // 5 * 10.0 = 50

		// Tentar aplicar um desconto negativo
		assertThrows(IllegalArgumentException.class, () -> {
			pedido.aplicarDesconto(-5.0);
		});
	}

	/**
	 * Teste de listagem de pedidos.
	 * Verifica se a listagem de pedidos retorna todos os pedidos criados com a lista correta de produtos.
	 */
	@Test
	void testListagemPedidos() {
		GerenciadorPedidos gerenciador = new GerenciadorPedidos();
		Pedido pedido1 = gerenciador.criarPedido();
		Pedido pedido2 = gerenciador.criarPedido();

		Produto produto1 = new Produto("Café", 10.0, 50);
		Produto produto2 = new Produto("Chá", 5.0, 30);

		pedido1.adicionarProduto(produto1, 2);
		pedido2.adicionarProduto(produto2, 1);

		List<Pedido> pedidos = gerenciador.listarPedidos();
		assertEquals(2, pedidos.size()); // Devem existir 2 pedidos

		// Verifica os produtos do primeiro pedido
		assertEquals(20.0, pedidos.get(0).calcularTotal()); // Pedido 1 contém 2 unidades de produto1 (2 * 10.0)

		// Verifica os produtos do segundo pedido
		assertEquals(5.0, pedidos.get(1).calcularTotal()); // Pedido 2 contém 1 unidade de produto2 (1 * 5.0)
	}

	/**
	 * Teste de relatório de vendas.
	 * Verifica se o relatório de vendas retorna os totais corretos agrupados por data.
	 */
	@Test
	void testRelatorioVendas() {
		GerenciadorPedidos gerenciador = new GerenciadorPedidos();
		Pedido pedido1 = gerenciador.criarPedido();
		Pedido pedido2 = gerenciador.criarPedido();

		Produto produto1 = new Produto("Café", 10.0, 50);
		Produto produto2 = new Produto("Chá", 5.0, 30);

		pedido1.adicionarProduto(produto1, 2); // 20.0
		pedido2.adicionarProduto(produto2, 3); // 15.0

		Map<LocalDateTime, Double> relatorio = gerenciador.relatorioVendas();
		assertEquals(2, relatorio.size()); // Devem existir 2 registros no relatório

		// Verifica se o total por data está correto
		assertEquals(20.0, relatorio.get(pedido1.getData()));
		assertEquals(15.0, relatorio.get(pedido2.getData()));
	}

	/**
	 * Teste de relatório de vendas quando não há pedidos.
	 * Verifica se o relatório retorna vazio quando não há pedidos criados.
	 */
	@Test
	void testRelatorioVazio() {
		GerenciadorPedidos gerenciador = new GerenciadorPedidos();
		Map<LocalDateTime, Double> relatorio = gerenciador.relatorioVendas();
		assertTrue(relatorio.isEmpty()); // O relatório deve estar vazio
	}

}
