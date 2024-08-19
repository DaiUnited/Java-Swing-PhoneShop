/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author daiun
 */
public class DoanhSo {
    private String NgayMua;
    private double TongTien;
    private int SoLuong;

    public DoanhSo() {
    }

    public DoanhSo(String NgayMua, double TongTien, int SoLuong) {
        this.NgayMua = NgayMua;
        this.TongTien = TongTien;
        this.SoLuong = SoLuong;
    }
    

    public String getNgayMua() {
        return NgayMua;
    }

    public double getTongTien() {
        return TongTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }
    
}
