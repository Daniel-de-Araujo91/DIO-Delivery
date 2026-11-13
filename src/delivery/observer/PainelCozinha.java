package delivery.observer;

import delivery.modelo.Pedido;
import delivery.modelo.StatusPedido;

public class PainelCozinha implements PedidoObserver {
    @Override
    public void aoMudarStatus(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.PAGO) {
            System.out.println("  [Cozinha] Novo pedido recebido: " + pedido.getItens().size() + " item(ns).");
        }
    }
}
