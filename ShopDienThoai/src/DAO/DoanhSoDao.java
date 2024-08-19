/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author daiun
 */
import MODEL.DoanhSo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoanhSoDao {
    public List<DoanhSo> query(String MaNV, String start, String end){
        List<DoanhSo> list = new ArrayList<>();

        try {
            String sql = "EXEC sp_DoanhSo @MaNV = ?, @NgayBatDau = ?, @NgayKetThuc = ?";

            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, MaNV);
            pstm.setString(2, start);
            pstm.setString(3, end);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new DoanhSo(rs.getString(1), rs.getDouble(2), rs.getInt(3)));
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
