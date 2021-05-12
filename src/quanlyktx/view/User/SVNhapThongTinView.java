/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyktx.view.User;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quanlyktx.DAO.DAO;
import quanlyktx.model.HopDong;
import quanlyktx.model.SinhVien;
import quanlyktx.model.ThanNhan;
import static quanlyktx.view.Admin.DangKyKTX.addDays;
import static quanlyktx.view.Admin.DangKyKTX.addMonths;
import quanlyktx.view.Admin.HelpView;
import quanlyktx.view.DangNhap.DangNhapView;

/**
 *
 * @author PHI LONG
 */
public class SVNhapThongTinView extends javax.swing.JFrame {

    /**
     * Creates new form NhapThongTinSV
     */
    
//    START OF FUNCTIONS
    
    public SVNhapThongTinView() {
        setIcon();
        initComponents();
        settingView.setVisible(false);
        btn_User.setVisible(false);
        btn_Help.setVisible(false);
        btn_LogOut.setVisible(false);
        txt_Lop.setEnabled(false);
        
        setLocationRelativeTo(null);
        
        controller = new DAO();
        showThongTinSV();
    }
    
    public SVNhapThongTinView(String id)
    {
        user = id;
        setIcon();
        initComponents();
        settingView.setVisible(false);
        btn_User.setVisible(false);
        btn_Help.setVisible(false);
        btn_LogOut.setVisible(false);
        setLocationRelativeTo(null);  
        
//        ImageIcon A = new ImageIcon(getClass().getResource("NhapThongTinSV.jpg"));
//        bg_NhapThongTinSV.setIcon(A);
        
        controller = new DAO();
        showThongTinSV();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
    
    public boolean checkEmpty(String key, String notify) {
        if (key.trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, notify);
            return false;
        }
        return true;
    }
    
    public boolean checkSoDienThoai(String sdt) {
        String ref = "\\d{10}";
        if (!sdt.trim().matches(ref)) {
            JOptionPane.showMessageDialog(rootPane, "Số điện thoại không đúng định dạng!");
            return false;
        }
        return true;
    }
    
    public boolean checkMSSV(String msv)
    {
        String pattern = "^[Nn]+[\\d]{2}+[A-Za-z]{4}+[\\d]{3}$";
        if(!msv.trim().matches(pattern))
        {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng MSSV \n Ví dụ đúng: N18DCCN123");
            return false;
        }
        return true;
    }
    
    public boolean checkLop(String lop)
    {
        String pattern = "^[Dd]+[\\d]{2}+[A-Za-z]{4}+[\\d]{2}$";
        if(!lop.trim().matches(pattern))
        {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng Lớp \n Ví dụ đúng: D18CQCN01");
            return false;
        }
        return true;
    }
    
    public boolean checkExist(String mssv) {
        students = controller.getListStudent();
        
        for (SinhVien student : students) {
            String ms = student.getMSSV().trim();
            if (ms.equals(mssv)) {
                HopDong hd = controller.getHopDongWithId(ms);
                if(checkThoiHan(hd.getNgayDangKy(), hd.getNgayKetThuc())){
                    JOptionPane.showMessageDialog(rootPane, "Sinh viên còn thời hạn đăng kí\n hợp đồng");
            return false;
                }
            }
        }
        return true;
    }
    
    boolean checkThoiHan(Date ngayDangKy, Date ngayKetThuc) {

        Date todayDate = java.util.Calendar.getInstance().getTime();
        if (!ngayDangKy.after(todayDate) && !ngayKetThuc.before(todayDate)) {
            return true;
        }
        return false;
    }
    
    public boolean checkBirthday(String key, String notify) {
        String ref = "^(0?[1-9]|[12][0-9]|3[01])[/](0?[1-9]|1[012])[/]\\d{4}$";
        if (!key.trim().matches(ref)) {
            JOptionPane.showMessageDialog(rootPane, notify);
            return false;
        }
        return true;
    }
    
