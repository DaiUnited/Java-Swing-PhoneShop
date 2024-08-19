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
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiCSDL {

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://localhost:1433; databaseName=ShopDienThoai;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "Sodapro113";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, password);
    
    }
}
