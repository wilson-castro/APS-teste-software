import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Pedido {
	private List<Produto> produtos;
	private double desconto;
	private LocalDateTime data;

	public Pedido() {
		produtos = new ArrayList<Produto>();
		data = LocalDateTime.now();
	}

	public void adicionarProduto(Produto produto, int quantidade) {
		produto.removerEstoque(quantidade);
		for (int i = 0; i < quantidade; i++) {
			produtos.add(produto);
		}
	}

	public double calcularTotal() {
		double total = 0;
		for (Produto produto : produtos) {
			total += produto.getPreco();
		}
		return total * (1 - desconto / 100);
	}

	public void aplicarDesconto(double percentual) {
		desconto += percentual;
	}

	public LocalDateTime getData() { return data; }
}
