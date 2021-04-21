/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyktx.model;

import java.util.Date;

/**
 *
 * @author luong
 */
public class SinhVien {
    String MSSV;
    String Ten;
    Date NgaySinh;
    String GioiTinh;
    String QueQuan;
    String SDT;
    String DiaChi;
    String TTKSinhVien;

    public SinhVien() {
    }

    public SinhVien(String MSSV, String Ten, Date NgaySinh, String GioiTinh, String QueQuan, String SDT, String DiaChi, String TTKSinhVien) {
        this.MSSV = MSSV;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.QueQuan = QueQuan;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.TTKSinhVien = TTKSinhVien;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTTKSinhVien() {
        return TTKSinhVien;
    }

    public void setTTKSinhVien(String TTKSinhVien) {
        this.TTKSinhVien = TTKSinhVien;
    }
    
}
