/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author daiun
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.NhanVien;

public class NhanVienDao {

    public List<NhanVien> XemThongTin() {
        List<NhanVien> list = new ArrayList<>();

        try {
            String sql = "SELECT MaNV, HoNV, TenNV, GioiTinh, NgaySinh, CMND, Email, DienThoai, DiaChi, GhiChu, MaNhomNV FROM NhanVien";

            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list.clear();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setNgaySinh(rs.getString(5));
                nv.setCMND(rs.getString(6));
                nv.setEmail(rs.getString(7));
                nv.setDienThoai(rs.getString(8));
                nv.setDiaChi(rs.getString(9));
                nv.setGhiChu(rs.getString(10));
                nv.setMaNhomNV(rs.getString(11));
                list.add(nv);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int them(NhanVien nv) {
        try {
            String sql = "INSERT INTO NhanVien (MaNV, HoNV, TenNV, GioiTinh, NgaySinh, CMND, Email, DienThoai, DiaChi, GhiChu, MaNhomNV) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nv.getMaNV());
            pstm.setString(2, nv.getHo());
            pstm.setString(3, nv.getTen());
            pstm.setInt(4, nv.getGioiTinh());
            pstm.setString(5, nv.getNgaySinh());
            pstm.setString(6, nv.getCMND());
            pstm.setString(7, nv.getEmail());
            pstm.setString(8, nv.getDienThoai());
            pstm.setString(9, nv.getDiaChi());
            pstm.setString(10, nv.getGhiChu());
            pstm.setString(11, nv.getMaNhomNV());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int xoa(String maNV) {
        try {
            String sql = "DELETE FROM NhanVien WHERE MaNV=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, maNV);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int sua(NhanVien nv) {
        try {
            String sql = "UPDATE NhanVien SET HoNV=?, TenNV=?, GioiTinh=?, NgaySinh=?, CMND=?, Email=?, DienThoai=?, DiaChi=?, GhiChu=?, MaNhomNV=? WHERE MaNV=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nv.getHo());
            pstm.setString(2, nv.getTen());
            pstm.setInt(3, nv.getGioiTinh());
            pstm.setString(4, nv.getNgaySinh());
            pstm.setString(5, nv.getCMND());
            pstm.setString(6, nv.getEmail());
            pstm.setString(7, nv.getDienThoai());
            pstm.setString(8, nv.getDiaChi());
            pstm.setString(9, nv.getGhiChu());
            pstm.setString(10, nv.getMaNhomNV());
            pstm.setString(11, nv.getMaNV());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public List<NhanVien> TimTheoMa(String MaNV) {
        List<NhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT MaNV, HoNV, TenNV, GioiTinh, NgaySinh, CMND, Email, DienThoai, DiaChi, GhiChu, MaNhomNV FROM NhanVien WHERE MaNV=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,MaNV);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setNgaySinh(rs.getString(5));
                nv.setCMND(rs.getString(6));
                nv.setEmail(rs.getString(7));
                nv.setDienThoai(rs.getString(8));
                nv.setDiaChi(rs.getString(9));
                nv.setGhiChu(rs.getString(10));
                nv.setMaNhomNV(rs.getString(11));
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<NhanVien> LoadComboBox() {
    List<NhanVien> list = new ArrayList<>();
    try {
        String sql = "SELECT MaNV FROM NhanVien WHERE MaNhomNV = '01' OR MaNhomNV = '02' ";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        list.clear();
        while (rs.next()) {
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getString("MaNV"));
            list.add(nv);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}

