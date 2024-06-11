package sendit;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

public class SenditUIController {
    private List<User> users;
    private List<Pesanan> pesananList;
    private List<Pembayaran> pembayaranList;
    private List<Ulasan> ulasanList;

    public SenditUIController() {
        users = new ArrayList<>();
        pesananList = new ArrayList<>();
        pembayaranList = new ArrayList<>();
        ulasanList = new ArrayList<>();
    }

    @FXML
    private void tampilkanHalamanPemesanan() {
        // Implementasi tampilan halaman pemesanan
    }

    @FXML
    private void tampilkanHalamanUlasan() {
        // Implementasi tampilan halaman ulasan
    }

    @FXML
    private void tampilkanHalamanPembayaran() {
        // Implementasi tampilan halaman pembayaran
    }
}
