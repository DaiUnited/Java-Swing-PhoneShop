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
public class CTHoaDon {
    private String MaHD;
    private String MaHang;
    private int SoLuong;
    private double DonGia;
    private double GiamGia;

    public CTHoaDon() {
    }

    public CTHoaDon(String MaHD, String MaHang, int SoLuong, double DonGia, double GiamGia) {
        this.MaHD = MaHD;
        this.MaHang = MaHang;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(double GiamGia) {
        this.GiamGia = GiamGia;
    }

    public double ThanhTien()
    {
        return SoLuong*DonGia - (SoLuong*DonGia)*GiamGia/100;
    }
}
