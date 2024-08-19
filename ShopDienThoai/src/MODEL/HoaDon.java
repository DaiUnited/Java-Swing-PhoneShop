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
public class HoaDon {
    private String MaHD;
    private String MaKH;
    private String NgayMua;
    private String MaNV;
    private String NgayLap;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaKH, String NgayMua, String MaNV, String NgayLap) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.NgayMua = NgayMua;
        this.MaNV = MaNV;
        this.NgayLap = NgayLap;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }
   
    
}
