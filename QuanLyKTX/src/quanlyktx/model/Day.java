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
public class Day {
    String MaDay;
    String TenDay;
    String GioiTinh;
    String TinhTrang;

    public Day() {
    }

    public Day(String MaDay, String TenDay, String GioiTinh, String TinhTrang) {
        this.MaDay = MaDay;
        this.TenDay = TenDay;
        this.GioiTinh = GioiTinh;
        this.TinhTrang = TinhTrang;
    }

    public String getMaDay() {
        return MaDay;
    }

    public void setMaDay(String MaDay) {
        this.MaDay = MaDay;
    }

    public String getTenDay() {
        return TenDay;
    }

    public void setTenDay(String TenDay) {
        this.TenDay = TenDay;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    
}
