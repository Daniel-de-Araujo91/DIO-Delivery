package delivery.chain;

import delivery.modelo.Pedido;

public class ValidaEndereco extends Validador {
    @Override
    protected void verificar(Pedido pedido) {
        String e = pedido.getEndereco();
        if (e == null || e.isBlank()) {
            throw new IllegalArgumentException("Endereço de entrega é obrigatório.");
        }
    }
}
