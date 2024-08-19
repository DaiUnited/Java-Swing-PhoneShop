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
public class KhachHang {
    private String MaKH;
    private String HoKH;
    private String TenKH;
    private int GioiTinh;
    private String CMND;
    private String DienThoai;
    private String DiaChi;
    private String GhiChu;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String HoKH, String TenKH, int GioiTinh, String CMND, String DienThoai, String DiaChi, String GhiChu) {
        this.MaKH = MaKH;
        this.HoKH = HoKH;
        this.TenKH = TenKH;
        this.GioiTinh = GioiTinh;
        this.CMND = CMND;
        this.DienThoai = DienThoai;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoKH() {
        return HoKH;
    }

    public void setHoKH(String HoKH) {
        this.HoKH = HoKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    public String GioiTinh()
    {
        if(GioiTinh==1)
            return "Nam";
        else
            return "Nu";
    }
}
