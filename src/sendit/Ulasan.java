package sendit;

class Ulasan {
    private static int nextId = 1;
    private int idUlasan;
    private int idPesanan;
    private String ulasan;

    public Ulasan(int idPesanan, String ulasan) {
        this.idUlasan = nextId++;
        this.idPesanan = idPesanan;
        this.ulasan = ulasan;
    }

    public int getIdUlasan() {
        return idUlasan;
    }

    public int getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(int idPesanan) {
        this.idPesanan = idPesanan;
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }
}