/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author thanhtung
 */
public class LoaiHang {
    private int MaLoaiHang;
    private String tenLoaiHang;

    public LoaiHang() {
    }

    public LoaiHang(int MaLoaiHang, String tenLoaiHang) {
        this.MaLoaiHang = MaLoaiHang;
        this.tenLoaiHang = tenLoaiHang;
    }

    public int getMaLoaiHang() {
        return MaLoaiHang;
    }

    public void setMaLoaiHang(int MaLoaiHang) {
        this.MaLoaiHang = MaLoaiHang;
    }

    public String getTenLoaiHang() {
        return tenLoaiHang;
    }

    public void setTenLoaiHang(String tenLoaiHang) {
        this.tenLoaiHang = tenLoaiHang;
    }
    
}
