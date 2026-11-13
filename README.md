# Delivery — Padrões de Projeto em Java Puro

Desafio final do módulo de Padrões de Projeto (DIO): um mini sistema de pedidos de delivery
que aplica, de forma integrada, sete padrões de projeto.

## Padrões aplicados

| Padrão | Onde | Papel no projeto |
|---|---|---|
| **Singleton** (Lazy Holder) | `singleton/Configuracao` | Regras globais (pedido mínimo, limite de frete grátis) |
| **Strategy** | `strategy/CalculoFrete`, `FreteEconomico`, `FreteExpresso` | Cálculo de frete intercambiável |
| **Chain of Responsibility** | `chain/Validador` + `ValidaItens`, `ValidaEndereco`, `ValidaValorMinimo` | Validação do pedido em etapas encadeadas |
| **Builder** | `modelo/Pedido.Builder` | Montagem fluente do pedido |
| **Factory** | `factory/PagamentoFactory` | Criação do meio de pagamento (PIX, cartão, dinheiro) |
| **Observer** | `observer/PedidoObserver`, `NotificacaoCliente`, `PainelCozinha` | Reação às mudanças de status do pedido |
| **Facade** | `facade/PedidoFacade` | Ponto único que orquestra validação, pagamento e notificações |

## Como executar

Requer JDK 17+.

```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out delivery.Main
```

No PowerShell:

```powershell
$files = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d out $files
java "-Dfile.encoding=UTF-8" -cp out delivery.Main
```

## Ideias de evolução

- Novos tipos de frete (Strategy) ou validadores (Chain) sem alterar código existente
- Persistência dos pedidos (Repository)
- Versão com Spring Boot expondo a `PedidoFacade` como API REST
