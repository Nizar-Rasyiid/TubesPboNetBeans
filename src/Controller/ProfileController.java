package Controller;

import JDBC.sqlconnection;
import Model.Auth.Authentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileController {
    private Connection conn;

    public ProfileController() {
        conn = sqlconnection.connectdb();
    }

    public UserProfile getUserProfile() {
        String loggedInUsername = Authentication.getLoggedInUsername();
        if (loggedInUsername == null || loggedInUsername.isEmpty()) {
            return null;
        }

        String query = "SELECT * FROM user WHERE username = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, loggedInUsername);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new UserProfile(
                            rs.getString("username"),
                            rs.getString("nama"),
                            rs.getString("alamat"),
                            rs.getString("no_hp"),
                            rs.getString("password")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean updateUsername(String newUsername) {
        return updateUserField("username", newUsername);
    }

    public boolean updateNama(String newNama) {
        return updateUserField("nama", newNama);
    }

    public boolean updateAlamat(String newAlamat) {
        return updateUserField("alamat", newAlamat);
    }

    public boolean updateNoHp(String newNoHp) {
        return updateUserField("no_hp", newNoHp);
    }

    public boolean updatePassword(String newPassword) {
        return updateUserField("password", newPassword);
    }

    private boolean updateUserField(String field, String newValue) {
        String loggedInUsername = Authentication.getLoggedInUsername();
        if (loggedInUsername == null || loggedInUsername.isEmpty() || newValue == null || newValue.trim().isEmpty()) {
            return false;
        }

        String updateQuery = "UPDATE user SET " + field + " = ? WHERE username = ?";
        try (PreparedStatement pst = conn.prepareStatement(updateQuery)) {
            pst.setString(1, newValue);
            pst.setString(2, loggedInUsername);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static class UserProfile {
        private String username;
        private String nama;
        private String alamat;
        private String noHp;
        private String password;

        public UserProfile(String username, String nama, String alamat, String noHp, String password) {
            this.username = username;
            this.nama = nama;
            this.alamat = alamat;
            this.noHp = noHp;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getNama() {
            return nama;
        }

        public String getAlamat() {
            return alamat;
        }

        public String getNoHp() {
            return noHp;
        }

        public String getPassword() {
            return password;
        }
    }
}
