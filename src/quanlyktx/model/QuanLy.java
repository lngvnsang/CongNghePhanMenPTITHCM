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
public class QuanLy {
    String IDQuanLy;
    String Ten;
    String SDT;
    String TTKQuanLy;

    public QuanLy() {
    }

    public QuanLy(String IDQuanLy, String Ten, String SDT, String TTKQuanLy) {
        this.IDQuanLy = IDQuanLy;
        this.Ten = Ten;
        this.SDT = SDT;
        this.TTKQuanLy = TTKQuanLy;
    }

    public String getIDQuanLy() {
        return IDQuanLy;
    }

    public void setIDQuanLy(String IDQuanLy) {
        this.IDQuanLy = IDQuanLy;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTTKQuanLy() {
        return TTKQuanLy;
    }

    public void setTTKQuanLy(String TTKQuanLy) {
        this.TTKQuanLy = TTKQuanLy;
    }
    
}
