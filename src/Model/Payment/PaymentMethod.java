package Model.Payment;

public abstract class PaymentMethod {
    protected String id_user;
    protected double harga;
    protected int id_pemesanan;

    public PaymentMethod(String id_user, double harga, int id_pemesanan) {
        this.id_user = id_user;
        this.harga = harga;
        this.id_pemesanan = id_pemesanan;
    }

    public abstract void processPayment();
}
