package delivery;

import delivery.facade.PedidoFacade;
import delivery.factory.PagamentoFactory.Tipo;
import delivery.modelo.Pedido;
import delivery.singleton.Configuracao;
import delivery.strategy.FreteEconomico;
import delivery.strategy.FreteExpresso;

public class Main {
    public static void main(String[] args) {
        PedidoFacade facade = new PedidoFacade();

        // Singleton: sempre a mesma instância
        System.out.println("Singleton igual? " + (Configuracao.getInstancia() == Configuracao.getInstancia()));
        System.out.println();

        // 1) Pedido válido, frete expresso, PIX
        Pedido p1 = new Pedido.Builder()
                .cliente("Ana").endereco("Rua das Flores, 10")
                .item("Pizza grande", 1, 55.0).item("Refrigerante", 2, 8.0)
                .frete(new FreteExpresso()).build();
        facade.finalizar(p1, Tipo.PIX);
        System.out.println();

        // 2) Pedido alto: frete econômico fica grátis
        Pedido p2 = new Pedido.Builder()
                .cliente("Bruno").endereco("Av. Brasil, 500")
                .item("Combo família", 2, 60.0)
                .frete(new FreteEconomico()).build();
        facade.finalizar(p2, Tipo.CARTAO);
        System.out.println();

        // 3) Recusado pela cadeia: valor mínimo
        Pedido p3 = new Pedido.Builder()
                .cliente("Carla").endereco("Rua A, 1")
                .item("Suco", 1, 7.0)
                .frete(new FreteEconomico()).build();
        facade.finalizar(p3, Tipo.DINHEIRO);
        System.out.println();

        // 4) Recusado pela cadeia: sem endereço
        Pedido p4 = new Pedido.Builder()
                .cliente("Diego").item("Hambúrguer", 2, 25.0)
                .frete(new FreteEconomico()).build();
        facade.finalizar(p4, Tipo.PIX);
    }
}
