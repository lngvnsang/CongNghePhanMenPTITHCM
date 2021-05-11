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
public class CSVC {
    String Id;
    String MaPhong;
    String TenVatTu;
    Date NgayThem;
    String GhiChu;
    String TinhTrang;

    public CSVC() {
    }

    public CSVC(String Id, String MaPhong, String TenVatTu, Date NgayThem, String GhiChu, String TinhTrang) {
        this.Id = Id;
        this.MaPhong = MaPhong;
        this.TenVatTu = TenVatTu;
        this.NgayThem = NgayThem;
        this.GhiChu = GhiChu;
        this.TinhTrang = TinhTrang;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getTenVatTu() {
        return TenVatTu;
    }

    public void setTenVatTu(String TenVatTu) {
        this.TenVatTu = TenVatTu;
    }

    public Date getNgayThem() {
        return NgayThem;
    }

    public void setNgayThem(Date NgayThem) {
        this.NgayThem = NgayThem;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    
}
