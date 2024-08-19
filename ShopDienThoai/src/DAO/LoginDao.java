/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import MODEL.Account;
import MODEL.PhanQuyen;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author daiun
 */

public class LoginDao {
    private static Account currentAccount;
    public static Account getCurrentAccount() {
        return currentAccount;
    }
    
    public Account DangNhap(String username, String pass) {
        Account acc = null;
        try {
            Connection con = KetNoiCSDL.openConnection();
            String sql = "SELECT * FROM Account WHERE Username=? AND Pass=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                acc = new Account();
                acc.setUsername(rs.getString("Username"));
                acc.setPass(rs.getString("Pass"));
                acc.setMaNV(rs.getString("MaNV"));
                
                // Lấy thông tin phân quyền
                String maNhomNV = getMaNhomNV(con, acc.getMaNV());
                PhanQuyen pq = getPhanQuyen(con, maNhomNV);
                acc.setPhanQuyen(pq);
                currentAccount = acc;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    private String getMaNhomNV(Connection con, String maNV) throws Exception {
        String maNhomNV = null;
        String sql = "SELECT MaNhomNV FROM NhanVien WHERE MaNV=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, maNV);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            maNhomNV = rs.getString("MaNhomNV");
        }
        return maNhomNV;
    }

    private PhanQuyen getPhanQuyen(Connection con, String maNhomNV) throws Exception {
        PhanQuyen pq = null;
        String sql = "SELECT * FROM PhanQuyen WHERE MaNhomNV=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, maNhomNV);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            pq = new PhanQuyen(
                rs.getInt("BanHang"),
                rs.getInt("KhachHang"),
                rs.getInt("HangHoa"),
                rs.getInt("TonKho"),
                rs.getInt("NhanVien"),
                rs.getInt("PhanQuyen"),
                rs.getInt("DoanhSo"),
                rs.getInt("LoiNhuan"),
                maNhomNV
            );
        }
        return pq;
    }
    
        public Account getThongTin(String username) {
        Account acc = null;
        try {
            String sql = "SELECT Username FROM Account where Username=?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                acc = new Account();
                acc.setUsername(rs.getString(1));
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
        
        public boolean changePassword(String username, String oldPassword, String newPassword) throws Exception {
        boolean isUpdated = false;
        try {
            Connection con = KetNoiCSDL.openConnection();
            String sql = "UPDATE Account SET Pass = ? WHERE Username = ? AND Pass = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, newPassword);
            pre.setString(2, username);
            pre.setString(3, oldPassword);
            int rowsUpdated = pre.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}
