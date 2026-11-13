package delivery.modelo;

public record Item(String nome, int quantidade, double precoUnitario) {
    public double subtotal() {
        return quantidade * precoUnitario;
    }
}
