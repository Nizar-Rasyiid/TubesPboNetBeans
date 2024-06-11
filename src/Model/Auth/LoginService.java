package Model.Auth;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService extends Login {
    private Connection connection;

    public LoginService(Connection connection, String username, String password) {
        super(username, password);
        this.connection = connection;
    }

    @Override
    public boolean Authenticate() {
        String query = "SELECT id_user, role FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, getUsername());
            statement.setString(2, getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String id_user = resultSet.getString("id_user");
                String role = resultSet.getString("role");
                Authentication.setLoggedInUserId(id_user);
                Authentication.setLoggedInUsername(getUsername());
                Authentication.setLoggedInUserRole(role);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
