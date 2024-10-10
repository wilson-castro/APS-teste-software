import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GerenciadorPedidos {
	private List<Pedido> pedidos;

	public GerenciadorPedidos() {
		pedidos = new ArrayList<Pedido>();
	}

	public Pedido criarPedido() {
		Pedido pedido = new Pedido();
		pedidos.add(pedido);
		return pedido;
	}

	public List<Pedido> listarPedidos() {
		return pedidos;
	}

	public Map<LocalDateTime, Double> relatorioVendas() {
		Map<LocalDateTime, Double> relatorio = new HashMap<LocalDateTime, Double>();
		for (Pedido pedido : pedidos) {
			LocalDateTime data = pedido.getData();
			double total = pedido.calcularTotal();
			relatorio.put(data, relatorio.getOrDefault(data, 0.0) + total);
		}
		return relatorio;
	}
}
