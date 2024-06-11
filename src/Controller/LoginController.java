package Controller;

import Model.Auth.Authentication;
import Model.Auth.LoginService;
import java.sql.Connection;

public class LoginController {
    private final LoginService loginService;

    public LoginController(Connection connection, String username, String password) {
        this.loginService = new LoginService(connection, username, password);
    }

    public boolean authenticate() {
        return loginService.Authenticate();
    }

    public String getUserRole() {
        return Authentication.getLoggedInUserRole();
    }
}
