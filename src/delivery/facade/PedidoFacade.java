package delivery.facade;

import delivery.chain.ValidaEndereco;
import delivery.chain.ValidaItens;
import delivery.chain.ValidaValorMinimo;
import delivery.chain.Validador;
import delivery.factory.PagamentoFactory;
import delivery.modelo.Pedido;
import delivery.modelo.StatusPedido;
import delivery.observer.NotificacaoCliente;
import delivery.observer.PainelCozinha;

/**
 * FACADE: interface simples que esconde a orquestração de validação (Chain),
 * pagamento (Factory) e notificações (Observer).
 */
public class PedidoFacade {

    private final Validador cadeia;

    public PedidoFacade() {
        ValidaItens inicio = new ValidaItens();
        inicio.encadear(new ValidaEndereco()).encadear(new ValidaValorMinimo());
        this.cadeia = inicio;
    }

    public boolean finalizar(Pedido pedido, PagamentoFactory.Tipo tipoPagamento) {
        System.out.printf("Pedido de %s | frete %s%n", pedido.getCliente(), pedido.getCalculoFrete().nome());
        try {
            cadeia.validar(pedido);
        } catch (IllegalArgumentException e) {
            System.out.println("  Pedido recusado: " + e.getMessage());
            return false;
        }

        pedido.adicionarObserver(new NotificacaoCliente());
        pedido.adicionarObserver(new PainelCozinha());

        System.out.printf("  Subtotal R$ %.2f + frete R$ %.2f = R$ %.2f%n",
                pedido.getSubtotal(), pedido.getFrete(), pedido.getTotal());
        PagamentoFactory.criar(tipoPagamento).pagar(pedido.getTotal());

        pedido.mudarStatus(StatusPedido.PAGO);
        pedido.mudarStatus(StatusPedido.EM_PREPARO);
        pedido.mudarStatus(StatusPedido.SAIU_PARA_ENTREGA);
        pedido.mudarStatus(StatusPedido.ENTREGUE);
        return true;
    }
}
