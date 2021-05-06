/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyktx.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;
import quanlyktx.model.Day;
import quanlyktx.model.HopDong;
import quanlyktx.model.LoaiPhong;
import quanlyktx.model.Phong;
import quanlyktx.model.SinhVien;
import quanlyktx.model.TaiKhoan;
import quanlyktx.model.ThanNhan;

/**
 *
 * @author luong
 */
public class DAO {

    private Connection conn;

    public DAO() {
        String url = "jdbc:sqlserver://localhost:1433;databasename=QLY_KTX_Mk3";
        String user = "sa";
        String password = "12345678";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addAccountStudent(TaiKhoan t) {
        String sql = "INSERT INTO TaiKhoan(TenTK,MatKhau,Email,ID_role) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTenTK());
            ps.setString(2, t.getMatKhau());
            ps.setString(3, t.getEmail());
            ps.setInt(4, t.getID_role());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<TaiKhoan> getListAccountStudent() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String sql = "SELECT * FROM TaiKhoan";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenTK(rs.getString("TenTK"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setEmail(rs.getString("Email"));
                tk.setID_role(rs.getInt("ID_role"));
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addFamily(ThanNhan tn) {
        String sql = "INSERT INTO ThanNhan(MSSV,TenNgThan,DiaChiNgThan,SDTNgThan) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tn.getMSSV());
            ps.setString(2, tn.getTenNgThan());
            ps.setString(3, tn.getDiaChiNgThan());
            ps.setString(4, tn.getSDTNgThan());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ThanNhan getFamily(String mssv) {
        String sql = "SELECT * FROM ThanNhan WHERE MSSV = '" + mssv + "';";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ((rs.next())) {
                ThanNhan tn = new ThanNhan();
                tn.setMSSV(rs.getString("MSSV"));
                tn.setTenNgThan(rs.getString("TenNgThan"));
                tn.setDiaChiNgThan(rs.getString("DiaChiNgThan"));
                tn.setSDTNgThan(rs.getString("SDTNgThan"));

                return tn;
            } else {
                System.out.println("Not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addStudent(SinhVien s) {
        String sql = "INSERT INTO SinhVien(MSSV,Ten,NgaySinh,GioiTinh,QueQuan,SDT,DiaChi,TTKSinhVien) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMSSV());
            ps.setString(2, s.getTen());
            ps.setDate(3, (java.sql.Date) new java.sql.Date(s.getNgaySinh().getTime()));
            ps.setString(4, s.getGioiTinh());
            ps.setString(5, s.getQueQuan());
            ps.setString(6, s.getSDT());
            ps.setString(7, s.getDiaChi());
            ps.setString(8, s.getTTKSinhVien());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(SinhVien s) {
        String sql = "UPDATE SinhVien SET "
                + "Ten = N'" + s.getTen() + "',"
                + "NgaySinh = '" + (java.sql.Date) new java.sql.Date(s.getNgaySinh().getTime()) + "',"
                + "GioiTinh = N'" + s.getGioiTinh() + "',"
                + "QueQuan = N'" + s.getQueQuan() + "',"
                + "SDT = '" + s.getSDT() + "',"
                + "DiaChi = N'" + s.getDiaChi() + "'"
                + " WHERE MSSV = '" + s.getMSSV() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(String mssv) {
        String sql = "DELETE FROM SinhVien WHERE MSSV = '" + mssv + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public SinhVien getStudent(String tk) {
        String sql = "SELECT * FROM SinhVien WHERE TTKSinhVien = '" + tk + "';";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ((rs.next())) {
                SinhVien sv = new SinhVien();
                sv.setMSSV(rs.getString("MSSV"));
                sv.setTen(rs.getString("Ten"));
                sv.setNgaySinh(rs.getDate("NgaySinh"));
                sv.setGioiTinh(rs.getString("GioiTinh"));
                sv.setQueQuan(rs.getString("QueQuan"));
                sv.setSDT(rs.getString("SDT"));
                sv.setDiaChi(rs.getString("DiaChi"));
                sv.setTTKSinhVien(rs.getString("TTKSinhVien"));
                return sv;
            } else {
                System.out.println("Not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<SinhVien> getListStudentSearch(String key) {
        ArrayList<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien WHERE Ten LIKE N'%" + key + "%' OR MSSV LIKE N'%" + key + "%';";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMSSV(rs.getString("MSSV"));
                sv.setTen(rs.getString("Ten"));
                sv.setNgaySinh(rs.getDate("NgaySinh"));
                sv.setGioiTinh(rs.getString("GioiTinh"));
                sv.setQueQuan(rs.getString("QueQuan"));
                sv.setSDT(rs.getString("SDT"));
                sv.setDiaChi(rs.getString("DiaChi"));
                sv.setTTKSinhVien(rs.getString("TTKSinhVien"));
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<SinhVien> getListStudent() {
        ArrayList<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMSSV(rs.getString("MSSV"));
                sv.setTen(rs.getString("Ten"));
                sv.setNgaySinh(rs.getDate("NgaySinh"));
                sv.setGioiTinh(rs.getString("GioiTinh"));
                sv.setQueQuan(rs.getString("QueQuan"));
                sv.setSDT(rs.getString("SDT"));
                sv.setDiaChi(rs.getString("DiaChi"));
                sv.setTTKSinhVien(rs.getString("TTKSinhVien"));
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean addRoom(Phong p) {
        String sql = "INSERT INTO Phong(MaPhong,MaDay,ToiThieu,ToiDa,TinhTrang,MaLoaiPhong) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getMaPhong());
            ps.setString(2, p.getMaDay());
            ps.setInt(3, p.getToiThieu());
            ps.setInt(4, p.getToiDa());
            ps.setInt(5, p.getTinhTrang());
            ps.setString(6, p.getMaLoaiPhong());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Phong> getListRoom() {
        ArrayList<Phong> list = new ArrayList<>();
        String sql = "SELECT * FROM Phong";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Phong p = new Phong();
                p.setMaPhong(rs.getString("MaPhong"));
                p.setMaDay(rs.getString("MaDay"));
                p.setToiThieu(rs.getInt("ToiThieu"));
                p.setToiDa(rs.getInt("ToiDa"));
                p.setTinhTrang(rs.getInt("TinhTrang"));
                p.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Phong getRoom(String id) {
        String sql = "SELECT * FROM Phong WHERE MaPhong = '" + id.trim() + "'";
        Phong p = new Phong();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                p.setMaPhong(rs.getString("MaPhong"));
                p.setMaDay(rs.getString("MaDay"));
                p.setToiThieu(rs.getInt("ToiThieu"));
                p.setToiDa(rs.getInt("ToiDa"));
                p.setTinhTrang(rs.getInt("TinhTrang"));
                p.setMaLoaiPhong(rs.getString("MaLoaiPhong"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    public ArrayList<Phong> getListRoomByIDRange(String id) {
        ArrayList<Phong> list = new ArrayList<>();
        String sql = "SELECT * FROM Phong WHERE MaDay = N'" + id + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Phong p = new Phong();
                p.setMaPhong(rs.getString("MaPhong"));
                p.setMaDay(rs.getString("MaDay"));
                p.setToiThieu(rs.getInt("ToiThieu"));
                p.setToiDa(rs.getInt("ToiDa"));
                p.setTinhTrang(rs.getInt("TinhTrang"));
                p.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void showDataDetailPhong(DefaultTableModel model, String id) {
        String sql = "SELECT SinhVien.Ten, SinhVien.MSSV, SinhVien.QueQuan, HopDong.NgayDangKy, HopDong.NgayKetThuc FROM Phong, HopDong, SinhVien WHERE Phong.MaPhong = HopDong.MaPhong AND HopDong.MSSV = SinhVien.MSSV AND Phong.MaPhong ='"+id.trim()+"'";
        int i = 1;
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                i++,
                rs.getString("Ten"),
                rs.getString("MSSV"),
                rs.getString("QueQuan"),
                rs.getDate("NgayDangKy"),
                rs.getDate("NgayKetThuc")
            });
                        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LoaiPhong getCategoryRoomByIDCategoryRoom(String id) {
        LoaiPhong loaiPhong = new LoaiPhong();
        String sql = "SELECT * FROM LoaiPhong WHERE MaLoaiPhong = N'" + id + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loaiPhong.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                loaiPhong.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
                loaiPhong.setGiaTien(rs.getInt("GiaTien"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loaiPhong;
    }

    public ArrayList<Day> getListRange() {
        ArrayList<Day> list = new ArrayList<>();
        String sql = "SELECT * FROM Day";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Day d = new Day();
                d.setMaDay(rs.getString("MaDay"));
                d.setTenDay(rs.getString("TenDay"));
                d.setGioiTinh(rs.getString("GioiTinh"));
                d.setTinhTrang(rs.getString("TinhTrang"));
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
//////////////////////////////////////////////////////////////////////////

    public boolean addHopDong(HopDong s) {
        String sql = "INSERT INTO HopDong(ID_HopDong,IDQuanLy,MSSV,MaPhong,SoTienTra,HanTra,TinhTrang,NgayDangKy,NgayKetThuc) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getID_HopDong());
            ps.setString(2, s.getIDQuanLy());
            ps.setString(3, s.getMSSV());
            ps.setString(4, s.getMaPhong());
            ps.setInt(5, s.getSoTienTra());
            ps.setDate(6, (java.sql.Date) new java.sql.Date(s.getHanTra().getTime()));
            ps.setInt(7, s.getTinhTrang());
            ps.setDate(8, (java.sql.Date) new java.sql.Date(s.getNgayDangKy().getTime()));
            ps.setDate(9, (java.sql.Date) new java.sql.Date(s.getNgayKetThuc().getTime()));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<HopDong> getListHopDong() {
        ArrayList<HopDong> list = new ArrayList<>();
        String sql = "SELECT * FROM HopDong";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setID_HopDong(rs.getString("ID_HopDong"));
                hd.setIDQuanLy(rs.getString("IDQuanLy"));
                hd.setMSSV(rs.getString("MSSV"));
                hd.setMaPhong(rs.getString("MaPhong"));
                hd.setSoTienTra(rs.getInt("SoTienTra"));
                hd.setHanTra(rs.getDate("HanTra"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                hd.setNgayDangKy(rs.getDate("NgayDangKy"));
                hd.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                hd.setNgayRoiDi(rs.getDate("NgayRoiDi"));
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public HopDong getHopDongWithId(String masv) {
        HopDong hd = new HopDong();
        String sql = "SELECT * FROM HopDong WHERE MSSV = '" + masv + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hd.setID_HopDong(rs.getString("ID_HopDong"));
                hd.setIDQuanLy(rs.getString("IDQuanLy"));
                hd.setMSSV(rs.getString("MSSV"));
                hd.setMaPhong(rs.getString("MaPhong"));
                hd.setSoTienTra(rs.getInt("SoTienTra"));
                hd.setHanTra(rs.getDate("HanTra"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                hd.setNgayDangKy(rs.getDate("NgayDangKy"));
                hd.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                hd.setNgayRoiDi(rs.getDate("NgayRoiDi"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }
    
    ///////////////////////////////////////////Thống kê////////////////////////////////////////////
    
    public DefaultCategoryDataset getTotalStudentWithYear() {
        DefaultCategoryDataset datas = new DefaultCategoryDataset();
        String sql = "SELECT YEAR(NgayDangKy) AS 'Nam', COUNT(MSSV) AS 'SoLuong' FROM HopDong GROUP BY YEAR(NgayDangKy) ORDER BY Nam";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datas.setValue((int)rs.getInt("SoLuong"), rs.getString("Nam"), rs.getString("Nam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
    
    public ArrayList<Day> getDayByGioiTinh(String gioiTinh) {
        ArrayList<Day> list = new ArrayList<>();
        String sql = "SELECT * FROM Day WHERE GioiTinh = N'" + gioiTinh + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Day d = new Day();
                d.setMaDay(rs.getString("MaDay"));
                d.setTenDay(rs.getString("TenDay"));
                d.setGioiTinh(rs.getString("GioiTinh"));
                d.setTinhTrang(rs.getString("TinhTrang"));
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        new DAO().getTotalStudentWithYear();
    }

}
