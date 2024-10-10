# APS de Testes de Software

Este documento contém o relatório dos testes realizados no projeto. Os testes cobrem as funcionalidades das classes `Produto`, `Pedido` e `GerenciadorPedidos`, utilizando testes de **Caixa Branca**, **Caixa Preta**, e **Mocking**.

## Resultados dos Testes
| Teste                            | Categoria         | Resultado | Descrição                                                                                                                                       |
| --------------------------------- | ----------------- | --------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| `testInicializacaoProduto`        | Caixa Branca      | Sucesso   | Verifica a inicialização correta de um objeto `Produto` com nome, preço e estoque.                                                              |
| `testRemocaoEstoqueValido`        | Caixa Branca      | Sucesso   | Verifica se a remoção de estoque atualiza corretamente o valor de estoque quando a quantidade é válida.                                          |
| `testRemocaoEstoqueInsuficiente`  | Caixa Branca      | Sucesso   | Verifica se uma exceção é lançada ao tentar remover mais do que o estoque disponível.                                                            |
| `testAdicaoProdutoAtualizaEstoque`| Caixa Branca      | Sucesso   | Verifica se a adição de um produto ao pedido atualiza corretamente o estoque.                                                                    |
| `testAdicaoProdutoEstoqueInsuficiente`| Caixa Branca  | Sucesso   | Verifica se uma exceção é lançada ao tentar adicionar um produto sem estoque suficiente.                                                         |
| `testCalculoTotalSemDesconto`     | Caixa Branca      | Sucesso   | Verifica se o cálculo total do pedido é feito corretamente sem a aplicação de descontos.                                                        |
| `testCalculoTotalComDesconto`     | Caixa Branca      | Sucesso   | Verifica se o cálculo total do pedido é feito corretamente com descontos aplicados.                                                             |
| `testCalculoTotal`                | Caixa Preta       | Sucesso   | Verifica se o cálculo do total de um pedido leva em consideração o preço de cada produto e suas respectivas quantidades.                         |
| `testAplicacaoDesconto`           | Caixa Preta       | Sucesso   | Verifica se o desconto é aplicado corretamente ao total do pedido.                                                                              |
| **`testDescontoNegativo`**        | **Caixa Preta**   | **Falha** | **Descontos negativos estão sendo permitidos, enquanto uma exceção deveria ser lançada ao tentar aplicar um desconto negativo.**                 |
| `testListagemPedidos`             | Caixa Preta       | Sucesso   | Verifica se a listagem de pedidos retorna todos os pedidos criados com a lista correta de produtos.                                              |
| `testRelatorioVendas`             | Caixa Preta       | Sucesso   | Verifica se o relatório de vendas retorna os totais corretos agrupados por data.                                                                |
| `testRelatorioVazio`              | Caixa Preta       | Sucesso   | Verifica se o relatório de vendas retorna vazio quando não há pedidos criados.                                                                  |
| `testMocandoProduto`              | Mock              | Sucesso   | Verifica se os métodos de `Produto` são chamados corretamente ao adicionar produtos a um pedido, simulando a classe `Produto`.                   |
| `testMocandoGerenciadorPedidos`   | Mockin            | Sucesso   | Verifica se os métodos de criação de pedidos e relatório de vendas são chamados corretamente, simulando a classe `GerenciadorPedidos`.           |

## Observação Importante

- **Falha em `testDescontoNegativo`:** O teste de aplicação de desconto negativo (`testDescontoNegativo`) falhou. O sistema está permitindo a aplicação de descontos negativos, o que não deveria ocorrer. A funcionalidade precisa ser ajustada para lançar uma exceção quando um valor de desconto negativo for passado.

---
