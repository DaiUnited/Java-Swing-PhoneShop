/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import MODEL.NhomNV;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author daiun
 */
public class NhomQuyenDao {
        public List<NhomNV> LoadComboBox() {
    List<NhomNV> list = new ArrayList<>();
    try {
        String sql = "SELECT MaNhomNV FROM NhomNV";

        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        list.clear();
        while (rs.next()) {
            NhomNV nv = new NhomNV();
            nv.setMaNhomNV(rs.getString("MaNhomNV"));
            list.add(nv);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(NhomQuyenDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}
