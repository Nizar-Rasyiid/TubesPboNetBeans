package sendit;

class Pembayaran {
    private static int nextId = 1;
    private int idPembayaran;
    private String metodePembayaran;
    private double totalPembayaran;

    public Pembayaran(String metodePembayaran, double totalPembayaran) {
        this.idPembayaran = nextId++;
        this.metodePembayaran = metodePembayaran;
        this.totalPembayaran = totalPembayaran;
    }

    public int getIdPembayaran() {
        return idPembayaran;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public double getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }
}