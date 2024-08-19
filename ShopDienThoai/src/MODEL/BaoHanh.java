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
public class BaoHanh {
     private String MaKH;
    private String TenHang;
    private String SoIMEI;
    private String MoTaLoi;
    private String NgayHenTra;
    private String GhiChu;
    private double Gia;

    public BaoHanh() {
    }

    public BaoHanh(String MaKH, String TenHang, String SoIMEI, String MoTaLoi, String NgayHenTra, String GhiChu, double Gia) {
        this.MaKH = MaKH;
        this.TenHang = TenHang;
        this.SoIMEI = SoIMEI;
        this.MoTaLoi = MoTaLoi;
        this.NgayHenTra = NgayHenTra;
        this.GhiChu = GhiChu;
        this.Gia = Gia;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getSoIMEI() {
        return SoIMEI;
    }

    public void setSoIMEI(String SoIMEI) {
        this.SoIMEI = SoIMEI;
    }

    public String getMoTaLoi() {
        return MoTaLoi;
    }

    public void setMoTaLoi(String MoTaLoi) {
        this.MoTaLoi = MoTaLoi;
    }

    public String getNgayHenTra() {
        return NgayHenTra;
    }

    public void setNgayHenTra(String NgayHenTra) {
        this.NgayHenTra = NgayHenTra;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    
}
