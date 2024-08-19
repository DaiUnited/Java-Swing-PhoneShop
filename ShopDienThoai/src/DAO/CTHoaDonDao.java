package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.CTHoaDon;
/**
 *
 * @author daiun
 */
public class CTHoaDonDao {
    public List<CTHoaDon> XemThongTin(){
        List<CTHoaDon> list = new ArrayList<>();

        try {
            String sql = "SELECT MaHD, MaHang, SoLuong, DonGia, GiamGia FROM CTHoaDon";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list.clear();
            while (rs.next()) {
                CTHoaDon hd = new CTHoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaHang(rs.getString(2));
                hd.setSoLuong(rs.getInt(3));
                hd.setDonGia(rs.getDouble(4));
                hd.setGiamGia(rs.getDouble(5));
                list.add(hd);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(CTHoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
  
public int them(CTHoaDon hd) {
    try {
        String sql = "INSERT INTO CTHoaDon (MaHD, MaHang, SoLuong, DonGia, GiamGia) VALUES (?, ?, ?, ?, ?)";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, hd.getMaHD());
        pstm.setString(2, hd.getMaHang());
        pstm.setInt(3, hd.getSoLuong());
        pstm.setDouble(4, hd.getDonGia());
        pstm.setDouble(5, hd.getGiamGia());
        return pstm.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(CTHoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

public int xoa(String mahd) {
    try {
        String sql = "DELETE FROM CTHoaDon WHERE MaHD=?";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, mahd);
        return psmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(HangHoaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

public int sua(CTHoaDon hd) {
    try {
        String sql = "UPDATE CTHoaDon SET MaHang=?, SoLuong=?, DonGia=?, GiamGia=? WHERE MaHD=?";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, hd.getMaHang());
        pstm.setInt(2, hd.getSoLuong());
        pstm.setDouble(3, hd.getDonGia());
        pstm.setDouble(4, hd.getGiamGia());
        pstm.setString(5, hd.getMaHD());
        return pstm.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(CTHoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

} 