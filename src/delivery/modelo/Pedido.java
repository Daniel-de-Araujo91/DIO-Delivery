package delivery.modelo;

import delivery.observer.PedidoObserver;
import delivery.strategy.CalculoFrete;

import java.util.ArrayList;
import java.util.List;

/**
 * Pedido é o "Subject" do OBSERVER e é montado pelo BUILDER.
 */
public class Pedido {

    private final String cliente;
    private final String endereco;
    private final List<Item> itens;
    private final CalculoFrete calculoFrete;
    private final List<PedidoObserver> observers = new ArrayList<>();
    private StatusPedido status = StatusPedido.CRIADO;

    private Pedido(Builder b) {
        this.cliente = b.cliente;
        this.endereco = b.endereco;
        this.itens = List.copyOf(b.itens);
        this.calculoFrete = b.calculoFrete;
    }

    // ---------- Observer ----------
    public void adicionarObserver(PedidoObserver o) {
        observers.add(o);
    }

    public void mudarStatus(StatusPedido novo) {
        this.status = novo;
        observers.forEach(o -> o.aoMudarStatus(this));
    }

    // ---------- Valores ----------
    public double getSubtotal() {
        return itens.stream().mapToDouble(Item::subtotal).sum();
    }

    public double getFrete() {
        return calculoFrete.calcular(getSubtotal());
    }

    public double getTotal() {
        return getSubtotal() + getFrete();
    }

    public String getCliente() { return cliente; }
    public String getEndereco() { return endereco; }
    public List<Item> getItens() { return itens; }
    public StatusPedido getStatus() { return status; }
    public CalculoFrete getCalculoFrete() { return calculoFrete; }

    // ---------- Builder ----------
    public static class Builder {
        private String cliente;
        private String endereco;
        private final List<Item> itens = new ArrayList<>();
        private CalculoFrete calculoFrete;

        public Builder cliente(String cliente) { this.cliente = cliente; return this; }
        public Builder endereco(String endereco) { this.endereco = endereco; return this; }
        public Builder item(String nome, int qtd, double preco) {
            itens.add(new Item(nome, qtd, preco));
            return this;
        }
        public Builder frete(CalculoFrete frete) { this.calculoFrete = frete; return this; }

        public Pedido build() {
            return new Pedido(this);
        }
    }
}
