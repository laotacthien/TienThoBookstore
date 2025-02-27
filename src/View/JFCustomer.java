/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Customer;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoàng
 */
public class JFCustomer extends javax.swing.JFrame {

    /**
     * Creates new form JFCustomer
     */
    
    List<Customer> listC = new ArrayList<Customer>();
    Customer x;
    private static int pos = 0;
    private static int check = 0;
    JPanel panel;
    
    public JFCustomer() {
        initComponents();
        ReadFile();
        
        View();
        Viewtable(this.txtTimKhachHang.getText());
    }

    public void View(){
        x = listC.get(pos);
        this.txtIDKhachHang.setText(x.getIDKhachHang());
        this.txtTenKhachHang.setText(x.getTenKhachHang());
        this.txtNgayMuaKhachHang.setText(x.getNgayMuaKhachHang());
        this.txtDiaChiKhachHang.setText(x.getDiaChiKhachHang());
        this.txtEmailKhachHang.setText(x.getEmailKhachHang());
        this.txtDienThoaiKhachHang.setText(x.getDienThoaiKhachHang());
        
        OnOff(true, false);
    }
    
    public void Viewtable(String name){
        DefaultTableModel model = (DefaultTableModel) this.tblCustomer.getModel();
        model.setNumRows(0);
        int n =1;
        for(Customer x : listC){         
            if(x.getTenKhachHang().contains(name)){
                model.addRow(new Object[]{n++, x.getIDKhachHang(), x.getTenKhachHang(), 
                    x.getNgayMuaKhachHang(), x.getDiaChiKhachHang(), x.getEmailKhachHang(), x.getDienThoaiKhachHang()});
            }
        }
    }
    
    public Customer Search(String s)
    {
        for (Customer x : listC)
        {
            if (x.getIDKhachHang().equals(s))
                return x;
        }
        return x;
    }
    
    public void ReadFile() {
        String idkhachhang, tenkhachhang, ngaymuakhachhang, diachikhachhang, emailkhachhang, dienthoaikhachhang;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Customer.csv"));
            String line = br.readLine();
            while(line != null){
                String[] value = line.split(",");
                idkhachhang = value[0];
                tenkhachhang = value[1];
                ngaymuakhachhang = value[2];
                diachikhachhang = value[3];
                emailkhachhang = value[4];
                dienthoaikhachhang = value[5];
                
                listC.add(new Customer(idkhachhang, tenkhachhang, ngaymuakhachhang, diachikhachhang, emailkhachhang, dienthoaikhachhang));
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void WriteFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Customer.csv"));
            for(Customer x : listC){
                bw.write(x.getIDKhachHang()+ "," + x.getTenKhachHang()+ "," + x.getNgayMuaKhachHang()+ ","
                + x.getDiaChiKhachHang()+ "," + x.getEmailKhachHang()+ "," + x.getDienThoaiKhachHang());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void OnOff(boolean a, boolean b){
        this.btnSaveKhachHang.show(b);
        this.btnCancelKhachHang.show(b);
        
        this.btnAddKhachHang.show(a);
        this.btnEditKhachHang.show(a);
        this.btnDeleteKhachHang.show(a);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtNgayMuaKhachHang = new javax.swing.JTextField();
        txtDiaChiKhachHang = new javax.swing.JTextField();
        txtEmailKhachHang = new javax.swing.JTextField();
        txtDienThoaiKhachHang = new javax.swing.JTextField();
        btnAddKhachHang = new javax.swing.JButton();
        btnEditKhachHang = new javax.swing.JButton();
        btnSaveKhachHang = new javax.swing.JButton();
        btnCancelKhachHang = new javax.swing.JButton();
        btnDeleteKhachHang = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTimKhachHang = new javax.swing.JTextField();
        btnSearchKhachHang = new javax.swing.JButton();
        btnReFreshKhachHang = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách hàng nhà sách Tiến Thọ");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG NHÀ SÁCH TIẾN THỌ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày mua :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Địa chỉ :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Email :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Số điện thoại :");

        txtIDKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNgayMuaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayMuaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayMuaKhachHangActionPerformed(evt);
            }
        });

        txtDiaChiKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmailKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDienThoaiKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAddKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddKhachHang.setText("Thêm");
        btnAddKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKhachHangActionPerformed(evt);
            }
        });

        btnEditKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditKhachHang.setText("Sửa");
        btnEditKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditKhachHangActionPerformed(evt);
            }
        });

        btnSaveKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveKhachHang.setText("Lưu");
        btnSaveKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveKhachHangActionPerformed(evt);
            }
        });

        btnCancelKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelKhachHang.setText("Hủy");
        btnCancelKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelKhachHangActionPerformed(evt);
            }
        });

        btnDeleteKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteKhachHang.setText("Xóa");
        btnDeleteKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtNgayMuaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChiKhachHang)
                            .addComponent(txtEmailKhachHang)
                            .addComponent(txtDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSaveKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEditKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                            .addComponent(btnCancelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayMuaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmailKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "Tên KH", "Ngày mua", "Địa chỉ", "Email", "SĐT"
            }
        ));
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        tblCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCustomerKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tìm khách hàng :");

        txtTimKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearchKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearchKhachHang.setText("Tìm");
        btnSearchKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchKhachHangActionPerformed(evt);
            }
        });

        btnReFreshKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReFreshKhachHang.setText("Làm mới");
        btnReFreshKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReFreshKhachHangActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReFreshKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTimKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchKhachHang)
                    .addComponent(btnReFreshKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgayMuaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayMuaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayMuaKhachHangActionPerformed

    private void btnAddKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKhachHangActionPerformed
        // TODO add your handling code here:
        this.txtIDKhachHang.setText("");
        this.txtTenKhachHang.setText("");
        this.txtNgayMuaKhachHang.setText("");
        this.txtDiaChiKhachHang.setText("");
        this.txtEmailKhachHang.setText("");
        this.txtDienThoaiKhachHang.setText("");
        
        OnOff(false, true);
        check =1;
    }//GEN-LAST:event_btnAddKhachHangActionPerformed

    private void btnDeleteKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKhachHangActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.MessageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
        int n = JOptionPane.showConfirmDialog(panel,"Bạn có muốn xóa không", "Alert", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_NO_OPTION){
            listC.remove(pos);
            if(pos > listC.size() - 1) pos = pos - 1;
            if(pos < 0) pos = 0;
            
            WriteFile();
            View();
            Viewtable(this.txtTimKhachHang.getText());
        }
    }//GEN-LAST:event_btnDeleteKhachHangActionPerformed

    private void btnCancelKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelKhachHangActionPerformed
        // TODO add your handling code here:
        View();
    }//GEN-LAST:event_btnCancelKhachHangActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        // TODO add your handling code here:
        int row = this.tblCustomer.getSelectedRow();
        int col = 1;
        String s = this.tblCustomer.getModel().getValueAt(row,col).toString();
        pos = listC.indexOf(Search(s));
        View();
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void tblCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCustomerKeyReleased
        // TODO add your handling code here:
        int row = this.tblCustomer.getSelectedRow();
        int col = 1;
        String s = this.tblCustomer.getModel().getValueAt(row,col).toString();
        pos = listC.indexOf(Search(s));
        View();
    }//GEN-LAST:event_tblCustomerKeyReleased

    private void btnSaveKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveKhachHangActionPerformed
        // TODO add your handling code here:
        String ID = this.txtIDKhachHang.getText();
        String tenKhachHang = this.txtTenKhachHang.getText();
        String ngayMua = this.txtNgayMuaKhachHang.getText();
        String diaChi = this.txtDiaChiKhachHang.getText();
        String email = this.txtEmailKhachHang.getText();
        String dienThoai = this.txtDienThoaiKhachHang.getText();
        //Kiểm tra điều kiện trước khi lưu
        
        if(check == 1){
            listC.add(new Customer(ID, tenKhachHang, ngayMua, diaChi, email, dienThoai));
        }
        if(check == -1){
            listC.set(pos, new Customer(ID, tenKhachHang, ngayMua, diaChi, email, dienThoai));
        }
        
        WriteFile();
        View();
        Viewtable(this.txtTimKhachHang.getText());
    }//GEN-LAST:event_btnSaveKhachHangActionPerformed

    private void btnEditKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditKhachHangActionPerformed
        // TODO add your handling code here:
        OnOff(false, true);
        check = -1;
    }//GEN-LAST:event_btnEditKhachHangActionPerformed

    private void btnSearchKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchKhachHangActionPerformed
        // TODO add your handling code here:
        Viewtable(this.txtTimKhachHang.getText());
    }//GEN-LAST:event_btnSearchKhachHangActionPerformed

    private void btnReFreshKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReFreshKhachHangActionPerformed
        // TODO add your handling code here:
        Viewtable("");
        this.txtTimKhachHang.setText("");
    }//GEN-LAST:event_btnReFreshKhachHangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            this.dispose();
            JFMainMenu mainmenu = new JFMainMenu();
            mainmenu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKhachHang;
    private javax.swing.JButton btnCancelKhachHang;
    private javax.swing.JButton btnDeleteKhachHang;
    private javax.swing.JButton btnEditKhachHang;
    private javax.swing.JButton btnReFreshKhachHang;
    private javax.swing.JButton btnSaveKhachHang;
    private javax.swing.JButton btnSearchKhachHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtDiaChiKhachHang;
    private javax.swing.JTextField txtDienThoaiKhachHang;
    private javax.swing.JTextField txtEmailKhachHang;
    private javax.swing.JTextField txtIDKhachHang;
    private javax.swing.JTextField txtNgayMuaKhachHang;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKhachHang;
    // End of variables declaration//GEN-END:variables
}
