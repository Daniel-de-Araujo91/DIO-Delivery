package delivery.chain;

import delivery.modelo.Pedido;

public class ValidaItens extends Validador {
    @Override
    protected void verificar(Pedido pedido) {
        if (pedido.getItens().isEmpty()) {
            throw new IllegalArgumentException("O pedido precisa ter ao menos um item.");
        }
    }
}
