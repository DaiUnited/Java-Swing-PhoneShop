/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author daiun
 */
public class Account {
    private String Username;
    private String Pass;
    private String MaNV;
    private PhanQuyen phanQuyen;

    public PhanQuyen getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(PhanQuyen phanQuyen) {
        this.phanQuyen = phanQuyen;
    }
    
    public Account() {
    }

    public Account(String Username, String Pass, String MaNV) {
        this.Username = Username;
        this.Pass = Pass;
        this.MaNV = MaNV;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
}
