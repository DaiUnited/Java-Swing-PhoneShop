/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.SharedLoginState;
import MODEL.Account;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author daiun
 */
public class frmMain extends javax.swing.JFrame {
    public Account user;
    private Timer timer;
    private boolean hasLoggedOut = false;
    private frmQLKhachHang frmKH1 = null;
    private frmQLNhanVien frmNV1 = null;
    private frmHangHoa frmHH1 = null;
    private frmHangTonKho frmHTK1 = null;
    private frmDatHang frmBH1 = null;
    private static String userName;
    public void enableBanHang(boolean enable) {
        iBanHang.setEnabled(enable);
        iKhachHang.setEnabled(enable);
    }

    public void enableKho(boolean enable) {
        iTonKho.setEnabled(enable);
        iHangHoa.setEnabled(enable);
    }
    public void enableQuanTri(boolean enable)
    {
        iNhanVien.setEnabled(enable);
        iDoanhSo.setEnabled(enable);
    }
    /**
     * Creates new form frmMain
     */
    public frmMain(Account name) throws SQLException {
        this.user = name;
        initComponents();
        adjustImageToPanel();
        setLocationRelativeTo(null);
        timer = new Timer(true);
        timer.schedule(new LogoutCheckTask(), 0, 5000);
        HienThiUser();
    }
    
