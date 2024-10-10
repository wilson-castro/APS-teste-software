import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class TestComMocks {
	/**
     * Teste mocando a classe Produto.
     * Verifica se os métodos de Produto são chamados corretamente ao adicionar produtos a um pedido.
     */
    @Test
    void testMocandoProduto() {
        Produto produtoMock = mock(Produto.class);

        when(produtoMock.getNome()).thenReturn("Café");
        when(produtoMock.getPreco()).thenReturn(10.0);
        when(produtoMock.getEstoque()).thenReturn(50);

        Pedido pedido = new Pedido();
        pedido.adicionarProduto(produtoMock, 2);

        verify(produtoMock, times(1)).removerEstoque(2);
    }
    
    /**
     * Teste mocando a classe GerenciadorPedidos.
     * Verifica se os métodos de criação de pedidos e relatório de vendas funcionam conforme o esperado.
     */
    
    @Test
    void testMocandoGerenciadorPedidos() {
        GerenciadorPedidos gerenciadorMock = mock(GerenciadorPedidos.class);
        Pedido pedidoMock = mock(Pedido.class);

        when(gerenciadorMock.criarPedido()).thenReturn(pedidoMock);

        Map<LocalDateTime, Double> relatorioSimulado = new HashMap<>();
        LocalDateTime data = LocalDateTime.now();
        relatorioSimulado.put(data, 100.0);
        when(gerenciadorMock.relatorioVendas()).thenReturn(relatorioSimulado);

        Pedido novoPedido = gerenciadorMock.criarPedido();
        assertNotNull(novoPedido); // Verifica se o pedido foi criado

        verify(gerenciadorMock, times(1)).criarPedido();

        Map<LocalDateTime, Double> relatorio = gerenciadorMock.relatorioVendas();
        assertEquals(100.0, relatorio.get(data)); // Verifica se o valor no relatório está correto

        verify(gerenciadorMock, times(1)).relatorioVendas();
    }
}
