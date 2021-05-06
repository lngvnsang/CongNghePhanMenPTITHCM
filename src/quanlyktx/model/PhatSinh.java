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
public class PhatSinh {

    String maPS;
    String tenPS;
    int giaTienPS;
    String donViTinh;

    public PhatSinh(String maPS, String tenPS, int giaTienPS, String donViTinh) {
        this.maPS = maPS;
        this.tenPS = tenPS;
        this.giaTienPS = giaTienPS;
        this.donViTinh = donViTinh;
    }

    public PhatSinh() {
    }

    public String getMaPS() {
        return maPS;
    }

    public void setMaPS(String maPS) {
        this.maPS = maPS;
    }

    public String getTenPS() {
        return tenPS;
    }

    public void setTenPS(String tenPS) {
        this.tenPS = tenPS;
    }

    public int getGiaTienPS() {
        return giaTienPS;
    }

    public void setGiaTienPS(int giaTienPS) {
        this.giaTienPS = giaTienPS;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

}
