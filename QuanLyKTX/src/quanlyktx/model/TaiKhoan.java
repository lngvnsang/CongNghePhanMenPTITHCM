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
public class TaiKhoan {
    String TenTK;
    String MatKhau;
    String Email;
    int ID_role;

    public TaiKhoan() {
    }

    public TaiKhoan(String TenTK, String MatKhau, String Email, int ID_role) {
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.ID_role = ID_role;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getID_role() {
        return ID_role;
    }

    public void setID_role(int ID_role) {
        this.ID_role = ID_role;
    }
    
}
