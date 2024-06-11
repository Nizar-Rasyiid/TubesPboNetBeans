package Model.Auth;
import JDBC.sqlconnection;
import Model.Users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationManager {
    private Connection connection;


    public boolean registerUser(User user) {
        String insertQuery = "INSERT INTO user (nama, alamat, no_hp, username, role, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = sqlconnection.connectdb();
             PreparedStatement pst = conn.prepareStatement(insertQuery)) {

            pst.setString(1, user.getNama());
            pst.setString(2, user.getAlamat());
            pst.setString(3, user.getNoHp());
            pst.setString(4, user.getUsername());
            pst.setString(5, user.getRole());
            pst.setString(6, user.getPassword());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
