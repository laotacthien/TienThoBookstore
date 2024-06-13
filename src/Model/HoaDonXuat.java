/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hoàng
 */
public class HoaDonXuat {
    private String IDHoaDonXuat;
    private String NgayLap;
    private String IDKhachHangXuat;
    private String TenKhachHangXuat;
    private String DiaChiXuat;
    private String EmailXuat;
    private String DienThoaiXuat;

    public HoaDonXuat() {
    }

    public HoaDonXuat(String IDHoaDonXuat, String NgayLap, String IDKhachHangXuat, String TenKhachHangXuat, String DiaChiXuat, String EmailXuat, String DienThoaiXuat) {
        this.IDHoaDonXuat = IDHoaDonXuat;
        this.NgayLap = NgayLap;
        this.IDKhachHangXuat = IDKhachHangXuat;
        this.TenKhachHangXuat = TenKhachHangXuat;
        this.DiaChiXuat = DiaChiXuat;
        this.EmailXuat = EmailXuat;
        this.DienThoaiXuat = DienThoaiXuat;
    }

    public String getIDHoaDonXuat() {
        return IDHoaDonXuat;
    }

    public void setIDHoaDonXuat(String IDHoaDonXuat) {
        this.IDHoaDonXuat = IDHoaDonXuat;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getIDKhachHangXuat() {
        return IDKhachHangXuat;
    }

    public void setIDKhachHangXuat(String IDKhachHangXuat) {
        this.IDKhachHangXuat = IDKhachHangXuat;
    }

    public String getTenKhachHangXuat() {
        return TenKhachHangXuat;
    }

    public void setTenKhachHangXuat(String TenKhachHangXuat) {
        this.TenKhachHangXuat = TenKhachHangXuat;
    }

    public String getDiaChiXuat() {
        return DiaChiXuat;
    }

    public void setDiaChiXuat(String DiaChiXuat) {
        this.DiaChiXuat = DiaChiXuat;
    }

    public String getEmailXuat() {
        return EmailXuat;
    }

    public void setEmailXuat(String EmailXuat) {
        this.EmailXuat = EmailXuat;
    }

    public String getDienThoaiXuat() {
        return DienThoaiXuat;
    }

    public void setDienThoaiXuat(String DienThoaiXuat) {
        this.DienThoaiXuat = DienThoaiXuat;
    }
    
    
}
