package Model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import JDBC.sqlconnection;

public class CashPayment extends PaymentMethod {

    public CashPayment(String id_user, double harga, int id_pemesanan) {
        super(id_user, harga, id_pemesanan);
    }

    @Override
    public void processPayment() {
        String sqlQuery = "INSERT INTO payment (metode_pembayaran, id_user, harga, id_pemesanan) VALUES ('Cash', ?, ?, ?)";
        try (Connection conn = sqlconnection.connectdb();
             PreparedStatement pst = conn.prepareStatement(sqlQuery)) {
            pst.setString(1, id_user);
            pst.setDouble(2, harga);
            pst.setInt(3, id_pemesanan);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Pembayaran Cash berhasil!");
            } else {
                JOptionPane.showMessageDialog(null, "Pembayaran Cash gagal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