    private void adjustImageToPanel() {
    // Lấy kích thước của JPanel
    Dimension panelSize = jPanel1.getSize();

    // Đọc ảnh từ file
    ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Resources/Mobile_phones_collection.png"));

    // Thay đổi kích thước ảnh
    Image scaledImage = originalIcon.getImage().getScaledInstance(panelSize.width, panelSize.height, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    // Thiết lập ảnh đã thay đổi kích thước vào JLabel
    jLabel1.setIcon(scaledIcon);

    // Đảm bảo JLabel sử dụng toàn bộ không gian của JPanel
    jLabel1.setSize(panelSize);
}
    
    private void HienThiUser()
    {
        lblUserName.setText("Xin chào: " + user.getUsername());
    }
    
    class LogoutCheckTask extends TimerTask {
        @Override
        public void run() {
            try {
                String status = SharedLoginState.readStatus();
                if (status.equals("LOGGED_OUT") && !hasLoggedOut) {
                    hasLoggedOut = true;
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null, "Bạn đã bị đăng xuất từ một phiên khác.");
                        timer.cancel();
                        dispose();
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        panelFooter = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MainMenu = new javax.swing.JMenuBar();
        mnuBanHang = new javax.swing.JMenu();
        iBanHang = new javax.swing.JMenuItem();
        iKhachHang = new javax.swing.JMenuItem();
        mnuHangHoa = new javax.swing.JMenu();
        iHangHoa = new javax.swing.JMenuItem();
        iTonKho = new javax.swing.JMenuItem();
        mnuNhanVien = new javax.swing.JMenu();
        iNhanVien = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        iDoanhSo = new javax.swing.JMenuItem();
        mnuSpace = new javax.swing.JMenu();
        mnuSetting = new javax.swing.JMenu();
        jMenuDoiMK = new javax.swing.JMenuItem();
        jMenuThongTinCT = new javax.swing.JMenuItem();
        mnuTheme = new javax.swing.JMenu();
        mnuLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 0, 0));
        lblUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/boy.png"))); // NOI18N
        lblUserName.setText("User_name");

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterLayout.createSequentialGroup()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Màn hình chính", jPanel1);

        MainMenu.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        mnuBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buy.png"))); // NOI18N
        mnuBanHang.setText("Bán Hàng");
        mnuBanHang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        iBanHang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        iBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/approve.png"))); // NOI18N
        iBanHang.setText("Bán Hàng");
        iBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBanHangActionPerformed(evt);
            }
        });
        mnuBanHang.add(iBanHang);

        iKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        iKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Customer_1.png"))); // NOI18N
        iKhachHang.setText("Khách Hàng");
        iKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iKhachHangActionPerformed(evt);
            }
        });
        mnuBanHang.add(iKhachHang);

        MainMenu.add(mnuBanHang);

        mnuHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/warehouse.png"))); // NOI18N
        mnuHangHoa.setText("Hàng Hóa");
        mnuHangHoa.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        iHangHoa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        iHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hanghoa.png"))); // NOI18N
        iHangHoa.setText("Hàng Hóa");
        iHangHoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iHangHoaActionPerformed(evt);
            }
        });
        mnuHangHoa.add(iHangHoa);

        iTonKho.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        iTonKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tonkho.png"))); // NOI18N
        iTonKho.setText("Tồn kho");
        iTonKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iTonKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iTonKhoActionPerformed(evt);
            }
        });
        mnuHangHoa.add(iTonKho);

        MainMenu.add(mnuHangHoa);

        mnuNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Employee.png"))); // NOI18N
        mnuNhanVien.setText("Nhân Viên");
        mnuNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        iNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        iNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/nhanvien.png"))); // NOI18N
        iNhanVien.setText("Nhân Viên");
        iNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iNhanVienActionPerformed(evt);
            }
        });
        mnuNhanVien.add(iNhanVien);

        MainMenu.add(mnuNhanVien);

        mnuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Report.png"))); // NOI18N
        mnuThongKe.setText("Thống Kê");
        mnuThongKe.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        iDoanhSo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        iDoanhSo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/doanhso.png"))); // NOI18N
        iDoanhSo.setText("Doanh Số");
        iDoanhSo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iDoanhSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iDoanhSoActionPerformed(evt);
            }
        });
        mnuThongKe.add(iDoanhSo);

        MainMenu.add(mnuThongKe);

        mnuSpace.setForeground(new java.awt.Color(255, 255, 255));
        mnuSpace.setText("                                                                                                                                                                                                            ");
        MainMenu.add(mnuSpace);

        mnuSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/setting.png"))); // NOI18N
        mnuSetting.setText("  ");
        mnuSetting.setToolTipText("Cấu hình");

        jMenuDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/keys.png"))); // NOI18N
        jMenuDoiMK.setText("Đổi mật khẩu");
        jMenuDoiMK.setPreferredSize(new java.awt.Dimension(137, 22));
        jMenuDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuDoiMKMouseClicked(evt);
            }
        });
        jMenuDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDoiMKActionPerformed(evt);
            }
        });
        mnuSetting.add(jMenuDoiMK);

        jMenuThongTinCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuThongTinCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/information.png"))); // NOI18N
        jMenuThongTinCT.setText("Thông tin công ty");
        jMenuThongTinCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuThongTinCTMouseClicked(evt);
            }
        });
        jMenuThongTinCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuThongTinCTActionPerformed(evt);
            }
        });
        mnuSetting.add(jMenuThongTinCT);

        MainMenu.add(mnuSetting);

        mnuTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Themes.png"))); // NOI18N
        mnuTheme.setText("  ");
        mnuTheme.setToolTipText("Giao diện");
        mnuTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuThemeMouseClicked(evt);
            }
        });
        MainMenu.add(mnuTheme);

        mnuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logout.png"))); // NOI18N
        mnuLogout.setText("Đăng xuất");
        mnuLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuLogoutMouseClicked(evt);
            }
        });
        mnuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogoutActionPerformed(evt);
            }
        });
        MainMenu.add(mnuLogout);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void mnuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogoutActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn thoát?", "Cảnh báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (res == JOptionPane.OK_OPTION){
            try {
            SharedLoginState.writeStatus("LOGGED_OUT");
            } catch (IOException e) {
                e.printStackTrace();
            }
            new frmLogin().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_mnuLogoutActionPerformed

    private void mnuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuLogoutMouseClicked
        int res = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn thoát?", "Cảnh báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (res == JOptionPane.OK_OPTION){
            try {
            SharedLoginState.writeStatus("LOGGED_OUT");
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.tabbedPane.removeAll();
            this.setVisible(false);
            new frmLogin().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_mnuLogoutMouseClicked

    private void mnuThemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuThemeMouseClicked
        JColorChooser jcc = new JColorChooser();
        Color c = jcc.showDialog(this.mnuTheme, "Themes",Color.lightGray);
        this.panelFooter.setBackground(c);
        this.tabbedPane.setBackground(c);
        this.MainMenu.setBackground(c);
    }//GEN-LAST:event_mnuThemeMouseClicked

    private void iNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iNhanVienActionPerformed
        Dimension dv = new Dimension();
        tabbedPane.getSize(dv);
        if (frmNV1 == null || frmNV1.isClosed()){
            frmNV1 = new frmQLNhanVien();
            frmNV1.setVisible(true);
            frmNV1.setSize(dv);
            tabbedPane.add("Nhân Viên", frmNV1);
            tabbedPane.setSelectedComponent(frmNV1);
        } else {
            tabbedPane.setSelectedComponent(frmNV1);
        }
    }//GEN-LAST:event_iNhanVienActionPerformed

    private void iBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iBanHangActionPerformed
        Dimension dv = new Dimension();
        tabbedPane.getSize(dv);
        if (frmBH1 == null || frmBH1.isClosed()){
            frmBH1 = new frmDatHang();
            frmBH1.setVisible(true);
            frmBH1.setSize(dv);
            tabbedPane.add("Bán Hàng", frmBH1);
            tabbedPane.setSelectedComponent(frmBH1);
        } else{
            tabbedPane.setSelectedComponent(frmBH1);
        }
    }//GEN-LAST:event_iBanHangActionPerformed

    private void iHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iHangHoaActionPerformed
        Dimension dv = new Dimension();
        tabbedPane.getSize(dv);
        if (frmHH1 == null || frmHH1.isClosed()){
            frmHH1 = new frmHangHoa();
            frmHH1.setVisible(true);
            frmHH1.setSize(dv);
            tabbedPane.add("Hàng Hóa", frmHH1);
            tabbedPane.setSelectedComponent(frmHH1);
        } else {
            tabbedPane.setSelectedComponent(frmHH1);
        }
    }//GEN-LAST:event_iHangHoaActionPerformed

    private void jMenuDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuDoiMKMouseClicked
        // TODO add your handling code here:
        jPopupMenu.setVisible(false);
        new frmDoiMatKhau().setVisible(true);
    }//GEN-LAST:event_jMenuDoiMKMouseClicked

    private void jMenuDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDoiMKActionPerformed
        // TODO add your handling code here:
        new frmDoiMatKhau().setVisible(true);
    }//GEN-LAST:event_jMenuDoiMKActionPerformed

    private void iTonKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iTonKhoActionPerformed
        Dimension dv = new Dimension();
        tabbedPane.getSize(dv);
        if (frmHTK1 == null || frmHTK1.isClosed()){
            frmHTK1 = new frmHangTonKho();
            frmHTK1.setVisible(true);
            frmHTK1.setSize(dv);
            tabbedPane.add("Hàng Tồn Kho", frmHTK1);
            tabbedPane.setSelectedComponent(frmHTK1);
        } else{
            tabbedPane.setSelectedComponent(frmHTK1);
        }
    }//GEN-LAST:event_iTonKhoActionPerformed

    private void iDoanhSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iDoanhSoActionPerformed
        // TODO add your handling code here:
        new frmDoanhSo().setVisible(true);
    }//GEN-LAST:event_iDoanhSoActionPerformed

    private void iKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iKhachHangActionPerformed
        Dimension dv = new Dimension();
        tabbedPane.getSize(dv);
        if (frmKH1 == null || frmKH1.isClosed()){
            frmKH1 = new frmQLKhachHang();
            frmKH1.setVisible(true);
            frmKH1.setSize(dv);
            tabbedPane.add("Khách Hàng", frmKH1);
            tabbedPane.setSelectedComponent(frmKH1);
        } else{
            tabbedPane.setSelectedComponent(frmKH1);
        }
    }//GEN-LAST:event_iKhachHangActionPerformed

    private void jMenuThongTinCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuThongTinCTActionPerformed
        // TODO add your handling code here:
        new frmAbout().setVisible(true);
    }//GEN-LAST:event_jMenuThongTinCTActionPerformed

    private void jMenuThongTinCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuThongTinCTMouseClicked
        // TODO add your handling code here:
        jPopupMenu.setVisible(false);
        new frmAbout().setVisible(true);
    }//GEN-LAST:event_jMenuThongTinCTMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmMain(new Account()).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenuItem iBanHang;
    private javax.swing.JMenuItem iDoanhSo;
    private javax.swing.JMenuItem iHangHoa;
    private javax.swing.JMenuItem iKhachHang;
    private javax.swing.JMenuItem iNhanVien;
    private javax.swing.JMenuItem iTonKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuDoiMK;
    private javax.swing.JMenuItem jMenuThongTinCT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JMenu mnuBanHang;
    private javax.swing.JMenu mnuHangHoa;
    private javax.swing.JMenu mnuLogout;
    private javax.swing.JMenu mnuNhanVien;
    private javax.swing.JMenu mnuSetting;
    private javax.swing.JMenu mnuSpace;
    private javax.swing.JMenu mnuTheme;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
