/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.HoaDonNhap;
import Model.HoaDonNhapChiTiet;
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
public class JFQuanLyHoaDonNhap extends javax.swing.JFrame {

    /**
     * Creates new form JFQuanLyHoaDonNhap
     */
    List<HoaDonNhap> listHDN = new ArrayList<HoaDonNhap>();
    List<HoaDonNhapChiTiet> listHDNCT = new ArrayList<HoaDonNhapChiTiet>();
    HoaDonNhap x;
    HoaDonNhapChiTiet x2;
    private static int pos = 0;
    private static int pos2 = 0;
    private static int check = 0;
    private static int check2 = 0;
    JPanel panel;
    
    public JFQuanLyHoaDonNhap() {
        initComponents();
        ReadFile();
        ReadFile2();
        
        View();
        Viewtable(this.txtTimHoaDonNhap.getText());
        
        //View2();
        Viewtable2(this.txtTimHoaDonNhap.getText());
    }

    public void View(){
        x = listHDN.get(pos);
        
        this.txtIDHoaDonNhap.setText(x.getIDHoaDonNhap());
        this.txtIDNhanVienNhap.setText(x.getIDNhanVienNhap());
        this.txtNgayNhap.setText(x.getNgayNhap());
        
        /*
        this.txtIDSachNhap.setText(x.getIDSachNhap());
        this.txtTenSachNhap.setText(x.getTenSachNhap());
        this.txtLoaiSachNhap.setText(x.getLoaiSachNhap());
        this.txtNhaXuatBanNhap.setText(x.getNhaXuatBanNhap());
        this.txtSoLuongNhap.setText("" + x.getSoLuongNhap());
        this.txtDonGiaNhap.setText("" + x.getDonGiaNhap());
        */
                
        OnOff(true, false);
    }
    
    public void View2(){
        x2 = listHDNCT.get(pos2);
        
        //this.txtIDHoaDonNhapChiTiet.setText(x2.getIDHoaDonNhapChiTiet());
        this.txtIDSachNhap.setText(x2.getIDSachNhap());
        this.txtTenSachNhap.setText(x2.getTenSachNhap());
        this.txtLoaiSachNhap.setText(x2.getLoaiSachNhap());
        this.txtNhaXuatBanNhap.setText(x2.getNhaXuatBanNhap());
        this.txtSoLuongNhap.setText("" + x2.getSoLuongNhap());
        this.txtDonGiaNhap.setText("" + x2.getDonGiaNhap());
        
        OnOff2(true, false);
    }
    
    public void Viewtable(String name){
        DefaultTableModel model = (DefaultTableModel) this.tblHoaDonNhap.getModel();
        model.setNumRows(0);
        int n =1;
        for(HoaDonNhap x : listHDN){         
            if(x.getIDHoaDonNhap().contains(name)){
                model.addRow(new Object[]{n++, x.getIDHoaDonNhap(), x.getIDNhanVienNhap(), x.getNgayNhap()});
            }
        }
        
        /*String name = this.txtTimSach.getText();
        if(x.getTenSach().equals(name)){
            model.setNumRows(0);
            for(Book x : list){         
            model.addRow(new Object[]{n++, x.getID(), x.getTenSach(), x.getLoaiSach(), x.getSoTrang(), x.getNhaXuatBan(), x.getDonGia()});
            }
        }*/
    }
    
    public void Viewtable2(String name){
        DefaultTableModel model2 = (DefaultTableModel) this.tblHoaDon.getModel();
        model2.setNumRows(0);
        int n =1;
        for(HoaDonNhapChiTiet x2 : listHDNCT){    
            if(x2.getIDHoaDonNhapChiTiet().contains(name)){
                model2.addRow(new Object[]{n++, x2.getIDHoaDonNhapChiTiet(), x2.getIDSachNhap(), x2.getTenSachNhap(), x2.getLoaiSachNhap(),
                                        x2.getNhaXuatBanNhap(), x2.getSoLuongNhap(), x2.getDonGiaNhap()});   
            }
        }
    }
    
    public HoaDonNhap Search(String s)
    {
        for (HoaDonNhap x : listHDN)
        {
            if (x.getIDHoaDonNhap().equals(s))
                return x;
        }
        return x;
    }
    
    public HoaDonNhapChiTiet Search2(String s)
    {
        for (HoaDonNhapChiTiet x2 : listHDNCT)
        {
            if (x2.getIDSachNhap().equals(s))
                return x2;
        }
        return x2;
    }
    
