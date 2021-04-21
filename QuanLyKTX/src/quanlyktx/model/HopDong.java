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
public class HopDong {
    String ID_HopDong;
    String IDQuanLy;
    String MSSV;
    String MaPhong;
    int SoTienTra;
    Date HanTra;
    int TinhTrang;
    Date NgayDangKy;
    Date NgayKetThuc;
    Date NgayRoiDi;

    public HopDong() {
    }

    public HopDong(String ID_HopDong, String IDQuanLy, String MSSV, String MaPhong, int SoTienTra, Date HanTra, int TinhTrang, Date NgayDangKy, Date NgayKetThuc, Date NgayRoiDi) {
        this.ID_HopDong = ID_HopDong;
        this.IDQuanLy = IDQuanLy;
        this.MSSV = MSSV;
        this.MaPhong = MaPhong;
        this.SoTienTra = SoTienTra;
        this.HanTra = HanTra;
        this.TinhTrang = TinhTrang;
        this.NgayDangKy = NgayDangKy;
        this.NgayKetThuc = NgayKetThuc;
        this.NgayRoiDi = NgayRoiDi;
    }

    public String getID_HopDong() {
        return ID_HopDong;
    }

    public void setID_HopDong(String ID_HopDong) {
        this.ID_HopDong = ID_HopDong;
    }

    public String getIDQuanLy() {
        return IDQuanLy;
    }

    public void setIDQuanLy(String IDQuanLy) {
        this.IDQuanLy = IDQuanLy;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public int getSoTienTra() {
        return SoTienTra;
    }

    public void setSoTienTra(int SoTienTra) {
        this.SoTienTra = SoTienTra;
    }

    public Date getHanTra() {
        return HanTra;
    }

    public void setHanTra(Date HanTra) {
        this.HanTra = HanTra;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public Date getNgayRoiDi() {
        return NgayRoiDi;
    }

    public void setNgayRoiDi(Date NgayRoiDi) {
        this.NgayRoiDi = NgayRoiDi;
    }
    
    
}
