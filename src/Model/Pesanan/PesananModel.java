package Model.Pesanan;

public class PesananModel {
    private int idPemesanan;
    private String idUser;
    private String jarak;
    private String titikJemput;
    private String titikAntar;
    private String status;
    private String namaPenerima;
    private double harga;

    private String id_kurir;

    public PesananModel(int idPemesanan, String idUser, String jarak, String titikJemput, String titikAntar, String status, String namaPenerima, double harga,String id_kurir) {
        this.idPemesanan = idPemesanan;
        this.idUser = idUser;
        this.jarak = jarak;
        this.titikJemput = titikJemput;
        this.titikAntar = titikAntar;
        this.status = status;
        this.namaPenerima = namaPenerima;
        this.harga = harga;
        this.id_kurir = id_kurir;
    }

    public int getIdPemesanan() {
        return idPemesanan;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getJarak() {
        return jarak;
    }

    public String getTitikJemput() {
        return titikJemput;
    }

    public String getTitikAntar() {
        return titikAntar;
    }

    public String getStatus() {
        return status;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public double getHarga() {
        return harga;
    }
}
