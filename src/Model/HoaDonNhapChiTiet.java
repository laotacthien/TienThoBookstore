/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hoàng
 */
public class HoaDonNhapChiTiet{
    
    private String IDHoaDonNhapChiTiet;
    private String IDSachNhap;
    private String tenSachNhap;
    private String loaiSachNhap;
    private String nhaXuatBanNhap;
    private int soLuongNhap;
    private float donGiaNhap;

    public HoaDonNhapChiTiet() {
    }

    public HoaDonNhapChiTiet(String IDHoaDonNhapChiTiet, String IDSachNhap, String tenSachNhap, String loaiSachNhap, String nhaXuatBanNhap, int soLuongNhap, float donGiaNhap) {
        this.IDHoaDonNhapChiTiet = IDHoaDonNhapChiTiet;
        this.IDSachNhap = IDSachNhap;
        this.tenSachNhap = tenSachNhap;
        this.loaiSachNhap = loaiSachNhap;
        this.nhaXuatBanNhap = nhaXuatBanNhap;
        this.soLuongNhap = soLuongNhap;
        this.donGiaNhap = donGiaNhap;
    }

    public String getIDSachNhap() {
        return IDSachNhap;
    }

    public void setIDSachNhap(String IDSachNhap) {
        this.IDSachNhap = IDSachNhap;
    }

    public String getTenSachNhap() {
        return tenSachNhap;
    }

    public void setTenSachNhap(String tenSachNhap) {
        this.tenSachNhap = tenSachNhap;
    }

    public String getLoaiSachNhap() {
        return loaiSachNhap;
    }

    public void setLoaiSachNhap(String loaiSachNhap) {
        this.loaiSachNhap = loaiSachNhap;
    }

    public String getNhaXuatBanNhap() {
        return nhaXuatBanNhap;
    }

    public void setNhaXuatBanNhap(String nhaXuatBanNhap) {
        this.nhaXuatBanNhap = nhaXuatBanNhap;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public float getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(float donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    
    public String getIDHoaDonNhapChiTiet() {
        return IDHoaDonNhapChiTiet;
    }

    public void setIDHoaDonNhapChiTiet(String IDHoaDonNhap) {
        this.IDHoaDonNhapChiTiet = IDHoaDonNhapChiTiet;
    }
    
    
}
