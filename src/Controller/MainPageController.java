package Controller;
import JDBC.sqlconnection;
import Model.Auth.Authentication;
import View.MainPage.MainPage;
import View.Pesanan.Pesanan;
import View.Profile.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainPageController {
    private MainPage mainPage;

    public  MainPageController(MainPage mainPage){
        this.mainPage = mainPage;
    }

    public void goToProfile(ActionEvent evt){
        Profile pr = new Profile();
        pr.setVisible(true);
        mainPage.dispose();
    }

    public void goToPesanan(ActionEvent evt){
        Pesanan order = new Pesanan();
        order.setVisible(true);
        mainPage.dispose();
    }

    public void checkStatus(ActionEvent evt){
        String id_pelanggan = Authentication.getLoggedInUserId(); // Mendapatkan ID pelanggan dari autentikasi

        if (id_pelanggan == null) {
            JOptionPane.showMessageDialog(mainPage, "User not logged in", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menggunakan placeholder "?" untuk id_pelanggan
        String sqlQuery = "SELECT p.id_pemesanan, p.id_pengguna, p.lokasi_tujuan, p.status, pm.harga, u1.nama AS nama_pelanggan, u2.nama AS nama_kurir, u2.no_hp AS no_hp_kurir " +
                "FROM pemesanan p " +
                "JOIN payment pm USING(id_pemesanan) " +
                "JOIN user u1 ON p.id_pengguna = u1.id_user " +
                "JOIN user u2 ON p.id_kurir = u2.id_user " +
                "WHERE p.id_pengguna = ?";

        try (Connection conn = sqlconnection.connectdb();
             PreparedStatement pst = conn.prepareStatement(sqlQuery)) {

            pst.setString(1, id_pelanggan); // Mengatur nilai parameter

            // Eksekusi query
            try (ResultSet rs = pst.executeQuery()) {
                // Membuat string untuk menyimpan status pesanan
                StringBuilder statusMessage = new StringBuilder();
                statusMessage.append("Status Pesanan:\n");

                // Loop melalui hasil query dan menambahkan status pesanan ke dalam string
                while (rs.next()) {
                    int id_pemesanan = rs.getInt("id_pemesanan");
                    String status = rs.getString("status");
                    String titik_tujuan = rs.getString("lokasi_tujuan");
                    double harga = rs.getDouble("harga");
                    String nama_kurir = rs.getString("nama_kurir");
                    String no_hp_kurir = rs.getString("no_hp_kurir");

                    statusMessage.append("ID Pesanan: ").append(id_pemesanan).append("\n")
                            .append("Status: ").append(status).append("\n")
                            .append("Tujuan: ").append(titik_tujuan).append("\n")
                            .append("Harga: ").append(harga).append("\n")
                            .append("Nama Kurir: ").append(nama_kurir).append("\n")
                            .append("No HP Kurir: ").append(no_hp_kurir).append("\n\n");
                }

                // Menampilkan status pesanan dalam dialog pesan
                JOptionPane.showMessageDialog(mainPage, statusMessage.toString());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mainPage, "Error fetching order status: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
