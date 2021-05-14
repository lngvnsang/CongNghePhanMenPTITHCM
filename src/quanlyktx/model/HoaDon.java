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
public class HoaDon {

    String maHD;
    String maPhong;
    Date ngayTaoHD;
    int tongTien;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maPhong, int tongTien, Date ngayTaoHD) {
        this.maHD = maHD;
        this.maPhong = maPhong;
        this.ngayTaoHD = ngayTaoHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }


    public Date getNgayTaoHD() {
        return ngayTaoHD;
    }

    public void setNgayTaoHD(Date ngayTaoHD) {
        this.ngayTaoHD = ngayTaoHD;
    }

    public void setTongTien(int tongTien)
    {
        this.tongTien = tongTien;
    }
    
    public int getTongTien()
    {
        return tongTien;
    }
    
}
