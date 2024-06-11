package Model.Users;

public class User {
    private int idUser;
    private String nama;
    private String alamat;
    private String noHp;
    private String username;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }
    public User(String nama,String alamat,String noHp,String username,String password,String role){
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
       this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