    public void kiemTraNhap()
    {
        String ngayThangNamSinh = txt_NgThNmSinh.getText();
        String gioiTinh = rb_Nam.isSelected() ? "Nam" : "Nữ";
        try {
            if(checkEmpty(txt_HoTen.getText(), "Vui lòng nhập họ và tên!")
                    && checkEmpty(gioiTinh, "Vui lòng chọn giới tính!")
                    && checkEmpty(txt_MSSV.getText(), "Vui lòng nhập mã số sinh viên!") && checkMSSV(txt_MSSV.getText())
                    && checkEmpty(ngayThangNamSinh, "Vui lòng nhập ngày tháng năm sinh!") && checkBirthday(ngayThangNamSinh, "Không đúng đinh dạng ngày! \n Ví dụ đúng: 01/02/2000")
                    /*&& checkEmpty(txt_Lop.getText(), "Vui lòng nhập lớp!") && checkLop(txt_Lop.getText())*/
                    && checkEmpty(txt_QueQuan.getText(), "Vui lòng nhập quê quán!")
                    && checkEmpty(txt_SoDT.getText(), "Vui lòng nhập số điện thoại liên lạc!") && checkSoDienThoai(txt_SoDT.getText())
                    && checkEmpty(txt_DiaChi.getText(), "Vui lòng nhập địa chỉ!")
                    && checkEmpty(txt_NgThanTen.getText(), "Vui lòng nhập tên người thân!")
                    && checkEmpty(txt_NgThanSDT.getText(), "Vui lòng nhập số điện thoại người thân!")
                    && checkEmpty(txt_NgThanDiaChi.getText(), "Vui lòng nhập địa chỉ người thân!"))
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date ngaySinh = format.parse(ngayThangNamSinh);
                
                SinhVien sinhVien = 
                        new SinhVien(
                                txt_MSSV.getText().toUpperCase().trim(),
                                txt_HoTen.getText().trim(),
                                ngaySinh,
                                gioiTinh,
                                txt_QueQuan.getText().trim(),
                                txt_SoDT.getText().trim(),
                                txt_DiaChi.getText().trim(),
                                txt_MSSV.getText().toLowerCase().trim());
                
                ThanNhan thanNhan =
                        new ThanNhan(txt_MSSV.getText().toUpperCase().trim(), 
                                txt_NgThanTen.getText().trim(),
                                txt_NgThanDiaChi.getText().trim(),
                                txt_NgThanSDT.getText().trim());
                
                

                String[] options = {"Không", "Có"};
                int choice = JOptionPane.showOptionDialog(rootPane, "Bạn có chắc thông tin vừa nhập đúng chứ?", "Cảnh báo", 
                        JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.INFORMATION_MESSAGE, null, 
                        options, options[1]);
                if(choice == 1)
                {
                    System.out.println("Clicked yes");
                    if(controller.addStudent(sinhVien)) 
                    {
                        if(controller.addFamily(thanNhan))
                        {
                            JOptionPane.showMessageDialog(rootPane, "Lưu thông tin thành công!");
                            new SVChonPhongView(user).setVisible(true);
                            this.dispose();
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(rootPane, "Something went wrong...");
                        }
                    } 
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Thông tin nhập sai, hãy nhập lại!");
                    }
                }
                else
                {
                    System.out.println("Clicked no");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(SVNhapThongTinView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void showThongTinSV()
    {
        try {
            if(controller.getStudent(user) != null)
            {
                sinhVien = controller.getStudent(user);
                txt_HoTen.setText(sinhVien.getTen().trim());
                txt_MSSV.setText(sinhVien.getMSSV().trim());
                txt_NgThNmSinh.setText(sinhVien.getNgaySinh().toString().trim());
                txt_QueQuan.setText(sinhVien.getQueQuan().trim());
                txt_SoDT.setText(sinhVien.getSDT().trim());
                txt_DiaChi.setText(sinhVien.getDiaChi().trim());
                
                if(sinhVien.getGioiTinh().trim().equals("Nam"))
                {
                    rb_Nam.setSelected(true);
                }
                else
                {
                    rb_Nu.setSelected(false);
                }
                
                thanNhan = controller.getFamily(sinhVien.getMSSV());
                txt_NgThanTen.setText(thanNhan.getTenNgThan().trim());
                txt_NgThanDiaChi.setText(thanNhan.getDiaChiNgThan().trim());
                txt_NgThanSDT.setText(thanNhan.getSDTNgThan().trim());
                
                txt_HoTen.setEditable(false);
                txt_MSSV.setEditable(false);
                txt_Lop.setEditable(false);
                txt_NgThNmSinh.setEditable(false);
                txt_QueQuan.setEditable(false);
                txt_SoDT.setEditable(false);
                txt_DiaChi.setEditable(false);
                rb_Nam.setEnabled(false);
                rb_Nu.setEnabled(false);
                txt_NgThanTen.setEditable(false);
                txt_NgThanDiaChi.setEditable(false);
                txt_NgThanSDT.setEditable(false);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập thông tin \n Vui lòng nhập thông tin tại Đăng ký ngay");
                this.dispose();
            }
        } catch (Exception e) {
            Logger.getLogger(SVNhapThongTinView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
//    END OF FUNCTIONS

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rb_Nam = new javax.swing.JRadioButton();
        rb_Nu = new javax.swing.JRadioButton();
        btn_XacNhan = new javax.swing.JLabel();
        btn_User = new javax.swing.JLabel();
        btn_Setting = new javax.swing.JLabel();
        btn_LogOut = new javax.swing.JLabel();
        btn_Help = new javax.swing.JLabel();
        settingView = new javax.swing.JLabel();
        btn_Close = new javax.swing.JLabel();
        txt_HoTen = new javax.swing.JTextField();
        txt_MSSV = new javax.swing.JTextField();
        txt_Lop = new javax.swing.JTextField();
        txt_SoDT = new javax.swing.JTextField();
        txt_NgThNmSinh = new javax.swing.JTextField();
        txt_QueQuan = new javax.swing.JTextField();
        txt_DiaChi = new javax.swing.JTextField();
        txt_NgThanTen = new javax.swing.JTextField();
        txt_NgThanDiaChi = new javax.swing.JTextField();
        txt_NgThanSDT = new javax.swing.JTextField();
        bg_NhapThongTinSV = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 550));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rb_Nam.setBackground(new java.awt.Color(255, 255, 255));
        rb_Nam.setText("Nam");
        rb_Nam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_NamMouseClicked(evt);
            }
        });
        getContentPane().add(rb_Nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        rb_Nu.setBackground(new java.awt.Color(255, 255, 255));
        rb_Nu.setText("Nữ");
        rb_Nu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_NuMouseClicked(evt);
            }
        });
        getContentPane().add(rb_Nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, -1, -1));

        btn_XacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XacNhanMouseClicked(evt);
            }
        });
        getContentPane().add(btn_XacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 504, 150, 40));

        btn_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_UserMouseClicked(evt);
            }
        });
        getContentPane().add(btn_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 190, 50));

        btn_Setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SettingMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 190, 50));

        btn_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogOutMouseClicked(evt);
            }
        });
        getContentPane().add(btn_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 444, 190, 50));

        btn_Help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HelpMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Help, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 394, 190, 50));

        settingView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyktx/images/setting.jpg"))); // NOI18N
        getContentPane().add(settingView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 274, 190, 230));

        btn_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyktx/images/close.png"))); // NOI18N
        btn_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CloseMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, -1, -1));

        txt_HoTen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_HoTen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_HoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 240, 30));

        txt_MSSV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_MSSV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_MSSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 220, 30));

        txt_Lop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_Lop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_Lop, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 280, 30));

        txt_SoDT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_SoDT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_SoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 220, 30));

        txt_NgThNmSinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_NgThNmSinh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_NgThNmSinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 140, 30));

        txt_QueQuan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_QueQuan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_QueQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 240, 30));

        txt_DiaChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_DiaChi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_DiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 260, 30));

        txt_NgThanTen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_NgThanTen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_NgThanTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 340, 30));

        txt_NgThanDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_NgThanDiaChi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_NgThanDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 320, 30));

        txt_NgThanSDT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_NgThanSDT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txt_NgThanSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 350, 30));

        bg_NhapThongTinSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyktx/images/NhapThongTinSV.jpg"))); // NOI18N
        bg_NhapThongTinSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bg_NhapThongTinSVMouseClicked(evt);
            }
        });
        getContentPane().add(bg_NhapThongTinSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 561));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0; i <= 1; i += 0.2) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void bg_NhapThongTinSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_NhapThongTinSVMouseClicked
        // TODO add your handling code here:
        settingView.setVisible(false);
        flag = true;
    }//GEN-LAST:event_bg_NhapThongTinSVMouseClicked

    private void btn_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new SinhVienView(SinhVienView.taiKhoan).setVisible(true);
    }//GEN-LAST:event_btn_CloseMouseClicked

    private void btn_HelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HelpMouseClicked
        // TODO add your handling code here:
        settingView.setVisible(false);
        btn_User.setVisible(false);
        btn_Help.setVisible(false);
        btn_LogOut.setVisible(false);
        flag = true;
        System.out.println("click help");
        new HelpView().setVisible(true);
    }//GEN-LAST:event_btn_HelpMouseClicked

    private void btn_LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogOutMouseClicked
        // TODO add your handling code here:
        settingView.setVisible(false);
        btn_User.setVisible(false);
        btn_Help.setVisible(false);
        btn_LogOut.setVisible(false);
        flag = true;
        System.out.println("click logout");
        this.dispose();

        new DangNhapView().setVisible(true);
    }//GEN-LAST:event_btn_LogOutMouseClicked

    private void btn_SettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SettingMouseClicked
        // TODO add your handling code here:
        if (flag) {
            settingView.setVisible(true);
            btn_User.setVisible(true);
            btn_Help.setVisible(true);
            btn_LogOut.setVisible(true);
            flag = false;
        } else {
            settingView.setVisible(false);
            btn_User.setVisible(false);
            btn_Help.setVisible(false);
            btn_LogOut.setVisible(false);
            flag = true;
        }
    }//GEN-LAST:event_btn_SettingMouseClicked

    private void btn_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Bạn đang ở form hiện hành");
    }//GEN-LAST:event_btn_UserMouseClicked

    private void btn_XacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XacNhanMouseClicked
        // TODO add your handling code here:
        kiemTraNhap();
    }//GEN-LAST:event_btn_XacNhanMouseClicked

    private void rb_NuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_NuMouseClicked
        // TODO add your handling code here:
        if(rb_Nu.isSelected())
        {
            rb_Nam.setSelected(false);
        }
    }//GEN-LAST:event_rb_NuMouseClicked

    private void rb_NamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_NamMouseClicked
        // TODO add your handling code here:
        if(rb_Nam.isSelected())
        {
            rb_Nu.setSelected(false);
        }
    }//GEN-LAST:event_rb_NamMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SVNhapThongTinView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SVNhapThongTinView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SVNhapThongTinView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SVNhapThongTinView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SVNhapThongTinView().setVisible(true);
            }
        });
    }
    
//    VARIABLES DECLARATION
    private DAO controller;
    private boolean flag = true;
    SinhVien sinhVien;
    ThanNhan thanNhan;
    List<SinhVien> students;
    static String user = "";
//    END OF VARIABLES DECLARATION

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg_NhapThongTinSV;
    private javax.swing.JLabel btn_Close;
    private javax.swing.JLabel btn_Help;
    private javax.swing.JLabel btn_LogOut;
    private javax.swing.JLabel btn_Setting;
    private javax.swing.JLabel btn_User;
    private javax.swing.JLabel btn_XacNhan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton rb_Nam;
    private javax.swing.JRadioButton rb_Nu;
    private javax.swing.JLabel settingView;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_HoTen;
    private javax.swing.JTextField txt_Lop;
    private javax.swing.JTextField txt_MSSV;
    private javax.swing.JTextField txt_NgThNmSinh;
    private javax.swing.JTextField txt_NgThanDiaChi;
    private javax.swing.JTextField txt_NgThanSDT;
    private javax.swing.JTextField txt_NgThanTen;
    private javax.swing.JTextField txt_QueQuan;
    private javax.swing.JTextField txt_SoDT;
    // End of variables declaration//GEN-END:variables
}
