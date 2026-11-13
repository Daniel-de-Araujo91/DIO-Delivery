package delivery.observer;

import delivery.modelo.Pedido;

public class NotificacaoCliente implements PedidoObserver {
    @Override
    public void aoMudarStatus(Pedido pedido) {
        System.out.printf("  [SMS para %s] Seu pedido agora está: %s%n", pedido.getCliente(), pedido.getStatus());
    }
}
