package delivery.strategy;

/**
 * STRATEGY: cada modalidade de frete é um algoritmo intercambiável.
 */
public interface CalculoFrete {
    double calcular(double subtotal);

    String nome();
}
