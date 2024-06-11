/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hoàng
 */
public class Employee {
    private String IDNhanVien;
    private String tenNhanVien;
    private int tuoiNhanVien;
    private String viTriNhanVien;
    private String emailNhanVien;
    private String dienThoaiNhanVien;

    public Employee() {
    }

    public Employee(String IDNhanVien, String tenNhanVien, int tuoiNhanVien, String viTriNhanVien, String emailNhanVien, String dienThoaiNhanVien) {
        this.IDNhanVien = IDNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.viTriNhanVien = viTriNhanVien;
        this.emailNhanVien = emailNhanVien;
        this.dienThoaiNhanVien = dienThoaiNhanVien;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getTuoiNhanVien() {
        return tuoiNhanVien;
    }

    public void setTuoiNhanVien(int tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }

    public String getViTriNhanVien() {
        return viTriNhanVien;
    }

    public void setViTriNhanVien(String viTriNhanVien) {
        this.viTriNhanVien = viTriNhanVien;
    }

    public String getEmailNhanVien() {
        return emailNhanVien;
    }

    public void setEmailNhanVien(String emailNhanVien) {
        this.emailNhanVien = emailNhanVien;
    }

    public String getDienThoaiNhanVien() {
        return dienThoaiNhanVien;
    }

    public void setDienThoaiNhanVien(String dienThoaiNhanVien) {
        this.dienThoaiNhanVien = dienThoaiNhanVien;
    }
    
    
}
