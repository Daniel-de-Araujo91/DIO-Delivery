package delivery.factory;

/**
 * FACTORY: centraliza a criação do meio de pagamento conforme o tipo escolhido.
 */
public class PagamentoFactory {

    public enum Tipo { PIX, CARTAO, DINHEIRO }

    private PagamentoFactory() {
    }

    public static Pagamento criar(Tipo tipo) {
        return switch (tipo) {
            case PIX -> v -> System.out.printf("  Pagamento de R$ %.2f via PIX confirmado.%n", v);
            case CARTAO -> v -> System.out.printf("  Pagamento de R$ %.2f no cartão aprovado.%n", v);
            case DINHEIRO -> v -> System.out.printf("  Pagamento de R$ %.2f em dinheiro na entrega.%n", v);
        };
    }
}
