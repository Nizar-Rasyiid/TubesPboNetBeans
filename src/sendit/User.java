package sendit;

class User {
    private static int nextId = 1;
    private int idUser;
    private String nama;
    private String alamat;
    private String nohp;
    private String role;
    private String username;
    private String password;
    private String email;

    public User(String nama, String alamat, String nohp, String role, String username, String password, String email) {
        this.idUser = nextId++;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
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

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}