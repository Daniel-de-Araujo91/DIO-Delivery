package delivery.strategy;

public class FreteExpresso implements CalculoFrete {
    @Override
    public double calcular(double subtotal) {
        return 15.0 + subtotal * 0.05;
    }

    @Override
    public String nome() {
        return "Expresso";
    }
}
