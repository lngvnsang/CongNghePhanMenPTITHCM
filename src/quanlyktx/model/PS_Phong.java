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
public class PS_Phong {

    String maPS_Phong;
    String maHD;
    String maPS;
    Date ngayPS;
    int SL;

    public PS_Phong() {
    }

    public PS_Phong(String maPS_Phong, String maHD, String maPS, Date ngayPS, int SL) {
        this.maPS_Phong = maPS_Phong;
        this.maHD = maHD;
        this.maPS = maPS;
        this.ngayPS = ngayPS;
        this.SL = SL;
    }

    public String getMaPS_Phong() {
        return maPS_Phong;
    }

    public void setMaPS_Phong(String maPS_Phong) {
        this.maPS_Phong = maPS_Phong;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaPS() {
        return maPS;
    }

    public void setMaPS(String maPS) {
        this.maPS = maPS;
    }

    public Date getNgayPS() {
        return ngayPS;
    }

    public void setNgayPS(Date ngayPS) {
        this.ngayPS = ngayPS;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

}
