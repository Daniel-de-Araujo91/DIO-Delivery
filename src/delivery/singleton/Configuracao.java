package delivery.singleton;

/**
 * SINGLETON (Lazy Holder): uma única instância de configuração para toda a aplicação,
 * criada sob demanda e thread-safe sem precisar de synchronized.
 */
public class Configuracao {

    private final double valorMinimoPedido = 20.0;
    private final double limiteFreteGratis = 100.0;

    private Configuracao() {
    }

    private static class Holder {
        private static final Configuracao INSTANCIA = new Configuracao();
    }

    public static Configuracao getInstancia() {
        return Holder.INSTANCIA;
    }

    public double getValorMinimoPedido() {
        return valorMinimoPedido;
    }

    public double getLimiteFreteGratis() {
        return limiteFreteGratis;
    }
}
