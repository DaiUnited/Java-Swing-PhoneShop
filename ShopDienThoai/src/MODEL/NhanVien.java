/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author daiun
 */
public class NhanVien {
    private String MaNV;
    private String Ho;
    private String Ten;
    private int GioiTinh;
    private String NgaySinh;
    private String CMND;
    private String Email;
    private String DienThoai;
    private String DiaChi;
    private String GhiChu;
    private String MaNhomNV;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String Ho, String Ten, int GioiTinh, String NgaySinh, String CMND, String Email, String DienThoai, String DiaChi, String GhiChu, String MaNhomNV) {
        this.MaNV = MaNV;
        this.Ho = Ho;
        this.Ten = Ten;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.CMND = CMND;
        this.Email = Email;
        this.DienThoai = DienThoai;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
        this.MaNhomNV = MaNhomNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }


    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    public String getMaNhomNV() {
        return MaNhomNV;
    }

    public void setMaNhomNV(String MaNhomNV) {
        this.MaNhomNV = MaNhomNV;
    }
    
    public String GioiTinh()
    {
        if(GioiTinh==1)
            return "Nam";
        else
            return "Nu";
    }  
}
