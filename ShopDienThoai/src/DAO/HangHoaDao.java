/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.HangHoa;
import MODEL.LoaiHang;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author daiun
 */
public class HangHoaDao {
    public List<HangHoa> XemThongTin(){
        List<HangHoa> list = new ArrayList<>();

        try {
            String sql = "SELECT MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap, MoTa, HinhAnh FROM HangHoa";

            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list.clear();
            while (rs.next()) {
                HangHoa hh = new HangHoa();
                hh.setMaHang(rs.getString(1));
                hh.setTenHang(rs.getString(2));
                hh.setMaLoaiHang(rs.getInt(3));
                hh.setSoLuong(rs.getInt(4));
                hh.setDVT(rs.getString(5));
                hh.setBaoHanh(rs.getInt(6));
                hh.setGiaNhap(rs.getDouble(7));
                hh.setMoTa(rs.getString(8));
                hh.setHinhAnh(rs.getString(9));
                list.add(hh);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
  
public int them(HangHoa hh) {
    try {
        String sql = "INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap, MoTa, HinhAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, hh.getMaHang());
        pstm.setString(2, hh.getTenHang());
        pstm.setInt(3, hh.getMaLoaiHang());
        pstm.setInt(4, hh.getSoLuong());
        pstm.setString(5, hh.getDVT());
        pstm.setInt(6, hh.getBaoHanh());
        pstm.setDouble(7, hh.getGiaNhap());
        pstm.setString(8, hh.getMoTa());
        pstm.setString(9, hh.getHinhAnh());
        return pstm.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

public int xoa(String maHang) {
    try {
        String sql = "DELETE FROM HangHoa WHERE MaHang=?";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, maHang);
        return psmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

public int sua(HangHoa hh) {
    try {
        String sql = "UPDATE HangHoa SET TenHang=?, MaLoaiHang=?, SoLuong=?, DVT=?, BaoHanh=?, GiaNhap=?, MoTa=?, HinhAnh=? WHERE MaHang=?";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, hh.getTenHang());
        pstm.setInt(2, hh.getMaLoaiHang());
        pstm.setInt(3, hh.getSoLuong());
        pstm.setString(4, hh.getDVT());
        pstm.setInt(5, hh.getBaoHanh());
        pstm.setDouble(6, hh.getGiaNhap());
        pstm.setString(7, hh.getMoTa());
        pstm.setString(8, hh.getHinhAnh());
        pstm.setString(9, hh.getMaHang());
        return pstm.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}
    public List<HangHoa> TimTheoTen(String TenHang) {
        List<HangHoa> list = new ArrayList<>();
        try {
            String sql = "SELECT MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap, MoTa, HinhAnh FROM HangHoa WHERE TenHang LIKE ?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%" + TenHang + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HangHoa hh = new HangHoa();
                hh.setMaHang(rs.getString(1));
                hh.setTenHang(rs.getString(2));
                hh.setMaLoaiHang(rs.getInt(3));
                hh.setSoLuong(rs.getInt(4));
                hh.setDVT(rs.getString(5));
                hh.setBaoHanh(rs.getInt(6));
                hh.setGiaNhap(rs.getDouble(7));
                hh.setMoTa(rs.getString(8));
                hh.setHinhAnh(rs.getString(9));
                list.add(hh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<HangHoa> LoadComboBox() {
    List<HangHoa> list = new ArrayList<>();
    try {
        String sql = "SELECT MaHang FROM HangHoa";

        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        list.clear();
        while (rs.next()) {
            HangHoa th = new HangHoa();
            th.setMaHang(rs.getString("MaHang"));
            list.add(th);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}
