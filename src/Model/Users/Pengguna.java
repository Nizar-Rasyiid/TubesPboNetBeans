package Model.Users;

public class Pengguna extends User{
    private int idPengguna;
    public Pengguna(String nama,String alamat,String noHp,String username,String password,String role) {
        super(nama, alamat, noHp, username, password, role);
        this.idPengguna = idPengguna;
    }
}
