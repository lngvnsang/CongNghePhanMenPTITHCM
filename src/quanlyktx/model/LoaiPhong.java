/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyktx.model;

/**
 *
 * @author luong
 */
public class LoaiPhong {
    String MaLoaiPhong;
    String TenLoaiPhong;
    int GiaTien;

    public LoaiPhong() {
    }

    public LoaiPhong(String MaLoaiPhong, String TenLoaiPhong, int GiaTien) {
        this.MaLoaiPhong = MaLoaiPhong;
        this.TenLoaiPhong = TenLoaiPhong;
        this.GiaTien = GiaTien;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return TenLoaiPhong;
    }

    public void setTenLoaiPhong(String TenLoaiPhong) {
        this.TenLoaiPhong = TenLoaiPhong;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }
    
}
