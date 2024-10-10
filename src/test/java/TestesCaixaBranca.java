import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestesCaixaBranca {

	/**
	 * Teste de inicializa��o de um objeto Produto.
	 * Verifica se o nome, pre�o e estoque s�o inicializados corretamente.
	 */
	@Test
	void testInicializacaoProduto() {
		Produto produto = new Produto("Caf�", 10.0, 50);

		assertEquals("Caf�", produto.getNome());
		assertEquals(10.0, produto.getPreco());
		assertEquals(50, produto.getEstoque());
	}

	/**
	 * Testa a remo��o de uma quantidade v�lida de estoque.
	 * Verifica se o estoque � atualizado corretamente ap�s a remo��o.
	 */
	@Test
	void testRemocaoEstoqueValido() {
		Produto produto = new Produto("Caf�", 10.0, 50);
		produto.removerEstoque(20);
		assertEquals(30, produto.getEstoque());
	}

	/**
	 * Testa a remo��o de estoque insuficiente.
	 * Verifica se uma exce��o IllegalArgumentException � lan�ada
	 * quando a quantidade removida � maior que o estoque dispon�vel.
	 */
	@Test
	void testRemocaoEstoqueInsuficiente() {
		Produto produto = new Produto("Caf�", 10.0, 50);

		assertThrows(IllegalArgumentException.class, () -> {
			produto.removerEstoque(60);
		});
	}

	/**
	 * Testa a adi��o de um produto a um pedido.
	 * Verifica se o estoque � atualizado corretamente ap�s a adi��o de um produto ao pedido.
	 */
	@Test
	void testAdicaoProdutoAtualizaEstoque() {
		Produto produto = new Produto("Caf�", 10.0, 50);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto, 10);
		assertEquals(40, produto.getEstoque());
	}

	/**
	 * Testa a adi��o de um produto com estoque insuficiente.
	 * Verifica se uma exce��o IllegalArgumentException � lan�ada
	 * quando se tenta adicionar mais produtos ao pedido do que h� em estoque.
	 */
	@Test
	void testAdicaoProdutoEstoqueInsuficiente() {
		Produto produto = new Produto("Caf�", 10.0, 5);
		Pedido pedido = new Pedido();

		assertThrows(IllegalArgumentException.class, () -> {
			pedido.adicionarProduto(produto, 10);
		});
	}

	/**
	 * Testa o c�lculo do total de um pedido sem aplicar descontos.
	 * Verifica se o total � calculado corretamente.
	 */
	@Test
	void testCalculoTotalSemDesconto() {
		Produto produto1 = new Produto("Caf�", 10.0, 50);
		Produto produto2 = new Produto("Ch�", 5.0, 30);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto1, 3); // 3 * 10.0
		pedido.adicionarProduto(produto2, 2); // 2 * 5.0

		assertEquals(40.0, pedido.calcularTotal()); // Total = 30 + 10
	}

	/**
	 * Testa o c�lculo do total de um pedido com descontos aplicados.
	 * Verifica se o desconto � aplicado corretamente ao valor total.
	 */
	@Test
	void testCalculoTotalComDesconto() {
		Produto produto1 = new Produto("Caf�", 10.0, 50);
		Pedido pedido = new Pedido();

		pedido.adicionarProduto(produto1, 5); // 5 * 10.0 = 50
		pedido.aplicarDesconto(10.0); // 10% de desconto

		assertEquals(45.0, pedido.calcularTotal()); // Total com desconto = 50 * 0.9
	}
}
