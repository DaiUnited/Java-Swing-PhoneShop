/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import DAO.NhanVienDao;
import DAO.NhomQuyenDao;
import MODEL.NhanVien;
import MODEL.NhomNV;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author daiun
 */
public class frmQLNhanVien extends javax.swing.JInternalFrame {
    List<NhanVien> listNV = new ArrayList<>();
    List<NhomNV> listNQ = new ArrayList<>();
    DefaultTableModel tblModel = new DefaultTableModel();
    DefaultComboBoxModel<String> comboBoxModel;
    int index = 0;
    /**
     * Creates new form frmQLNhanVien
     */
    public frmQLNhanVien() {
        initComponents();
        fillDataToTable();
        loadComboBox();
    }
    
    private void setEditable(boolean enable) {
    txtManv.setEditable(enable);
    txtHo.setEditable(enable);
    txtEmail.setEditable(enable);
    txtSdt.setEditable(enable);
    txtCmnd.setEditable(enable);
    txtNgaysinh.setEditable(enable);
    txtDiachi.setEditable(enable);
    txtGhichu.setEditable(enable);
    comboQuyen.setEnabled(enable);
    rd_Nam.setEnabled(enable);
    rd_Nu.setEnabled(enable);
}
        private void loadComboBox() {
        NhomQuyenDao Dao = new NhomQuyenDao();
        listNQ = Dao.LoadComboBox();
        comboBoxModel = new DefaultComboBoxModel<>();
        for (NhomNV nv : listNQ) {
            comboBoxModel.addElement(String.valueOf(nv.getMaNhomNV()));
        }
        comboQuyen.setModel(comboBoxModel);
    }
        
    public void fillDataToTable() {
    NhanVienDao nvDao = new NhanVienDao();
    listNV = nvDao.XemThongTin();
    tblModel = (DefaultTableModel) tblNhanVien.getModel();
    tblModel.setRowCount(0);
    for (NhanVien nv : listNV) {
        Object[] row = new Object[]{
            nv.getMaNV(),
            nv.getHo(),
            nv.getTen(),
            nv.getEmail(),
            nv.getDienThoai(),
            nv.getCMND(),
            nv.getNgaySinh(),
            nv.GioiTinh(),
            nv.getDiaChi(),
            nv.getMaNhomNV(),
            nv.getGhiChu()
        };
        tblModel.addRow(row);
    }
    tblNhanVien.setModel(tblModel);
}
    public void xemThongTin(String tim)
    {
        tim = txt_Tim.getText();
        NhanVienDao nvDao = new NhanVienDao();
        listNV = nvDao.TimTheoMa(tim);
        tblModel = (DefaultTableModel) tblNhanVien.getModel();
        tblModel.setRowCount(0);
        for (NhanVien nv : listNV) {
            Object[] row = new Object[]{
                nv.getMaNV(),
                nv.getHo(),
                nv.getTen(),
                nv.GioiTinh(),
                nv.getNgaySinh(),
                nv.getCMND(),
                nv.getEmail(),
                nv.getDienThoai(),
                nv.getDiaChi(),
                nv.getMaNhomNV(),
                nv.getGhiChu()
            };
            tblModel.addRow(row);
    }
        tblNhanVien.setModel(tblModel);
    }
    
    public void showForm() {
    index = tblNhanVien.getSelectedRow();
    if (index < 0) {
        JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng trên bảng");
        return;
    } else {
        NhanVien nv = listNV.get(index);
        txtManv.setText(nv.getMaNV());
        txtHo.setText(nv.getHo());
        txtTen.setText(nv.getTen());
        txtEmail.setText(nv.getEmail());
        txtSdt.setText(nv.getDienThoai());
        txtCmnd.setText(nv.getCMND());
        txtNgaysinh.setText(nv.getNgaySinh());
        txtDiachi.setText(nv.getDiaChi());
        txtGhichu.setText(nv.getGhiChu());
        comboQuyen.setSelectedItem(nv.getMaNhomNV());
        if (nv.getGioiTinh() == 1) {
            rd_Nam.setSelected(true);
        } else {
            rd_Nu.setSelected(true);
        }
        setEditable(true);
    }
}
    
