package sendit;

class Pesanan {
    private static int nextId = 1;
    private int idPesanan;
    private String alamatPengirim;
    private String namaPengirim;
    private String nohpPengirim;
    private String jenisBarang;
    private String namaBarang;

    public Pesanan(String alamatPengirim, String namaPengirim, String nohpPengirim, String jenisBarang, String namaBarang) {
        this.idPesanan = nextId++;
        this.alamatPengirim = alamatPengirim;
        this.namaPengirim = namaPengirim;
        this.nohpPengirim = nohpPengirim;
        this.jenisBarang = jenisBarang;
        this.namaBarang = namaBarang;
    }

    public int getIdPesanan() {
        return idPesanan;
    }

    public String getAlamatPengirim() {
        return alamatPengirim;
    }

    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public String getNohpPengirim() {
        return nohpPengirim;
    }

    public void setNohpPengirim(String nohpPengirim) {
        this.nohpPengirim = nohpPengirim;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
}