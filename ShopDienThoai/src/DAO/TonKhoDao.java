/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.HangHoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanhtung
 */
public class TonKhoDao {
    public List<HangHoa> docTatCaLoaiHangTonKho(){
        List<HangHoa> list = new ArrayList<>();
        try {
            String sql = "SELECT hh.MaHang, hh.TenHang, hh.SoLuong, lh.TenLoaiHang, hh.GiaNhap " +
                         "FROM HangHoa hh " +
                         "JOIN LoaiHang lh ON hh.MaLoaiHang = lh.MaLoaiHang " +
                         "WHERE hh.SoLuong > 0";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list.clear();
            while (rs.next()) {
                HangHoa S = new HangHoa(); 
                S.setMaHang(rs.getString("MaHang")); 
                S.setTenHang(rs.getString("TenHang")); 
                S.setSoLuong(rs.getInt("SoLuong"));
                S.setTenLoaiHang(rs.getString("TenLoaiHang"));
                S.setGiaNhap(rs.getFloat("GiaNhap"));
                list.add(S);
            }           
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        } 

        return list;
    }
    public List<HangHoa> timKiemSoLuongTonKho(int soLuongTimKiem) {
        List<HangHoa> list = new ArrayList<>();
        try {
            String sql = "SELECT hh.MaHang, hh.TenHang, hh.SoLuong, lh.TenLoaiHang, hh.GiaNhap " +
                         "FROM HangHoa hh " +
                         "JOIN LoaiHang lh ON hh.MaLoaiHang = lh.MaLoaiHang " +
                         "WHERE hh.SoLuong <= ? AND hh.SoLuong > 0";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, soLuongTimKiem);
            ResultSet rs = stm.executeQuery();
            list.clear();
            while (rs.next()) {
                HangHoa S = new HangHoa(); 
                S.setMaHang(rs.getString("MaHang")); 
                S.setTenHang(rs.getString("TenHang")); 
                S.setSoLuong(rs.getInt("SoLuong"));
                S.setTenLoaiHang(rs.getString("TenLoaiHang"));
                S.setGiaNhap(rs.getFloat("GiaNhap"));
                list.add(S);
            }           
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        } 

        return list;
    }
}
