package delivery.strategy;

import delivery.singleton.Configuracao;

public class FreteEconomico implements CalculoFrete {
    @Override
    public double calcular(double subtotal) {
        // Usa o Singleton: acima do limite o frete é grátis
        return subtotal >= Configuracao.getInstancia().getLimiteFreteGratis() ? 0.0 : 8.0;
    }

    @Override
    public String nome() {
        return "Econômico";
    }
}
