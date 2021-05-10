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
public class TableThuPhi {
    String MaHD;
    Date NgayPS;
    String MaPhong;
    String TenPS;
    String TongTien;
    String MaPS_Phong;

    public TableThuPhi() {
    }

    public TableThuPhi(String MaHD, Date NgayPS, String MaPhong, String TenPS, String TongTien, String MaPS_Phong) {
        this.MaHD = MaHD;
        this.NgayPS = NgayPS;
        this.MaPhong = MaPhong;
        this.TenPS = TenPS;
        this.TongTien = TongTien;
        this.MaPS_Phong = MaPS_Phong;
    }

    public String getMaPS_Phong() {
        return MaPS_Phong;
    }

    public void setMaPS_Phong(String MaPS_Phong) {
        this.MaPS_Phong = MaPS_Phong;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayPS() {
        return NgayPS;
    }

    public void setNgayPS(Date NgayPS) {
        this.NgayPS = NgayPS;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getTenPS() {
        return TenPS;
    }

    public void setTenPS(String TenPS) {
        this.TenPS = TenPS;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
