/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyktx.view.Admin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import quanlyktx.DAO.DAO;
import quanlyktx.model.Day;
import quanlyktx.model.Phong;

/**
 *
 * @author luong
 */
public class ThemPhong extends javax.swing.JDialog {

    private List<Day> ranges;
    private DAO controller;
    QuanLyPhongView home;

    /**
     * Creates new form ThemPhong
     */
    public ThemPhong(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controller = new DAO();
        home = (QuanLyPhongView) parent;

        ranges = controller.getListRange();
        cb_day.removeAllItems();
        for (Day range : ranges) {
            cb_day.addItem(range.getTenDay());
        }
        txtToiDa.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        txtToiThieu.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cb_day = new javax.swing.JComboBox<>();
        cb_thinh_trang = new javax.swing.JComboBox<>();
        cb_loai_phong = new javax.swing.JComboBox<>();
        txtToiThieu = new javax.swing.JTextField();
        txtToiDa = new javax.swing.JTextField();
        txtMaPhong = new javax.swing.JTextField();
        btn_cancle = new javax.swing.JLabel();
        btn_save = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_day.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        cb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        cb_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_dayActionPerformed(evt);
            }
        });
        getContentPane().add(cb_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 260, -1));

        cb_thinh_trang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đóng", "Mở" }));
        cb_thinh_trang.setBorder(new javax.swing.border.MatteBorder(null));
        cb_thinh_trang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(cb_thinh_trang, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 260, -1));

        cb_loai_phong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dịch vụ 1", "Dịch vụ 2", "Thường" }));
        cb_loai_phong.setBorder(new javax.swing.border.MatteBorder(null));
        cb_loai_phong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(cb_loai_phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 225, 260, -1));

        txtToiThieu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtToiThieu.setBorder(null);
        getContentPane().add(txtToiThieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 260, 25));

        txtToiDa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtToiDa.setBorder(null);
        getContentPane().add(txtToiDa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 260, 25));

        txtMaPhong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMaPhong.setBorder(null);
        getContentPane().add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 260, 25));

        btn_cancle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancleMouseClicked(evt);
            }
        });
        getContentPane().add(btn_cancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 75, 38));

        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 82, 38));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyktx/images/Them_thong_tin_PHONG.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(500, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        if (checkEmpty(txtMaPhong.getText().trim(), "Mã dãy?")
                && checkEmpty(txtToiThieu.getText().trim(), "Phòng tối thiểu?")
                && checkEmpty(txtToiDa.getText().trim(), "Phòng tối đa?")
                && !cb_day.getSelectedItem().equals("Default")) {
            Phong phong = new Phong();

            phong.setMaPhong(txtMaPhong.getText().trim().toUpperCase());
            phong.setMaDay(ranges.get(cb_day.getSelectedIndex()).getMaDay().trim());
            String loaiP = "";
            if (cb_loai_phong.getSelectedIndex() == 0) {
                loaiP = "L1";
            } else if (cb_loai_phong.getSelectedIndex() == 1) {
                loaiP = "L2";
            } else if (cb_loai_phong.getSelectedIndex() == 2) {
                loaiP = "L3";
            }

            phong.setMaLoaiPhong(loaiP);
            phong.setToiDa(Integer.parseInt(txtToiDa.getText().trim()));
            phong.setToiThieu(Integer.parseInt(txtToiThieu.getText().trim()));
            int tt = cb_thinh_trang.getSelectedItem().toString().trim() == "Đóng" ? 0 : 1;
            phong.setTinhTrang(tt);

            if (controller.addRoom(phong)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm phòng thành công!");
                home.updateEdit();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm phòng thất bại!");
            }
        }
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_cancleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancleMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_cancleMouseClicked

    private void cb_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_dayActionPerformed

    }//GEN-LAST:event_cb_dayActionPerformed

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
            java.util.logging.Logger.getLogger(ThemPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemPhong dialog = new ThemPhong(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public boolean checkEmpty(String key, String notify) {
        if (key.trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, notify);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_cancle;
    private javax.swing.JLabel btn_save;
    private javax.swing.JComboBox<String> cb_day;
    private javax.swing.JComboBox<String> cb_loai_phong;
    private javax.swing.JComboBox<String> cb_thinh_trang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtToiDa;
    private javax.swing.JTextField txtToiThieu;
    // End of variables declaration//GEN-END:variables

}
