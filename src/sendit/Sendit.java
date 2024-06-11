package sendit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Sendit extends Application {
    private List<User> users;
    private List<Pesanan> pesananList;
    private List<Pembayaran> pembayaranList;
    private List<Ulasan> ulasanList;

    @Override
    public void start(Stage primaryStage) {
        users = new ArrayList<>();
        pesananList = new ArrayList<>();
        pembayaranList = new ArrayList<>();
        ulasanList = new ArrayList<>();

        primaryStage.setTitle("Sendit - Aplikasi Pengiriman Barang");
        // Dummy data
        users.add(new User("John Doe", "Jl. Merdeka No. 123", "08123456789", "pengirim", "pengirim", "pengirim", "john.doe@example.com"));
        users.add(new User("Jane Doe", "Jl. Jenderal Sudirman No. 456", "087654321", "kurir", "kurir", "kurir", "jane.doe@example.com"));
        // Tampilkan halaman login
        tampilkanHalamanLogin(primaryStage);
    }

    private void tampilkanHalamanLogin(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 0);

        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 0);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 1);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        grid.add(hbBtn, 1, 2);

        Label messageLabel = new Label();
        grid.add(messageLabel, 1, 3);

        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            User user = login(username, password);
            if (user != null) {
                tampilkanHalamanUtama(primaryStage, user);
            } else {
                messageLabel.setText("Invalid username or password");
            }
        });

        primaryStage.show();
    }

    private User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private void tampilkanHalamanUtama(Stage primaryStage, User user) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        Button pesananButton = new Button("Pemesanan");
        Button ulasanButton = new Button("Ulasan");
        Button pembayaranButton = new Button("Pembayaran");

        vbox.getChildren().addAll(pesananButton, ulasanButton, pembayaranButton);

        Scene scene = new Scene(vbox, 400, 275);
        primaryStage.setScene(scene);

        pesananButton.setOnAction(event -> tampilkanHalamanPemesanan(primaryStage, user));
        ulasanButton.setOnAction(event -> tampilkanHalamanUlasan(primaryStage, user));
        pembayaranButton.setOnAction(event -> tampilkanHalamanPembayaran(primaryStage, user));
    }

    private void tampilkanHalamanPemesanan(Stage primaryStage, User user) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label alamatLabel = new Label("Alamat Pengirim:");
        grid.add(alamatLabel, 0, 0);

        TextField alamatField = new TextField();
        grid.add(alamatField, 1, 0);

        Label namaLabel = new Label("Nama Pengirim:");
        grid.add(namaLabel, 0, 1);

        TextField namaField = new TextField();
        grid.add(namaField, 1, 1);

        Label nohpLabel = new Label("No. HP Pengirim:");
        grid.add(nohpLabel, 0, 2);

        TextField nohpField = new TextField();
        grid.add(nohpField, 1, 2);

        Label jenisBarangLabel = new Label("Jenis Barang:");
        grid.add(jenisBarangLabel, 0, 3);

        TextField jenisBarangField = new TextField();
        grid.add(jenisBarangField, 1, 3);

        Label namaBarangLabel = new Label("Nama Barang:");
        grid.add(namaBarangLabel, 0, 4);

        TextField namaBarangField = new TextField();
        grid.add(namaBarangField, 1, 4);

        Button pesanButton = new Button("Pesan");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(pesanButton);
        grid.add(hbBtn, 1, 5);

        pesanButton.setOnAction(event -> {
            String alamat = alamatField.getText();
            String nama = namaField.getText();
            String nohp = nohpField.getText();
            String jenisBarang = jenisBarangField.getText();
            String namaBarang = namaBarangField.getText();
            Pesanan pesanan = new Pesanan(alamat, nama, nohp, jenisBarang, namaBarang);
            pesananList.add(pesanan);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("Pemesanan berhasil!");
            alert.showAndWait();
        });

        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);
    }

    private void tampilkanHalamanPembayaran(Stage primaryStage, User user) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        Label metodeLabel = new Label("Metode Pembayaran:");
        ComboBox<String> metodeComboBox = new ComboBox<>();
        metodeComboBox.getItems().addAll("QRIS", "Bank", "Cash");
        metodeComboBox.setValue("QRIS");
        vbox.getChildren().addAll(metodeLabel, metodeComboBox);

        Label totalLabel = new Label("Total Pembayaran:");
        TextField totalField = new TextField();
        vbox.getChildren().addAll(totalLabel, totalField);

        Button bayarButton = new Button("Bayar");
        vbox.getChildren().add(bayarButton);

        bayarButton.setOnAction(event -> {
            String metode = metodeComboBox.getValue();
            double total = Double.parseDouble(totalField.getText());
            Pembayaran pembayaran = new Pembayaran(metode, total);
            pembayaranList.add(pembayaran);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("Pembayaran berhasil!");
            alert.showAndWait();
        });

        Scene scene = new Scene(vbox, 400, 275);
        primaryStage.setScene(scene);
    }

    private void tampilkanHalamanUlasan(Stage primaryStage, User user) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        Label ulasanLabel = new Label("Ulasan:");
        TextArea ulasanArea = new TextArea();
        ulasanArea.setPrefSize(300, 200);

        Button kirimButton = new Button("Kirim Ulasan");
        vbox.getChildren().addAll(ulasanLabel, ulasanArea, kirimButton);

        kirimButton.setOnAction(event -> {
            String ulasanText = ulasanArea.getText();
            if (!ulasanText.isEmpty()) {
                Ulasan ulasan = new Ulasan(0, ulasanText); // ID pesanan belum tersedia
                ulasanList.add(ulasan);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Info");
                alert.setHeaderText(null);
                alert.setContentText("Ulasan berhasil dikirim!");
                alert.showAndWait();
                ulasanArea.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Isi ulasan tidak boleh kosong!");
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(vbox, 400, 275);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

