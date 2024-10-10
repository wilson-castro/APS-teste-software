import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestesCaixaBranca {

	/**
	 * Teste de inicialização de um objeto Produto.
	 * Verifica se o nome, preço e estoque são inicializados corretamente.
	 */
	@Test
	void testInicializacaoProduto() {
		Produto produto = new Produto("Café", 10.0, 50);

		assertEquals("Café", produto.getNome());
		assertEquals(10.0, produto.getPreco());
		assertEquals(50, produto.getEstoque());
	}

	/**
	 * Testa a remoção de uma quantidade válida de estoque.
	 * Verifica se o estoque é atualizado corretamente após a remoção.
	 */
	@Test
	void testRemocaoEstoqueValido() {
		Produto produto = new Produto("Café", 10.0, 50);
		produto.removerEstoque(20);
		assertEquals(30, produto.getEstoque());
	}

	/**
	 * Testa a remoção de estoque insuficiente.
	 * Verifica se uma exceção IllegalArgumentException é lançada
	 * quando a quantidade removida é maior que o estoque disponível.
	 */
	@Test
	void testRemocaoEstoqueInsuficiente() {
		Produto produto = new Produto("Café", 10.0, 50);

		assertThrows(IllegalArgumentException.class, () -> {
			produto.removerEstoque(60);
		});
	}

	/**
	 * Testa a adição de um produto a um pedido.
	 * Verifica se o estoque é atualizado corretamente após a adição de um produto ao pedido.
	 */
	@Test
	void testAdicaoProdutoAtualizaEstoque() {
		Produto produto = new Produto("Café", 10.0, 50);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto, 10);
		assertEquals(40, produto.getEstoque());
	}

	/**
	 * Testa a adição de um produto com estoque insuficiente.
	 * Verifica se uma exceção IllegalArgumentException é lançada
	 * quando se tenta adicionar mais produtos ao pedido do que há em estoque.
	 */
	@Test
	void testAdicaoProdutoEstoqueInsuficiente() {
		Produto produto = new Produto("Café", 10.0, 5);
		Pedido pedido = new Pedido();

		assertThrows(IllegalArgumentException.class, () -> {
			pedido.adicionarProduto(produto, 10);
		});
	}

	/**
	 * Testa o cálculo do total de um pedido sem aplicar descontos.
	 * Verifica se o total é calculado corretamente.
	 */
	@Test
	void testCalculoTotalSemDesconto() {
		Produto produto1 = new Produto("Café", 10.0, 50);
		Produto produto2 = new Produto("Chá", 5.0, 30);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto1, 3); // 3 * 10.0
		pedido.adicionarProduto(produto2, 2); // 2 * 5.0

		assertEquals(40.0, pedido.calcularTotal()); // Total = 30 + 10
	}

	/**
	 * Testa o cálculo do total de um pedido com descontos aplicados.
	 * Verifica se o desconto é aplicado corretamente ao valor total.
	 */
	@Test
	void testCalculoTotalComDesconto() {
		Produto produto1 = new Produto("Café", 10.0, 50);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto1, 5); // 5 * 10.0 = 50
		pedido.aplicarDesconto(10.0); // 10% de desconto

		assertEquals(45.0, pedido.calcularTotal()); // Total com desconto = 50 * 0.9
	}
}