    public void ReadFile() {
        String idhoadonnhap, idnhanviennhap, ngaynhap /*, idsachnhap, tensachnhap, loaisachnhap, nhaxuatbannhap*/;
        //int soluongnhap;
        //float dongianhap;
        try {
            BufferedReader br = new BufferedReader(new FileReader("HoaDonNhap.csv"));
            String line = br.readLine();
            while(line != null){
                String[] value = line.split(",");
                idhoadonnhap = value[0];
                idnhanviennhap = value[1];
                ngaynhap = value[2];
            /*    idsachnhap = value[3];
                tensachnhap = value[4];
                loaisachnhap = value[5];
                nhaxuatbannhap = value[6];
                soluongnhap = Integer.parseInt(value[7]);
                dongianhap = Float.parseFloat(value[8]);
            */
                
                listHDN.add(new HoaDonNhap(idhoadonnhap, idnhanviennhap, ngaynhap));
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void WriteFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("HoaDonNhap.csv"));
            for(HoaDonNhap x : listHDN){
                bw.write(x.getIDHoaDonNhap() + "," + x.getIDNhanVienNhap()+ "," +x.getNgayNhap());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void ReadFile2() {
        String idhoadonnhapchitiet, idsachnhap, tensachnhap, loaisachnhap, nhaxuatbannhap;
        int soluongnhap;
        float dongianhap;
        try {
            BufferedReader br = new BufferedReader(new FileReader("HoaDonNhapChiTiet.csv"));
            String line = br.readLine();
            while(line != null){
                String[] value = line.split(",");
                idhoadonnhapchitiet = value[0];
                idsachnhap = value[1];
                tensachnhap = value[2];
                loaisachnhap = value[3];
                nhaxuatbannhap = value[4];
                soluongnhap = Integer.parseInt(value[5]);
                dongianhap = Float.parseFloat(value[6]);
            
                listHDNCT.add(new HoaDonNhapChiTiet(idhoadonnhapchitiet ,idsachnhap, tensachnhap, loaisachnhap, nhaxuatbannhap, soluongnhap, dongianhap));
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void WriteFile2(){
        try {
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("HoaDonNhapChiTiet.csv"));
            for(HoaDonNhapChiTiet x2 : listHDNCT){
                bw2.write(x2.getIDHoaDonNhapChiTiet()+","+ x2.getIDSachNhap() + "," + x2.getTenSachNhap() + "," +x2.getLoaiSachNhap() + ","
                + x2.getNhaXuatBanNhap() + ","+x2.getSoLuongNhap() + ","+x2.getDonGiaNhap());
                bw2.newLine();
            }
            bw2.close();
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void OnOff(boolean a, boolean b){
        this.btnSaveHoaDonNhap.show(b);
        this.btnCancelHoaDonNhap.show(b);
        
        this.btnAddHoaDonNhap.show(a);
        this.btnEditHoaDonNhap.show(a);
        this.btnDeleteHoaDonNhap.show(a);
    }
    
    public void OnOff2(boolean a, boolean b){
        this.btnSaveHoaDon.show(b);
        this.btnCancelHoaDon.show(b);
        
        this.btnAddHoaDon.show(a);
        this.btnEditHoaDon.show(a);
        this.btnDeleteHoaDon.show(a);
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
        btnSaveHoaDonNhap = new javax.swing.JButton();
        btnCancelHoaDonNhap = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIDSachNhap = new javax.swing.JTextField();
        txtTenSachNhap = new javax.swing.JTextField();
        txtLoaiSachNhap = new javax.swing.JTextField();
        txtSoLuongNhap = new javax.swing.JTextField();
        txtDonGiaNhap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNhaXuatBanNhap = new javax.swing.JTextField();
        btnAddHoaDon = new javax.swing.JButton();
        btnEditHoaDon = new javax.swing.JButton();
        btnDeleteHoaDon = new javax.swing.JButton();
        btnSaveHoaDon = new javax.swing.JButton();
        btnCancelHoaDon = new javax.swing.JButton();
        btnAddHoaDonNhap = new javax.swing.JButton();
        btnEditHoaDonNhap = new javax.swing.JButton();
        btnDeleteHoaDonNhap = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDHoaDonNhap = new javax.swing.JTextField();
        txtIDNhanVienNhap = new javax.swing.JTextField();
        txtNgayNhap = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIDHoaDonNhapChiTiet = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonNhap = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        txtTimHoaDonNhap = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnSearchHoaDonNhap = new javax.swing.JButton();
        btnRefreshHoaDonNhap = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("HÓA ĐƠN NHẬP NHÀ SÁCH TIẾN THỌ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btnSaveHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveHoaDonNhap.setText("Lưu");
        btnSaveHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveHoaDonNhapActionPerformed(evt);
            }
        });

        btnCancelHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelHoaDonNhap.setText("Hủy");
        btnCancelHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelHoaDonNhapActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã sách :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên sách :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Loại sách :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số lượng :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Đơn giá :");

        txtIDSachNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDSachNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDSachNhapActionPerformed(evt);
            }
        });

        txtTenSachNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtLoaiSachNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLoaiSachNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoaiSachNhapActionPerformed(evt);
            }
        });

        txtSoLuongNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongNhapActionPerformed(evt);
            }
        });

        txtDonGiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nhà XB :");

        txtNhaXuatBanNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAddHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddHoaDon.setText("Thêm");
        btnAddHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHoaDonActionPerformed(evt);
            }
        });

        btnEditHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditHoaDon.setText("Sửa");
        btnEditHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditHoaDonActionPerformed(evt);
            }
        });

        btnDeleteHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteHoaDon.setText("Xóa");
        btnDeleteHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHoaDonActionPerformed(evt);
            }
        });

        btnSaveHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveHoaDon.setText("Lưu");
        btnSaveHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveHoaDonActionPerformed(evt);
            }
        });

        btnCancelHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelHoaDon.setText("Hủy");
        btnCancelHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelHoaDonActionPerformed(evt);
            }
        });

        btnAddHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddHoaDonNhap.setText("Thêm");
        btnAddHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHoaDonNhapActionPerformed(evt);
            }
        });

        btnEditHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditHoaDonNhap.setText("Sửa");
        btnEditHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditHoaDonNhapActionPerformed(evt);
            }
        });

        btnDeleteHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteHoaDonNhap.setText("Xóa");
        btnDeleteHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHoaDonNhapActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã hóa đơn :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã nhân viên :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày nhập :");

        txtIDHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtIDNhanVienNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNgayNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mã HĐ :");

        txtIDHoaDonNhapChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDHoaDonNhap)
                    .addComponent(txtIDNhanVienNhap)
                    .addComponent(txtNgayNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddHoaDonNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteHoaDonNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditHoaDonNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSaveHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenSachNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLoaiSachNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNhaXuatBanNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDonGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtIDHoaDonNhapChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIDSachNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddHoaDonNhap)
                    .addComponent(jLabel2)
                    .addComponent(txtIDHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditHoaDonNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(txtIDNhanVienNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteHoaDonNhap)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelHoaDonNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveHoaDonNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(txtIDHoaDonNhapChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDSachNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSachNhap)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLoaiSachNhap)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNhaXuatBanNhap)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoLuongNhap)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDonGiaNhap)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddHoaDon)
                    .addComponent(btnEditHoaDon)
                    .addComponent(btnDeleteHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveHoaDon)
                    .addComponent(btnCancelHoaDon))
                .addGap(19, 19, 19))
        );

        tblHoaDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Mã nhân viên", "Ngày nhập"
            }
        ));
        tblHoaDonNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonNhapMouseClicked(evt);
            }
        });
        tblHoaDonNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblHoaDonNhapKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonNhap);

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Mã sách", "Tên sách", "Loại sách", "Nhà XB", "Số lượng", "Đơn giá"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        txtTimHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimHoaDonNhapActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tìm hóa đơn :");

        btnSearchHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearchHoaDonNhap.setText("Tìm");
        btnSearchHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHoaDonNhapActionPerformed(evt);
            }
        });

        btnRefreshHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRefreshHoaDonNhap.setText("Làm mới");
        btnRefreshHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshHoaDonNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimHoaDonNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchHoaDonNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefreshHoaDonNhap)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchHoaDonNhap)
                    .addComponent(btnRefreshHoaDonNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelHoaDonNhapActionPerformed
        // TODO add your handling code here:
       /* c = 1;
        View();*/
       View();
    }//GEN-LAST:event_btnCancelHoaDonNhapActionPerformed

    private void txtIDSachNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDSachNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDSachNhapActionPerformed

    private void txtLoaiSachNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoaiSachNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoaiSachNhapActionPerformed

    private void txtSoLuongNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongNhapActionPerformed

    private void btnEditHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditHoaDonActionPerformed
        // TODO add your handling code here:
        OnOff2(false, true);
        check2 = -1;
    }//GEN-LAST:event_btnEditHoaDonActionPerformed

    private void tblHoaDonNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonNhapMouseClicked
        // TODO add your handling code here:
      /* int row = this.tblHoaDonNhap.getSelectedRow();
        int col = 1;
        String s = this.tblHoaDonNhap.getModel().getValueAt(row,col).toString();
        pos = listHDN.indexOf(Search(s));
        View();
        Viewtable2();*/
      
        int row = this.tblHoaDonNhap.getSelectedRow();
        int col = 1;
        String s = this.tblHoaDonNhap.getModel().getValueAt(row, col).toString();
        pos = listHDN.indexOf(Search(s));
        View();
        this.txtIDHoaDonNhapChiTiet.setText(this.txtIDHoaDonNhap.getText());
        Viewtable2(this.txtIDHoaDonNhap.getText());
    }//GEN-LAST:event_tblHoaDonNhapMouseClicked

    private void tblHoaDonNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblHoaDonNhapKeyReleased
        // TODO add your handling code here:
       /* int row = this.tblHoaDonNhap.getSelectedRow();
        int col = 1;
        String s = this.tblHoaDonNhap.getModel().getValueAt(row,col).toString();
        pos = listHDN.indexOf(Search(s));
        View();*/
       
        int row = this.tblHoaDonNhap.getSelectedRow();
        int col = 1;
        String s = this.tblHoaDonNhap.getModel().getValueAt(row,col).toString();
        pos = listHDN.indexOf(Search(s));
        View();
    }//GEN-LAST:event_tblHoaDonNhapKeyReleased

    private void btnSaveHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveHoaDonNhapActionPerformed
        // TODO add your handling code here:
       /* this.txtIDHoaDonNhap.setText("");
        this.txtIDNhanVienNhap.setText("");
        this.txtNgayNhap.setText("");
        
        OnOff(false, true);
        check =1;*/
       
        String IDHoaDonNhap = this.txtIDHoaDonNhap.getText();
        String IDNhanVienNhap = this.txtIDNhanVienNhap.getText();
        String ngayNhap = this.txtNgayNhap.getText();
        
        //Kiểm tra điều kiện trước khi lưu
        
        if(check == 1){
            listHDN.add(new HoaDonNhap(IDHoaDonNhap, IDNhanVienNhap, ngayNhap));
        }
        if(check == -1){
            listHDN.set(pos, new HoaDonNhap(IDHoaDonNhap, IDNhanVienNhap, ngayNhap));
        }
        
        WriteFile();
        View();
        Viewtable(this.txtTimHoaDonNhap.getText());
    }//GEN-LAST:event_btnSaveHoaDonNhapActionPerformed

    private void btnSaveHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveHoaDonActionPerformed
        // TODO add your handling code here:
        
        String IDHoaDonNhap = this.txtIDHoaDonNhap.getText();
        //String IDNhanVienNhap = this.txtIDNhanVienNhap.getText();
        //String ngayNhap = this.txtNgayNhap.getText();
        
        String ID = this.txtIDSachNhap.getText();
        String tenSach = this.txtTenSachNhap.getText();
        String loaiSach = this.txtLoaiSachNhap.getText();
        String nhaXuatBan = this.txtNhaXuatBanNhap.getText();
        
        int soLuong = Integer.parseInt(this.txtSoLuongNhap.getText());
        float donGia = Float.parseFloat(this.txtDonGiaNhap.getText());
        //Kiểm tra điều kiện trước khi lưu
        
        if(check2 == 1){
            listHDNCT.add(new HoaDonNhapChiTiet(this.txtIDHoaDonNhap.getText(),ID, tenSach, loaiSach, nhaXuatBan, soLuong, donGia));
        }
        if(check2 == -1){
            listHDNCT.set(pos2, new HoaDonNhapChiTiet(this.txtIDHoaDonNhap.getText(),ID, tenSach, loaiSach, nhaXuatBan, soLuong, donGia));
        }
        
        WriteFile2();
        View2();
        Viewtable2(this.txtTimHoaDonNhap.getText());
    }//GEN-LAST:event_btnSaveHoaDonActionPerformed

    private void btnDeleteHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHoaDonActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.MessageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
        int n = JOptionPane.showConfirmDialog(panel,"Bạn có muốn xóa không", "Alert", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_NO_OPTION){
            listHDN.remove(pos2);
            if(pos2 > listHDNCT.size() - 1) pos2 = pos2 - 1;
            if(pos2 < 0) pos2 = 0;
            
            WriteFile();
            View2();
            Viewtable2(this.txtTimHoaDonNhap.getText());
        }
    }//GEN-LAST:event_btnDeleteHoaDonActionPerformed

    private void txtTimHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimHoaDonNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimHoaDonNhapActionPerformed

    private void btnSearchHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHoaDonNhapActionPerformed
        // TODO add your handling code here:
        //Viewtable(this.txtTimHoaDonNhap.getText());
        Viewtable(this.txtTimHoaDonNhap.getText());
        Viewtable2(this.txtTimHoaDonNhap.getText());
    }//GEN-LAST:event_btnSearchHoaDonNhapActionPerformed

    private void btnRefreshHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshHoaDonNhapActionPerformed
        // TODO add your handling code here:
       /* Viewtable("");
        this.txtTimHoaDonNhap.setText("");*/
        Viewtable("");
        this.txtTimHoaDonNhap.setText("");
       
    }//GEN-LAST:event_btnRefreshHoaDonNhapActionPerformed

    private void btnAddHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHoaDonActionPerformed
        // TODO add your handling code here:
        this.txtIDHoaDonNhapChiTiet.setText("");
        this.txtIDSachNhap.setText("");
        this.txtTenSachNhap.setText("");
        this.txtLoaiSachNhap.setText("");
        this.txtNhaXuatBanNhap.setText("");
        this.txtSoLuongNhap.setText("");
        this.txtDonGiaNhap.setText("");
        
        OnOff2(false, true);
        check2 =1;
    }//GEN-LAST:event_btnAddHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int row = this.tblHoaDon.getSelectedRow();
        int col = 2;
        String s = this.tblHoaDon.getModel().getValueAt(row, col).toString();
        pos2 = listHDNCT.indexOf(Search2(s));
        View2();
        
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnCancelHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelHoaDonActionPerformed
        // TODO add your handling code here:
        //c = -1;
        View2();
    }//GEN-LAST:event_btnCancelHoaDonActionPerformed

    private void btnAddHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHoaDonNhapActionPerformed
        // TODO add your handling code here:
        this.txtIDHoaDonNhap.setText("");
        this.txtIDNhanVienNhap.setText("");
        this.txtNgayNhap.setText("");
        
        OnOff(false, true);
        check =1;
    }//GEN-LAST:event_btnAddHoaDonNhapActionPerformed

    private void btnEditHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditHoaDonNhapActionPerformed
        // TODO add your handling code here:
        OnOff(false, true);
        check = -1;
    }//GEN-LAST:event_btnEditHoaDonNhapActionPerformed

    private void btnDeleteHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHoaDonNhapActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.MessageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
        int n = JOptionPane.showConfirmDialog(panel,"Bạn có muốn xóa không", "Alert", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_NO_OPTION){
            listHDN.remove(pos);
            if(pos > listHDN.size() - 1) pos = pos - 1;
            if(pos < 0) pos = 0;
            
            WriteFile();
            View();
            Viewtable(this.txtTimHoaDonNhap.getText());
        }
    }//GEN-LAST:event_btnDeleteHoaDonNhapActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
            this.dispose();
            JFMainMenu mainmenu = new JFMainMenu();
            mainmenu.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(JFQuanLyHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFQuanLyHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFQuanLyHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFQuanLyHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFQuanLyHoaDonNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHoaDon;
    private javax.swing.JButton btnAddHoaDonNhap;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelHoaDon;
    private javax.swing.JButton btnCancelHoaDonNhap;
    private javax.swing.JButton btnDeleteHoaDon;
    private javax.swing.JButton btnDeleteHoaDonNhap;
    private javax.swing.JButton btnEditHoaDon;
    private javax.swing.JButton btnEditHoaDonNhap;
    private javax.swing.JButton btnRefreshHoaDonNhap;
    private javax.swing.JButton btnSaveHoaDon;
    private javax.swing.JButton btnSaveHoaDonNhap;
    private javax.swing.JButton btnSearchHoaDonNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonNhap;
    private javax.swing.JTextField txtDonGiaNhap;
    private javax.swing.JTextField txtIDHoaDonNhap;
    private javax.swing.JLabel txtIDHoaDonNhapChiTiet;
    private javax.swing.JTextField txtIDNhanVienNhap;
    private javax.swing.JTextField txtIDSachNhap;
    private javax.swing.JTextField txtLoaiSachNhap;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtNhaXuatBanNhap;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtTenSachNhap;
    private javax.swing.JTextField txtTimHoaDonNhap;
    // End of variables declaration//GEN-END:variables
}
