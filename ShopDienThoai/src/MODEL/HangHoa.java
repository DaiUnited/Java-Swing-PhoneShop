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
public class HangHoa {
    private String MaHang;
    private String TenHang;
    private int MaLoaiHang;
    private int SoLuong;
    private String DVT;
    private int BaoHanh;
    private double GiaNhap;
    private String MoTa;
    private String HinhAnh;
    private String TenLoaiHang;
    public HangHoa() {
    }

    public HangHoa(String MaHang, String TenHang, int MaLoaiHang, int SoLuong, String DVT, int BaoHanh, double GiaNhap, String MoTa, String HinhAnh) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.MaLoaiHang = MaLoaiHang;
        this.SoLuong = SoLuong;
        this.DVT = DVT;
        this.BaoHanh = BaoHanh;
        this.GiaNhap = GiaNhap;
        this.MoTa = MoTa;
        this.HinhAnh = HinhAnh;
        this.TenLoaiHang = TenLoaiHang;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public int getMaLoaiHang() {
        return MaLoaiHang;
    }

    public void setMaLoaiHang(int MaLoaiHang) {
        this.MaLoaiHang = MaLoaiHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getBaoHanh() {
        return BaoHanh;
    }

    public void setBaoHanh(int BaoHanh) {
        this.BaoHanh = BaoHanh;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getTenLoaiHang() {
        return TenLoaiHang;
    }

    public void setTenLoaiHang(String TenLoaiHang) {
        this.TenLoaiHang = TenLoaiHang;
    }
    public double tinhgiatonkho(){
        return SoLuong*GiaNhap;
    }

}
