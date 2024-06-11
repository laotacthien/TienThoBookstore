/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hoàng
 */
public class Book {
    private String ID;
    private String tenSach;
    private String loaiSach;
    private int soTrang;
    private String nhaXuatBan;
    private float donGia;

    public Book(){
    
    }
    
    public Book(String ID, String tenSach, String loaiSach, int soTrang, String nhaXuatBan, float donGia) {
        this.ID = ID;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.soTrang = soTrang;
        this.nhaXuatBan = nhaXuatBan;
        this.donGia = donGia;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
    
    
}
