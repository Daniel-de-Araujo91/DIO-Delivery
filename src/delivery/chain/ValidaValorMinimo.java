package delivery.chain;

import delivery.modelo.Pedido;
import delivery.singleton.Configuracao;

public class ValidaValorMinimo extends Validador {
    @Override
    protected void verificar(Pedido pedido) {
        double minimo = Configuracao.getInstancia().getValorMinimoPedido();
        if (pedido.getSubtotal() < minimo) {
            throw new IllegalArgumentException(
                    String.format("Pedido mínimo é R$ %.2f (atual: R$ %.2f).", minimo, pedido.getSubtotal()));
        }
    }
}
