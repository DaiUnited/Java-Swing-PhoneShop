/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;
import DAO.CTHoaDonDao;
import DAO.HangHoaDao;
import DAO.HoaDonDao;
import DAO.KhachHangDao;
import DAO.NhanVienDao;
import MODEL.CTHoaDon;
import MODEL.HangHoa;
import MODEL.HoaDon;
import MODEL.KhachHang;
import MODEL.NhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author daiun
 */
public class frmDatHang extends javax.swing.JInternalFrame {
    DefaultComboBoxModel<String> comboBoxModel;
    List<KhachHang> listKH = new ArrayList<>();
    List<NhanVien> listNV = new ArrayList<>();
    List<HangHoa> listDT = new ArrayList<>();
    List<HoaDon> listHD = new ArrayList<>();
    List<HoaDon> listComboMaHD = new ArrayList<>();
    List<CTHoaDon> listCT = new ArrayList<>();
    DefaultTableModel tblModelHD = new DefaultTableModel();
    DefaultTableModel tblModelCTHD = new DefaultTableModel();
    int indexHD = 0, indexCT = 0;
    /**
     * Creates new form frmDatHang
     */
    public frmDatHang() {
        initComponents();
        fillDataToTableHD();
        fillDataToTableCTHD();
        loadComboBoxKH();
        loadComboBoxNV();
        loadComboBoxDT();
        loadComboBoxHD();
        
    }
    
    private void loadComboBoxKH() {
        KhachHangDao Dao = new KhachHangDao();
        listKH = Dao.LoadComboBox();
        comboBoxModel = new DefaultComboBoxModel<>();
        for (KhachHang kh : listKH) {
            comboBoxModel.addElement(String.valueOf(kh.getMaKH()));
        }
        comboKH.setModel(comboBoxModel);
    }
    
    private void loadComboBoxNV() {
        NhanVienDao Dao = new NhanVienDao();
        listNV = Dao.LoadComboBox();
        comboBoxModel = new DefaultComboBoxModel<>();
        for (NhanVien nv : listNV) {
            comboBoxModel.addElement(String.valueOf(nv.getMaNV()));
        }
        comboNV.setModel(comboBoxModel);
    }

    private void loadComboBoxDT() {
        HangHoaDao Dao = new HangHoaDao();
        listDT = Dao.LoadComboBox();
        comboBoxModel = new DefaultComboBoxModel<>();
        for (HangHoa dt : listDT) {
            comboBoxModel.addElement(String.valueOf(dt.getMaHang()));
        }
        comboDT.setModel(comboBoxModel);
    }
    
    private void loadComboBoxHD() {
        HoaDonDao mDao = new HoaDonDao();
        listComboMaHD = mDao.LoadComboBox();
        comboBoxModel = new DefaultComboBoxModel<>();
        for (HoaDon mhd : listComboMaHD) {
            comboBoxModel.addElement(mhd.getMaHD());
        }
        comboHD.setModel(comboBoxModel);
    }
    
    public void fillDataToTableHD(){
    HoaDonDao Dao = new HoaDonDao();
    listHD = Dao.XemThongTin();
    tblModelHD = (DefaultTableModel) tblHoaDon.getModel();
    tblModelHD.setRowCount(0);
    for (HoaDon hd : listHD) {
        Object[] row = new Object[]{hd.getMaHD(), hd.getMaKH(), hd.getNgayMua(), hd.getMaNV(), hd.getNgayLap()};
        tblModelHD.addRow(row);
    }
    tblHoaDon.setModel(tblModelHD);
}

public void fillDataToTableCTHD(){
    CTHoaDonDao Dao = new CTHoaDonDao();
    listCT = Dao.XemThongTin();
    tblModelCTHD = (DefaultTableModel) tblCTHoaDon.getModel();
    tblModelCTHD.setRowCount(0);
    for (CTHoaDon ct : listCT) {
        Object[] row = new Object[]{ct.getMaHD(), ct.getMaHang(), ct.getSoLuong(), ct.getDonGia(), ct.getGiamGia(), ct.ThanhTien()};
        tblModelCTHD.addRow(row);
    }
    tblCTHoaDon.setModel(tblModelCTHD);
}

