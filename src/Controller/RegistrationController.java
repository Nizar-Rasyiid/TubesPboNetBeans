package Controller;

import Model.Users.User;
import Model.Auth.RegistrationManager;
import View.Register.Register;
import View.Login.Login;

public class RegistrationController {
    private RegistrationManager userDAO;
    private Register registerView;

    public RegistrationController(RegistrationManager userDAO, Register registerView) {
        this.userDAO = userDAO;
        this.registerView = registerView;

        this.registerView.addRegisterListener(e -> registerUser(userDAO,registerView));
        this.registerView.addLoginListener(e -> openLogin());
    }

    public static void registerUser(RegistrationManager userDAO, Register registerView) {
        String nama = registerView.getNama();
        String username = registerView.getUsername();
        String noHp = registerView.getNoHp();
        String alamat = registerView.getAlamat();
        String password = registerView.getPassword();
        String role = registerView.getRole();

        if (nama.isEmpty() || username.isEmpty() || noHp.isEmpty() || alamat.isEmpty() || password.isEmpty() || role.isEmpty()) {
            registerView.showMessage("Please fill all fields");
            return;
        }

        User user = new User(nama, alamat, noHp, username, password, role);

        boolean success = userDAO.registerUser(user);
        if (success) {
            registerView.showMessage("Registration successful!");
        } else {
            registerView.showMessage("Registration failed");
        }
    }

    private void openLogin() {
        Login login = new Login();
        login.display();
        registerView.dispose();
    }
}
