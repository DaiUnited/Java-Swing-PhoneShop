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
public class PhanQuyen {
    private int BanHang, KhachHang, HangHoa, TonKho, NhanVien, PhanQuyen, DoanhSo, LoiNhuan;
    private String maNhomNV;

    public PhanQuyen() {
    }

    public PhanQuyen(int BanHang, int KhachHang, int HangHoa, int TonKho, int NhanVien, int PhanQuyen, int DoanhSo, int LoiNhuan, String maNhomNV) {
        this.BanHang = BanHang;
        this.KhachHang = KhachHang;
        this.HangHoa = HangHoa;
        this.TonKho = TonKho;
        this.NhanVien = NhanVien;
        this.PhanQuyen = PhanQuyen;
        this.DoanhSo = DoanhSo;
        this.LoiNhuan = LoiNhuan;
        this.maNhomNV = maNhomNV;
    }

    public int getBanHang() {
        return BanHang;
    }

    public void setBanHang(int BanHang) {
        this.BanHang = BanHang;
    }

    public int getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(int KhachHang) {
        this.KhachHang = KhachHang;
    }

    public int getHangHoa() {
        return HangHoa;
    }

    public void setHangHoa(int HangHoa) {
        this.HangHoa = HangHoa;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public int getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(int NhanVien) {
        this.NhanVien = NhanVien;
    }

    public int getPhanQuyen() {
        return PhanQuyen;
    }

    public void setPhanQuyen(int PhanQuyen) {
        this.PhanQuyen = PhanQuyen;
    }

    public int getDoanhSo() {
        return DoanhSo;
    }

    public void setDoanhSo(int DoanhSo) {
        this.DoanhSo = DoanhSo;
    }

    public int getLoiNhuan() {
        return LoiNhuan;
    }

    public void setLoiNhuan(int LoiNhuan) {
        this.LoiNhuan = LoiNhuan;
    }

    public String getMaNhomNV() {
        return maNhomNV;
    }

    public void setMaNhomNV(String maNhomNV) {
        this.maNhomNV = maNhomNV;
    }
    
}