    public void clearForm() {
    txtManv.setText("");
    txtHo.setText("");
    txtTen.setText("");
    txtEmail.setText("");
    txtSdt.setText("");
    txtCmnd.setText("");
    txtNgaysinh.setText("");
    txtDiachi.setText("");
    txtGhichu.setText("");
    comboQuyen.setSelectedIndex(0);
    rd_Nam.setSelected(false);
    rd_Nu.setSelected(false);
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        panelNhomNV = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rd_Nam = new javax.swing.JRadioButton();
        rd_Nu = new javax.swing.JRadioButton();
        txtManv = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCmnd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtGhichu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        comboQuyen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnThemNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        txt_Tim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ", "Tên", "Giới tính", "Ngày sinh", "CMND", "Email", "SĐT", "Địa chỉ", "Ghi chú", "Thuộc nhóm"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelNhomNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Họ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Giới tính");

        buttonGroup1.add(rd_Nam);
        rd_Nam.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rd_Nam.setText("Nam");

        buttonGroup1.add(rd_Nu);
        rd_Nu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rd_Nu.setText("Nữ");

        txtHo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("CMND");

        txtCmnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCmndKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("SĐT");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Địa chỉ");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtSdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSdtKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Ghi chú");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Nhóm Quyền:");

        comboQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Tên");

        txtTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenKeyTyped(evt);
            }
        });

        try {
            txtNgaysinh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNgaysinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Nhóm 01:  Nhân Viên Quản Trị");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 0));
        jLabel14.setText("Nhóm 02:  Nhân Viên Bán Hàng");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("Nhóm 03:  Nhân Viên Thủ Kho");

        javax.swing.GroupLayout panelNhomNVLayout = new javax.swing.GroupLayout(panelNhomNV);
        panelNhomNV.setLayout(panelNhomNVLayout);
        panelNhomNVLayout.setHorizontalGroup(
            panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhomNVLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNhomNVLayout.createSequentialGroup()
                        .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCmnd)
                            .addComponent(txtEmail)
                            .addComponent(txtSdt)
                            .addComponent(txtDiachi)
                            .addComponent(txtGhichu)
                            .addComponent(comboQuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelNhomNVLayout.createSequentialGroup()
                                .addComponent(rd_Nam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rd_Nu))
                            .addComponent(txtNgaysinh)))
                    .addGroup(panelNhomNVLayout.createSequentialGroup()
                        .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addGroup(panelNhomNVLayout.createSequentialGroup()
                                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtManv)
                                        .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelNhomNVLayout.setVerticalGroup(
            panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhomNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rd_Nam)
                    .addComponent(rd_Nu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNhomNVLayout.createSequentialGroup()
                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(panelNhomNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemNV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/plus.png"))); // NOI18N
        btnThemNV.setText("Thêm");
        btnThemNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnSuaNV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit_1.png"))); // NOI18N
        btnSuaNV.setText("Sửa");
        btnSuaNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/boss.png"))); // NOI18N
        btnNew.setText("Nhập mới");
        btnNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnXoaNV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete_1.png"))); // NOI18N
        btnXoaNV.setText("Xóa");
        btnXoaNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        txt_Tim.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_Tim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TimKeyReleased(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelNhomNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemNV)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaNV)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaNV)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim)
                        .addContainerGap(300, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemNV)
                            .addComponent(btnSuaNV)
                            .addComponent(btnXoaNV)
                            .addComponent(txt_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelNhomNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        NhanVienDao nvDao = new NhanVienDao();
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtManv.getText());
        nv.setHo(txtHo.getText());
        nv.setTen(txtTen.getText());
        String email = txtEmail.getText();
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Email phải chứa ký tự '@'", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nv.setEmail(email);
        nv.setDienThoai(txtSdt.getText());
        nv.setCMND(txtCmnd.getText());
        nv.setNgaySinh(txtNgaysinh.getText());
        nv.setDiaChi(txtDiachi.getText());
        nv.setGhiChu(txtGhichu.getText());
        nv.setMaNhomNV(comboQuyen.getSelectedItem().toString());
        if (rd_Nam.isSelected()) {
            nv.setGioiTinh(1);
        } else {
            nv.setGioiTinh(0);
        }
        int x = nvDao.them(nv);
        if (x > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        setEditable(true);
        txtManv.setEditable(false);
        NhanVienDao nvDao = new NhanVienDao();
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtManv.getText());
        nv.setHo(txtHo.getText());
        nv.setTen(txtTen.getText());
        String email = txtEmail.getText();
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Email phải chứa ký tự '@'", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nv.setEmail(email);
        nv.setDienThoai(txtSdt.getText());
        nv.setCMND(txtCmnd.getText());
        nv.setNgaySinh(txtNgaysinh.getText());
        nv.setDiaChi(txtDiachi.getText());
        nv.setGhiChu(txtGhichu.getText());
        nv.setMaNhomNV(comboQuyen.getSelectedItem().toString());
        if (rd_Nam.isSelected()) {
            nv.setGioiTinh(1);
        } else {
            nv.setGioiTinh(0);
        }
        int x = nvDao.sua(nv);
        if (x > 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            fillDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        setEditable(true);
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        String maNV = txtManv.getText().trim(); 
        if (maNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên muốn xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            NhanVienDao nvDao = new NhanVienDao();
            int x = nvDao.xoa(maNV);
            if (x > 0) {
                fillDataToTable(); 
                JOptionPane.showMessageDialog(this, "Đã xóa nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void txt_TimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKeyReleased

    }//GEN-LAST:event_txt_TimKeyReleased

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        showForm();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        xemThongTin(txt_Tim.getText());
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtHoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoKeyTyped
        // TODO add your handling code here:
                char ten = evt.getKeyChar();
        if (!Character.isLetter(ten) && !Character.isISOControl(ten)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHoKeyTyped

    private void txtTenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKeyTyped
        // TODO add your handling code here:
                char ten = evt.getKeyChar();
        if (!Character.isLetter(ten) && !Character.isISOControl(ten)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTenKeyTyped

    private void txtCmndKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmndKeyTyped
        // TODO add your handling code here:
                char cmnd = evt.getKeyChar();
        String text = ((javax.swing.JTextField) evt.getSource()).getText();

        // Giới hạn ký tự nhập vào chỉ là số
        if (!Character.isDigit(cmnd)) {
            evt.consume();
        }

        // Giới hạn độ dài tối đa là 10 ký tự
        if (text.length() >= 12) {
            evt.consume();
        }

        // Bắt buộc ký tự đầu tiên phải là số 0
        if (text.isEmpty() && cmnd != '0') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCmndKeyTyped

    private void txtSdtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSdtKeyTyped
        // TODO add your handling code here:

                char sdt = evt.getKeyChar();
        String text = ((javax.swing.JTextField) evt.getSource()).getText();

        // Giới hạn ký tự nhập vào chỉ là số
        if (!Character.isDigit(sdt)) {
            evt.consume();
        }

        // Giới hạn độ dài tối đa là 10 ký tự
        if (text.length() >= 10) {
            evt.consume();
        }

        // Bắt buộc ký tự đầu tiên phải là số 0
        if (text.isEmpty() && sdt != '0') {
            evt.consume();
        }
    }//GEN-LAST:event_txtSdtKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboQuyen;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelNhomNV;
    private javax.swing.JRadioButton rd_Nam;
    private javax.swing.JRadioButton rd_Nu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGhichu;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtManv;
    private javax.swing.JFormattedTextField txtNgaysinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txt_Tim;
    // End of variables declaration//GEN-END:variables
}