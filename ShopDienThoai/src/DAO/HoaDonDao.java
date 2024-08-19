package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.HoaDon;

public class HoaDonDao {

    public List<HoaDon> XemThongTin() {
        List<HoaDon> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM HoaDon";

            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list.clear();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setNgayMua(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setNgayLap(rs.getString(5));
                list.add(hd);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int them(HoaDon hd) {
        try {
            String sql = "INSERT INTO HoaDon (MaHD, MaKH, NgayMua, MaNV, NgayLap) VALUES (?, ?, ?, ?, ?)";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, hd.getMaHD());
            pstm.setString(2, hd.getMaKH());
            pstm.setString(3, hd.getNgayMua());
            pstm.setString(4, hd.getMaNV());
            pstm.setString(5, hd.getNgayLap());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int xoa(String mahd) {
        Connection con = null;
        PreparedStatement psmt = null;
        try {
            con = KetNoiCSDL.openConnection();
            String sqlChiTiet = "DELETE FROM CTHoaDon WHERE MaHD=?";
            psmt = con.prepareStatement(sqlChiTiet);
            psmt.setString(1, mahd);
            psmt.executeUpdate();
            String sqlHoaDon = "DELETE FROM HoaDon WHERE MaHD=?";
            psmt = con.prepareStatement(sqlHoaDon);
            psmt.setString(1, mahd);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (psmt != null) psmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }


    public int sua(HoaDon hd) {
        try {
            String sql = "UPDATE HoaDon SET MaKH=?, NgayMua=?, MaNV=?, NgayLap=? WHERE MaHD=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, hd.getMaKH());
            pstm.setString(2, hd.getNgayMua());
            pstm.setString(3, hd.getMaNV());
            pstm.setString(4, hd.getNgayLap());
            pstm.setString(5, hd.getMaHD());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<HoaDon> LoadComboBox() {
        List<HoaDon> list = new ArrayList<>();
    try {
        String sql = "SELECT MaHD FROM HoaDon";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        list.clear();
        while (rs.next()) {
            HoaDon hd = new HoaDon();
            hd.setMaHD(rs.getString("MaHD"));
            list.add(hd);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}