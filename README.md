# APS de Testes de Software

Este documento cont�m o relat�rio dos testes realizados no projeto. Os testes cobrem as funcionalidades das classes `Produto`, `Pedido` e `GerenciadorPedidos`, utilizando testes de **Caixa Branca**, **Caixa Preta**, e **Mocking**.

## Resultados dos Testes
| Teste                            | Categoria         | Resultado | Descri��o                                                                                                                                       |
| --------------------------------- | ----------------- | --------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| `testInicializacaoProduto`        | Caixa Branca      | Sucesso   | Verifica a inicializa��o correta de um objeto `Produto` com nome, pre�o e estoque.                                                              |
| `testRemocaoEstoqueValido`        | Caixa Branca      | Sucesso   | Verifica se a remo��o de estoque atualiza corretamente o valor de estoque quando a quantidade � v�lida.                                          |
| `testRemocaoEstoqueInsuficiente`  | Caixa Branca      | Sucesso   | Verifica se uma exce��o � lan�ada ao tentar remover mais do que o estoque dispon�vel.                                                            |
| `testAdicaoProdutoAtualizaEstoque`| Caixa Branca      | Sucesso   | Verifica se a adi��o de um produto ao pedido atualiza corretamente o estoque.                                                                    |
| `testAdicaoProdutoEstoqueInsuficiente`| Caixa Branca  | Sucesso   | Verifica se uma exce��o � lan�ada ao tentar adicionar um produto sem estoque suficiente.                                                         |
| `testCalculoTotalSemDesconto`     | Caixa Branca      | Sucesso   | Verifica se o c�lculo total do pedido � feito corretamente sem a aplica��o de descontos.                                                        |
| `testCalculoTotalComDesconto`     | Caixa Branca      | Sucesso   | Verifica se o c�lculo total do pedido � feito corretamente com descontos aplicados.                                                             |
| `testCalculoTotal`                | Caixa Preta       | Sucesso   | Verifica se o c�lculo do total de um pedido leva em considera��o o pre�o de cada produto e suas respectivas quantidades.                         |
| `testAplicacaoDesconto`           | Caixa Preta       | Sucesso   | Verifica se o desconto � aplicado corretamente ao total do pedido.                                                                              |
| **`testDescontoNegativo`**        | **Caixa Preta**   | **Falha** | **Descontos negativos est�o sendo permitidos, enquanto uma exce��o deveria ser lan�ada ao tentar aplicar um desconto negativo.**                 |
| `testListagemPedidos`             | Caixa Preta       | Sucesso   | Verifica se a listagem de pedidos retorna todos os pedidos criados com a lista correta de produtos.                                              |
| `testRelatorioVendas`             | Caixa Preta       | Sucesso   | Verifica se o relat�rio de vendas retorna os totais corretos agrupados por data.                                                                |
| `testRelatorioVazio`              | Caixa Preta       | Sucesso   | Verifica se o relat�rio de vendas retorna vazio quando n�o h� pedidos criados.                                                                  |
| `testMocandoProduto`              | Mocking           | Sucesso   | Verifica se os m�todos de `Produto` s�o chamados corretamente ao adicionar produtos a um pedido, simulando a classe `Produto`.                   |
| `testMocandoGerenciadorPedidos`   | Mocking           | Sucesso   | Verifica se os m�todos de cria��o de pedidos e relat�rio de vendas s�o chamados corretamente, simulando a classe `GerenciadorPedidos`.           |

## Observa��o Importante

- **Falha em `testDescontoNegativo`:** O teste de aplica��o de desconto negativo (`testDescontoNegativo`) falhou. O sistema est� permitindo a aplica��o de descontos negativos, o que n�o deveria ocorrer. A funcionalidade precisa ser ajustada para lan�ar uma exce��o quando um valor de desconto negativo for passado.

---