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
public class NhomNV {
    private String MaNhomNV,TenNhomNV;

    public NhomNV() {
    }

    public NhomNV(String MaNhomNV, String TenNhomNV) {
        this.MaNhomNV = MaNhomNV;
        this.TenNhomNV = TenNhomNV;
    }

    public String getMaNhomNV() {
        return MaNhomNV;
    }

    public void setMaNhomNV(String MaNhomNV) {
        this.MaNhomNV = MaNhomNV;
    }

    public String getTenNhomNV() {
        return TenNhomNV;
    }

    public void setTenNhomNV(String TenNhomNV) {
        this.TenNhomNV = TenNhomNV;
    }
    
}
