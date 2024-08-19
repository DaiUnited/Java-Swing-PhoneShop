/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.LoaiHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daiun
 */
public class LoaiHangDao {
    public List<LoaiHang> LoadComboBox() {
    List<LoaiHang> list = new ArrayList<>();
    try {
        String sql = "SELECT MaLoaiHang FROM LoaiHang";

        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        list.clear();
        while (rs.next()) {
            LoaiHang lh = new LoaiHang();
            lh.setMaLoaiHang(rs.getInt("MaLoaiHang"));
            list.add(lh);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(LoaiHangDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}
