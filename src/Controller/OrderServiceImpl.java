package Controller;

import Model.Auth.Authentication;
import Model.Pesanan.OrderService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private Connection connection;
    private String loggedInUserId;

    public OrderServiceImpl(Connection connection) {
        this.connection = connection;
    }



    @Override
    public void updateOrderStatus(String orderId, String newStatus) throws SQLException {
        String query = "UPDATE pemesanan SET status = ? WHERE id_pemesanan = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newStatus);
            statement.setString(2, orderId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<String> getOrders() throws SQLException {
        List<String> orders = new ArrayList<>();
        loggedInUserId = Authentication.getLoggedInUserId();
        String query = "SELECT p.id_pemesanan, p.id_pengguna, p.jarak, p.lokasi_jemput,p.lokasi_tujuan, p.status, pengguna.nama AS pengguna_nama, pengguna.no_hp AS pengguna_no_hp, p.nama_penerima FROM pemesanan p JOIN user pengguna ON p.id_pengguna = pengguna.id_user JOIN user kurir ON p.id_kurir = kurir.id_user WHERE p.status != 'Sudah Diterima' AND p.id_kurir =?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, loggedInUserId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String orderDetails = "ID: " + resultSet.getString("id_pemesanan") +
                            ", Nama Pengirim: " + resultSet.getString("pengguna_nama") +
                            ", Jarak: " + resultSet.getString("jarak") +
                            ", Nomor Telepon Pengirim: " + resultSet.getString("pengguna_no_hp") +
                            ", Jemput: " + resultSet.getString("lokasi_jemput") +
                            ", Tujuan: " + resultSet.getString("lokasi_tujuan") +
                            ", Status: " + resultSet.getString("status") +
                            ", Penerima: " + resultSet.getString("nama_penerima");
                    orders.add(orderDetails);
                }
            }
        }
        return orders;
    }
}
