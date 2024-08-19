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
import MODEL.KhachHang;

public class KhachHangDao {

    public List<KhachHang> XemThongTin() {
        List<KhachHang> list = new ArrayList<>();

        try {
            String sql = "SELECT MaKH, HoKH, TenKH, GioiTinh, CMND, DienThoai, DiaChi FROM KhachHang";

            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list.clear();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoKH(rs.getString(2));
                kh.setTenKH(rs.getString(3));
                kh.setGioiTinh(rs.getInt(4));
                kh.setCMND(rs.getString(5));
                kh.setDienThoai(rs.getString(6));
                kh.setDiaChi(rs.getString(7));
                list.add(kh);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int them(KhachHang kh) {
        try {
            String sql = "INSERT INTO KhachHang (MaKH, HoKH, TenKH, GioiTinh, CMND, DienThoai, DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, kh.getMaKH());
            pstm.setString(2, kh.getHoKH());
            pstm.setString(3, kh.getTenKH());
            pstm.setInt(4, kh.getGioiTinh());
            pstm.setString(5, kh.getCMND());
            pstm.setString(6, kh.getDienThoai());
            pstm.setString(7, kh.getDiaChi());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int xoa(String maKH) {
        try {
            String sql = "DELETE FROM KhachHang WHERE MaKH=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, maKH);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int sua(KhachHang kh) {
        try {
            String sql = "UPDATE KhachHang SET HoKH=?, TenKH=?, GioiTinh=?, CMND=?, DienThoai=?, DiaChi=? WHERE MaKH=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, kh.getHoKH());
            pstm.setString(2, kh.getTenKH());
            pstm.setInt(3, kh.getGioiTinh());
            pstm.setString(4, kh.getCMND());
            pstm.setString(5, kh.getDienThoai());
            pstm.setString(6, kh.getDiaChi());
            pstm.setString(7, kh.getMaKH());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public List<KhachHang> TimTheoMa(String MaKH) {
        List<KhachHang> list = new ArrayList<>();
        try {
            String sql = "SELECT MaKH, HoKH, TenKH, GioiTinh, CMND, DienThoai, DiaChi FROM KhachHang WHERE MaKH=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, MaKH);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoKH(rs.getString(2));
                kh.setTenKH(rs.getString(3));
                kh.setGioiTinh(rs.getInt(4));
                kh.setCMND(rs.getString(5));
                kh.setDienThoai(rs.getString(6));
                kh.setDiaChi(rs.getString(7));
                list.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<KhachHang> LoadComboBox() {
    List<KhachHang> list = new ArrayList<>();
    try {
        String sql = "SELECT MaKH FROM KhachHang";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        list.clear();
        while (rs.next()) {
            KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("MaKH"));
            list.add(kh);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}

