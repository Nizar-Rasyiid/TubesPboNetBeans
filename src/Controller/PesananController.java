package Controller;

import Model.Pesanan.PesananModel;
import View.Payment.Payment;
import View.Pesanan.Pesanan;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import JDBC.sqlconnection;

public class PesananController {
    private final Pesanan view;

    public PesananController(Pesanan view) {
        this.view = view;
    }

    public void handleKirimButton(ActionEvent evt) {
        String idUser = view.getIdUser();
        if (idUser == null) {
            JOptionPane.showMessageDialog(view, "User not logged in", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double harga = 0;
        String jarak = view.getJarak();
        if (null == jarak) {
            JOptionPane.showMessageDialog(view, "Opsi tidak valid.");
            return;
        } else switch (jarak) {
            case "1-2km":
                harga = 8000;
                break;
            case "2-5km":
                harga = 12000;
                break;
            case ">5km":
                harga = 25000;
                break;
            default:
                JOptionPane.showMessageDialog(view, "Opsi tidak valid.");
                return;
        }

        String titikJemput = view.getTitikJemput();
        String titikAntar = view.getTitikAntar();
        String status = "On Progress";
        String namaPenerima = view.getNamaPenerima();

        String sqlKurirQuery = "SELECT id_user FROM user WHERE role = 'Kurir' ORDER BY RAND() LIMIT 1";
        String sqlQuery = "INSERT INTO pemesanan (id_pengguna, id_kurir, jarak, lokasi_jemput, lokasi_tujuan, status, nama_penerima) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = sqlconnection.connectdb();
             PreparedStatement pstKurir = conn.prepareStatement(sqlKurirQuery);
             PreparedStatement pst = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            ResultSet rsKurir = pstKurir.executeQuery();
            if (!rsKurir.next()) {
                JOptionPane.showMessageDialog(view, "Tidak ada kurir yang tersedia", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String idKurir = rsKurir.getString("id_user");

            pst.setString(1, idUser);
            pst.setString(2, idKurir);
            pst.setString(3, jarak);
            pst.setString(4, titikJemput);
            pst.setString(5, titikAntar);
            pst.setString(6, status);
            pst.setString(7, namaPenerima);

            int rowsAffected = pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int idPemesanan = rs.getInt(1);
                PesananModel pesanan = new PesananModel(idPemesanan, idUser, jarak, titikJemput, titikAntar, status, namaPenerima, harga,idKurir);

                // Pindah ke halaman pembayaran dan kirimkan objek Pesanan
                Payment pembayaranPage = new Payment(pesanan);
                pembayaranPage.setVisible(true);
                view.dispose();
            }

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(view, "Pendaftaran berhasil!");
            } else {
                JOptionPane.showMessageDialog(view, "Pendaftaran gagal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
