package delivery.observer;

import delivery.modelo.Pedido;

/**
 * OBSERVER: quem quiser ser avisado das mudanças de status implementa esta interface.
 */
public interface PedidoObserver {
    void aoMudarStatus(Pedido pedido);
}
