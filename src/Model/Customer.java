/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hoàng
 */
public class Customer {
    private String IDKhachHang;
    private String tenKhachHang;
    private String ngayMuaKhachHang;
    private String diaChiKhachHang;
    private String emailKhachHang;
    private String dienThoaiKhachHang;

    public Customer() {
    }

    public Customer(String IDKhachHang, String tenKhachHang, String ngayMuaKhachHang, String diaChiKhachHang, String emailKhachHang, String dienThoaiKhachHang) {
        this.IDKhachHang = IDKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngayMuaKhachHang = ngayMuaKhachHang;
        this.diaChiKhachHang = diaChiKhachHang;
        this.emailKhachHang = emailKhachHang;
        this.dienThoaiKhachHang = dienThoaiKhachHang;
    }

    public String getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(String IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNgayMuaKhachHang() {
        return ngayMuaKhachHang;
    }

    public void setNgayMuaKhachHang(String ngayMuaKhachHang) {
        this.ngayMuaKhachHang = ngayMuaKhachHang;
    }

    public String getDiaChiKhachHang() {
        return diaChiKhachHang;
    }

    public void setDiaChiKhachHang(String diaChiKhachHang) {
        this.diaChiKhachHang = diaChiKhachHang;
    }

    public String getEmailKhachHang() {
        return emailKhachHang;
    }

    public void setEmailKhachHang(String emailKhachHang) {
        this.emailKhachHang = emailKhachHang;
    }

    public String getDienThoaiKhachHang() {
        return dienThoaiKhachHang;
    }

    public void setDienThoaiKhachHang(String dienThoaiKhachHang) {
        this.dienThoaiKhachHang = dienThoaiKhachHang;
    }
    
    
}
