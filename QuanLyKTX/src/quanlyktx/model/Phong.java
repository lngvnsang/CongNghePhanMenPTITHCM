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
public class Phong {
    String MaPhong;
    String MaDay;
    int ToiThieu;
    int ToiDa;
    int  TinhTrang;
    String MaLoaiPhong;

    public Phong() {
    }

    public Phong(String MaPhong, String MaDay, int ToiThieu, int ToiDa, int TinhTrang, String MaLoaiPhong) {
        this.MaPhong = MaPhong;
        this.MaDay = MaDay;
        this.ToiThieu = ToiThieu;
        this.ToiDa = ToiDa;
        this.TinhTrang = TinhTrang;
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaDay() {
        return MaDay;
    }

    public void setMaDay(String MaDay) {
        this.MaDay = MaDay;
    }

    public int getToiThieu() {
        return ToiThieu;
    }

    public void setToiThieu(int ToiThieu) {
        this.ToiThieu = ToiThieu;
    }

    public int getToiDa() {
        return ToiDa;
    }

    public void setToiDa(int ToiDa) {
        this.ToiDa = ToiDa;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }
    
}
