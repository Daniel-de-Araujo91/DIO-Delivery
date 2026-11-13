package delivery.chain;

import delivery.modelo.Pedido;

/**
 * CHAIN OF RESPONSIBILITY: cada validador trata a sua regra e repassa ao próximo.
 */
public abstract class Validador {

    private Validador proximo;

    public Validador encadear(Validador proximo) {
        this.proximo = proximo;
        return proximo; // permite encadeamento fluente
    }

    public void validar(Pedido pedido) {
        verificar(pedido);
        if (proximo != null) {
            proximo.validar(pedido);
        }
    }

    protected abstract void verificar(Pedido pedido);
}
