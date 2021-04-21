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
public class ThanNhan {
    String MSSV;
    String TenNgThan;
    String  DiaChiNgThan;
    String SDTNgThan;

    public ThanNhan() {
    }

    public ThanNhan(String MSSV, String TenNgThan, String DiaChiNgThan, String SDTNgThan) {
        this.MSSV = MSSV;
        this.TenNgThan = TenNgThan;
        this.DiaChiNgThan = DiaChiNgThan;
        this.SDTNgThan = SDTNgThan;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getTenNgThan() {
        return TenNgThan;
    }

    public void setTenNgThan(String TenNgThan) {
        this.TenNgThan = TenNgThan;
    }

    public String getDiaChiNgThan() {
        return DiaChiNgThan;
    }

    public void setDiaChiNgThan(String DiaChiNgThan) {
        this.DiaChiNgThan = DiaChiNgThan;
    }

    public String getSDTNgThan() {
        return SDTNgThan;
    }

    public void setSDTNgThan(String SDTNgThan) {
        this.SDTNgThan = SDTNgThan;
    }
    
    
}