    private void setEditable(boolean enable) {
        txtNgaylap.setEditable(enable);
        txtNgaymua.setEditable(enable);
        txt_dongia.setEditable(enable);
        txt_giam.setEditable(enable);
        txt_sl.setEditable(enable);
        txt_tongcong.setEditable(enable);
    }
    
    
    public void showFormHD() {
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng trên bảng");
            return;
        } else {
            HoaDon hd = listHD.get(indexHD);
            comboKH.setSelectedItem(hd.getMaKH());
            txtNgaylap.setText(hd.getNgayLap());
            comboNV.setSelectedItem(hd.getMaNV());
            txtNgaymua.setText(hd.getNgayMua());
            txtMaHD.setText(hd.getMaHD());
        }
        setEditable(true);
    }
    private void clearFormHD() {
       comboKH.setSelectedIndex(0);
       txtNgaymua.setText("");
       comboNV.setSelectedIndex(0);
       txtNgaylap.setText("");
   }
    
        public void showFormCTHD() {
        indexCT = tblCTHoaDon.getSelectedRow();
        if (indexCT < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng trên bảng");
            return;
        } else {
            CTHoaDon hd = listCT.get(indexCT);
             hd.setMaHD(comboHD.getSelectedItem().toString());
            comboDT.setSelectedItem(hd.getMaHang());
            txt_sl.setText(String.valueOf(hd.getSoLuong()));
            txt_dongia.setText(String.valueOf(hd.getDonGia()));
            txt_giam.setText(String.valueOf(hd.getGiamGia()));
            txt_tongcong.setText(String.valueOf(hd.ThanhTien()));
        }
        setEditable(true);
    }
    private void clearFormCTHD() {
       comboDT.setSelectedIndex(0);
       txt_sl.setText("");
       txt_dongia.setText("");
       txt_giam.setText("");
       txt_tongcong.setText("");
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboKH = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboNV = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_sl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_dongia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_giam = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTHoaDon = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_tongcong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboDT = new javax.swing.JComboBox<>();
        btnLuuCTHD = new javax.swing.JButton();
        btnSuaCTHD = new javax.swing.JButton();
        btnXoaCTHD = new javax.swing.JButton();
        btnMoiCTHD = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        comboHD = new javax.swing.JComboBox<>();
        btnIn = new javax.swing.JButton();
        btnLuuHD = new javax.swing.JButton();
        btnSuaHD = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        btnMoiHD = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtNgaymua = new javax.swing.JFormattedTextField();
        txtNgaylap = new javax.swing.JFormattedTextField();
        btnIn1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn mua hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Khách Hàng", "Ngày mua hàng", "Nhân Viên", "Ngày lập hóa đơn"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setText("Khách Hàng");

        jLabel2.setText("Ngày mua hàng");

        jLabel3.setText("Nhân Viên");

        jLabel4.setText("Ngày lập hóa đơn");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHI TIẾT HÓA ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel6.setText("SL:");

        txt_sl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_slKeyTyped(evt);
            }
        });

        jLabel7.setText("Đơn giá:");

        txt_dongia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dongiaKeyTyped(evt);
            }
        });

        jLabel8.setText("Giảm(%)");

        txt_giam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_giamKeyTyped(evt);
            }
        });

        tblCTHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã hàng", "Số lượng", "Đơn giá", "Giảm(%)", "Thành tiền"
            }
        ));
        tblCTHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTHoaDon);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("TỔNG CỘNG:");

        jLabel5.setText("Sản phẩm muốn mua");

        btnLuuCTHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnLuuCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save.png"))); // NOI18N
        btnLuuCTHD.setText("Lưu");
        btnLuuCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuCTHDActionPerformed(evt);
            }
        });

        btnSuaCTHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnSuaCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit.png"))); // NOI18N
        btnSuaCTHD.setText("Sửa");
        btnSuaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTHDActionPerformed(evt);
            }
        });

        btnXoaCTHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnXoaCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/remove.png"))); // NOI18N
        btnXoaCTHD.setText("Xóa");
        btnXoaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTHDActionPerformed(evt);
            }
        });

        btnMoiCTHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnMoiCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/refresh.png"))); // NOI18N
        btnMoiCTHD.setText("Mới");
        btnMoiCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiCTHDActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã HĐ");

        comboHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHDActionPerformed(evt);
            }
        });

        btnIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/printer.png"))); // NOI18N
        btnIn.setText("In");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnLuuCTHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaCTHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaCTHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoiCTHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_dongia)
                            .addComponent(comboDT, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboHD, 0, 144, Short.MAX_VALUE)
                            .addComponent(txt_giam))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_giam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tongcong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuCTHD)
                    .addComponent(btnSuaCTHD)
                    .addComponent(btnXoaCTHD)
                    .addComponent(btnMoiCTHD)
                    .addComponent(btnIn))
                .addGap(67, 67, 67))
        );

        btnLuuHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnLuuHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Save.png"))); // NOI18N
        btnLuuHD.setText("Lưu");
        btnLuuHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuHDActionPerformed(evt);
            }
        });

        btnSuaHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnSuaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit.png"))); // NOI18N
        btnSuaHD.setText("Sửa");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });

        btnXoaHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnXoaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/remove.png"))); // NOI18N
        btnXoaHD.setText("Xóa");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });

        btnMoiHD.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        btnMoiHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/refresh.png"))); // NOI18N
        btnMoiHD.setText("Mới");
        btnMoiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiHDActionPerformed(evt);
            }
        });

        jLabel11.setText("Mã HĐ");

        try {
            txtNgaymua.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNgaymua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            txtNgaylap.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNgaylap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnIn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/printer.png"))); // NOI18N
        btnIn1.setText("In");
        btnIn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIn1ActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/trader.jpg"))); // NOI18N

        jLabel13.setBackground(new java.awt.Color(0, 255, 255));
        jLabel13.setForeground(new java.awt.Color(0, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/card.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(btnIn1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLuuHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoiHD))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboKH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboNV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgaymua, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(comboKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNgaymua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(comboNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addComponent(txtNgaylap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuuHD)
                            .addComponent(btnSuaHD)
                            .addComponent(btnXoaHD)
                            .addComponent(btnMoiHD)
                            .addComponent(btnIn1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuHDActionPerformed
        // TODO add your handling code here:
        HoaDonDao dao = new HoaDonDao();
        HoaDon hd = new HoaDon();
        hd.setMaHD(txtMaHD.getText());
        hd.setMaKH(comboKH.getSelectedItem().toString());
        hd.setNgayMua(txtNgaymua.getText());
        hd.setMaNV(comboNV.getSelectedItem().toString());
        hd.setNgayLap(txtNgaylap.getText());

        int result = dao.them(hd);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
            fillDataToTableHD();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại");
        }
    }//GEN-LAST:event_btnLuuHDActionPerformed

    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        // TODO add your handling code here:
        HoaDonDao dao = new HoaDonDao();
        HoaDon hd = new HoaDon();
        hd.setMaKH(comboKH.getSelectedItem().toString());
        hd.setNgayMua(txtNgaymua.getText());
        hd.setMaNV(comboNV.getSelectedItem().toString());
        hd.setNgayLap(txtNgaylap.getText());
        hd.setMaHD(txtMaHD.getText());
        int result = dao.sua(hd);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công");
            fillDataToTableHD();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa hóa đơn thất bại");
        }
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        // TODO add your handling code here:
        String maHD = txtMaHD.getText();
        if (maHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa hóa đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            HoaDonDao dao = new HoaDonDao();
            int result = dao.xoa(maHD);
            if (result > 0) {
                fillDataToTableHD();
                JOptionPane.showMessageDialog(this, "Đã xóa hóa đơn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaHDActionPerformed

    private void btnMoiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiHDActionPerformed
        // TODO add your handling code here:
        setEditable(true);
        clearFormHD();
    }//GEN-LAST:event_btnMoiHDActionPerformed

    private void btnLuuCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuCTHDActionPerformed
        // TODO add your handling code here:
        CTHoaDonDao dao = new CTHoaDonDao();
        CTHoaDon cthd = new CTHoaDon();
        cthd.setMaHD(comboHD.getSelectedItem().toString());
        cthd.setMaHang(comboDT.getSelectedItem().toString());
                int soLuong = Integer.parseInt(txt_sl.getText());
        
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cthd.setSoLuong(soLuong);
                double donGia = Double.parseDouble(txt_dongia.getText());
        
        if (donGia <= 0) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cthd.setDonGia(donGia);
        cthd.setGiamGia(Double.parseDouble(txt_giam.getText()));

        int result = dao.them(cthd);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thành công");
            fillDataToTableCTHD();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thất bại");
        }
    }//GEN-LAST:event_btnLuuCTHDActionPerformed

    private void btnSuaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTHDActionPerformed
        // TODO add your handling code here:
        comboHD.setEditable(false);
        CTHoaDonDao dao = new CTHoaDonDao();
        CTHoaDon cthd = new CTHoaDon();
        cthd.setMaHD(comboHD.getSelectedItem().toString());
        cthd.setMaHang(comboDT.getSelectedItem().toString());
                int soLuong = Integer.parseInt(txt_sl.getText());
        
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cthd.setSoLuong(soLuong);
                double donGia = Double.parseDouble(txt_dongia.getText());
        
        if (donGia <= 0) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cthd.setDonGia(donGia);
        cthd.setGiamGia(Double.parseDouble(txt_giam.getText()));

        int result = dao.sua(cthd);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Sửa chi tiết hóa đơn thành công");
            fillDataToTableCTHD();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa chi tiết hóa đơn thất bại");
        }
    }//GEN-LAST:event_btnSuaCTHDActionPerformed

    private void btnXoaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTHDActionPerformed
        // TODO add your handling code here:
        String maHD = comboHD.getSelectedItem().toString().trim();
        if (maHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết hóa đơn muốn xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa chi tiết hóa đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            CTHoaDonDao dao = new CTHoaDonDao();
            int result = dao.xoa(maHD);
            if (result > 0) {
                fillDataToTableCTHD();
                JOptionPane.showMessageDialog(this, "Đã xóa chi tiết hóa đơn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa chi tiết hóa đơn thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaCTHDActionPerformed

    private void btnMoiCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiCTHDActionPerformed
        // TODO add your handling code here:
        setEditable(true);
        clearFormCTHD();
        loadComboBoxHD();
        fillDataToTableCTHD();
    }//GEN-LAST:event_btnMoiCTHDActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

        showFormHD();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblCTHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHoaDonMouseClicked

        showFormCTHD();
    }//GEN-LAST:event_tblCTHoaDonMouseClicked

    private void comboHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboHDActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        //          if(txtSL.getText().length()<=0)
        //              return;
        //          if(tblMatHang.getRowCount()<=0)
        //              return;

        try {
            Hashtable map = new Hashtable();
            JasperReport rpt = JasperCompileManager.compileReport("src/Report/rpt_chitiethoadon.jrxml");
            String mahd = comboHD.getSelectedItem().toString();
            map.put("MaHD", mahd);
            String url = "jdbc:sqlserver://localhost:1433; databaseName=ShopDienThoai;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "Sodapro113";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            JasperPrint p = JasperFillManager.fillReport(rpt, map,conn);
            JasperViewer.viewReport(p,false);
        } catch (JRException ex) {
            Logger.getLogger(frmHangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmHangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInActionPerformed

    private void btnIn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIn1ActionPerformed
          try {
            Hashtable map = new Hashtable();
            JasperReport rpt = JasperCompileManager.compileReport("src/Report/rpt_hoadon.jrxml");
            String mahd = txtMaHD.getText();
            map.put("MaHD", mahd);
            String url = "jdbc:sqlserver://localhost:1433; databaseName=ShopDienThoai;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "Sodapro113";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            JasperPrint p = JasperFillManager.fillReport(rpt, map,conn);
            JasperViewer.viewReport(p,false);
        } catch (JRException ex) {
            Logger.getLogger(frmHangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmHangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIn1ActionPerformed

    private void txt_slKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_slKeyTyped
        // TODO add your handling code here:
        char so = evt.getKeyChar();
        if (!Character.isDigit(so)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_slKeyTyped

    private void txt_dongiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dongiaKeyTyped
        // TODO add your handling code here:
        char so = evt.getKeyChar();
        if (!Character.isDigit(so)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_dongiaKeyTyped

    private void txt_giamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_giamKeyTyped
        // TODO add your handling code here:
        char sdt = evt.getKeyChar();
        String text = ((javax.swing.JTextField) evt.getSource()).getText();
        if (!Character.isDigit(sdt)) {
            evt.consume();
        }
        if (text.length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_giamKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnIn1;
    private javax.swing.JButton btnLuuCTHD;
    private javax.swing.JButton btnLuuHD;
    private javax.swing.JButton btnMoiCTHD;
    private javax.swing.JButton btnMoiHD;
    private javax.swing.JButton btnSuaCTHD;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnXoaCTHD;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JComboBox<String> comboDT;
    private javax.swing.JComboBox<String> comboHD;
    private javax.swing.JComboBox<String> comboKH;
    private javax.swing.JComboBox<String> comboNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCTHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JFormattedTextField txtNgaylap;
    private javax.swing.JFormattedTextField txtNgaymua;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_giam;
    private javax.swing.JTextField txt_sl;
    private javax.swing.JTextField txt_tongcong;
    // End of variables declaration//GEN-END:variables
}
