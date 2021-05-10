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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;
import quanlyktx.model.Day;
import quanlyktx.model.HoaDon;
import quanlyktx.model.HopDong;
import quanlyktx.model.LoaiPhong;
import quanlyktx.model.PS_Phong;
import quanlyktx.model.PhatSinh;
import quanlyktx.model.Phong;
import quanlyktx.model.SinhVien;
import quanlyktx.model.TableThuPhi;
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

    public boolean updateThoiHan(String mssv, int thoiHan) {
        String sql = "UPDATE HopDong SET "
                + "TinhTrang  = " + thoiHan + ""
                + " WHERE MSSV = '" + mssv.trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

////////////////////////////////////////////////////////Phòng//////////////////////////////////////////////
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

    public boolean updateRoom(Phong p) {
        System.out.println(p.getMaLoaiPhong().trim() + "_____");
        String sql = "UPDATE Phong SET "
                + "MaDay  = '" + p.getMaDay().trim() + "', "
                + "ToiThieu = " + p.getToiThieu() + ", "
                + "ToiDa = " + p.getToiDa() + ", "
                + "TinhTrang = " + p.getTinhTrang() + ", "
                + "MaLoaiPhong = '" + p.getMaLoaiPhong().trim() + "' "
                + " WHERE MaPhong = '" + p.getMaPhong().trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePhong(String d) {
        System.out.println(d + "++++++");
        String sql = "DELETE FROM Phong WHERE MaPhong = '" + d.trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        String sql = "SELECT SinhVien.Ten, SinhVien.MSSV, SinhVien.QueQuan, HopDong.NgayDangKy, HopDong.NgayKetThuc FROM Phong, HopDong, SinhVien WHERE Phong.MaPhong = HopDong.MaPhong AND HopDong.MSSV = SinhVien.MSSV AND Phong.MaPhong ='" + id.trim() + "'";
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
////////////////////////////////////////////////////Hợp đồng////////////////////////////////////////////////////////

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

//     public boolean editInfoRoom(String d) {
//          String sql = "UPDATE Phong SET "
//                + "Ten = N'" + s.getTen() + "',"
//                + "NgaySinh = '" + (java.sql.Date) new java.sql.Date(s.getNgaySinh().getTime()) + "',"
//                + "GioiTinh = N'" + s.getGioiTinh() + "',"
//                + "QueQuan = N'" + s.getQueQuan() + "',"
//                + "SDT = '" + s.getSDT() + "',"
//                + "DiaChi = N'" + s.getDiaChi() + "'"
//                + " WHERE MaPhong = '" + d.trim() + "'";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//     }
    ///////////////////////////////////////////Thống kê////////////////////////////////////////////
    public DefaultCategoryDataset getTotalStudentWithYear() {
        DefaultCategoryDataset datas = new DefaultCategoryDataset();
        String sql = "SELECT YEAR(NgayDangKy) AS 'Nam', COUNT(MSSV) AS 'SoLuong' FROM HopDong GROUP BY YEAR(NgayDangKy) ORDER BY Nam";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datas.setValue((int) rs.getInt("SoLuong"), rs.getString("Nam"), rs.getString("Nam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    public DefaultCategoryDataset getTotalStudentInRoom(String phong) {
        DefaultCategoryDataset datas = new DefaultCategoryDataset();
        //System.out.println("." + phong + ".");
        String sql = "SELECT YEAR(NgayDangKy) AS 'Nam', COUNT(MSSV) AS 'SoLuong' FROM HopDong WHERE MaPhong = '" + phong + "' GROUP BY YEAR(NgayDangKy)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Nam"));
                datas.setValue(rs.getInt("SoLuong"), rs.getString("Nam"), rs.getString("Nam"));
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

    public List<Integer> getYear() {
        String sql = "SELECT DISTINCT  YEAR(NgayDangKy) AS Nam FROM HopDong ORDER BY YEAR(NgayDangKy) DESC";
        List<Integer> years = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                years.add(rs.getInt("Nam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return years;
    }

    public DefaultCategoryDataset getListRoomwithNumberStudentByIDRange(int nam, String maDay, DefaultTableModel model) {

        DefaultCategoryDataset datas = new DefaultCategoryDataset();
        //System.out.println("." + phong + ".");
        String sql = "SELECT Phong.MaPhong, COUNT(HopDong.MSSV) AS SoLuong "
                + "FROM HopDong, Phong "
                + "WHERE YEAR(NgayDangKy) = " + nam + " "
                + "AND Phong.MaPhong = HopDong.MaPhong "
                + "AND Phong.MaDay = '" + maDay.trim() + "' "
                + "GROUP BY Phong.MaPhong ";

        try {
            int i = 1;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                datas.setValue(rs.getInt("SoLuong"), rs.getString("MaPhong"), rs.getString("MaPhong"));

                model.addRow(new Object[]{
                    i++,
                    rs.getString("MaPhong"),
                    rs.getInt("SoLuong"),});

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    public DefaultCategoryDataset getTotalCostStudentWithEveryYear(DefaultTableModel modelTPKTX) {
        DefaultCategoryDataset datas = new DefaultCategoryDataset();
        //System.out.println("." + phong + ".");
        String sql = "SELECT YEAR(NgayDangKy) AS Nam, SUM(SoTienTra) AS TongTien FROM HopDong GROUP BY YEAR(NgayDangKy) ORDER BY YEAR(NgayDangKy) DESC";
        int i = 1;
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datas.setValue(rs.getInt("TongTien"), rs.getString("Nam"), rs.getString("Nam"));

                modelTPKTX.addRow(new Object[]{
                    i++,
                    rs.getInt("Nam"),
                    formatter.format(rs.getInt("TongTien")) + " vnđ",});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    public DefaultCategoryDataset getTotalCostServicesWithEveryYear(DefaultTableModel modelTPPS) {
        DefaultCategoryDataset datas = new DefaultCategoryDataset();
        String sql = "WITH T AS ( "
                + "	SELECT HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS, PS_Phong.MaPS_Phong, SUM(GiaTienPS* SL) AS TongTien "
                + "	FROM HoaDon, PhatSinh, PS_Phong "
                + "	WHERE HoaDon.MaHD = PS_Phong.MaHD "
                + "	AND PS_Phong.MaPS = PhatSinh.MaPS "
                + "	GROUP BY HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS, PS_Phong.MaPS_Phong "
                + ") "
                + "SELECT YEAR(NgayTaoHD) AS Nam, SUM(T.TongTien) AS TongTien "
                + "FROM HoaDon, T "
                + "GROUP BY YEAR(NgayTaoHD) "
                + "ORDER BY  YEAR(NgayTaoHD) DESC";
        int i = 1;
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datas.setValue(rs.getInt("TongTien"), rs.getString("Nam"), rs.getString("Nam"));

                modelTPPS.addRow(new Object[]{
                    i++,
                    rs.getInt("Nam"),
                    formatter.format(rs.getInt("TongTien")) + " vnđ",});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    ////////////////////////////////////////////////////////////////Thu Phi///////////////////////////////////////////////////
    public List<PhatSinh> getListServices() {
        ArrayList<PhatSinh> list = new ArrayList<>();
        String sql = "SELECT * FROM PhatSinh ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhatSinh p = new PhatSinh();
                p.setMaPS(rs.getString("MaPS"));
                p.setTenPS(rs.getString("TenPS"));
                p.setGiaTienPS(rs.getInt("GiaTienPS"));
                p.setDonViTinh(rs.getString("DonViTinh"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<HoaDon> getListBill() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaPhong(rs.getString("MaPhong"));
                hd.setNgayTaoHD(rs.getDate("NgayTaoHD"));

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<TableThuPhi> getListBills(DefaultTableModel modelBills) {

        List<TableThuPhi> list = new ArrayList<>();
        String sql = "SELECT HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS, PS_Phong.MaPS_Phong, SUM(GiaTienPS* SL) AS TongTien "
                + "FROM HoaDon, PhatSinh, PS_Phong "
                + "WHERE "
                + "HoaDon.MaHD = PS_Phong.MaHD "
                + "AND PS_Phong.MaPS = PhatSinh.MaPS "
                + "GROUP BY HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS, PS_Phong.MaPS_Phong "
                + "ORDER BY  PS_Phong.NgayPS DESC";
        int i = 1;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            modelBills.setRowCount(0);
            while (rs.next()) {
                TableThuPhi tableThuPhi = new TableThuPhi();
                //updateTongTienToBill(rs.getString("MaHD").trim(), Integer.parseInt(rs.getString("TongTien")));
                tableThuPhi.setMaHD(rs.getString("MaHD").trim());
                tableThuPhi.setMaPhong(rs.getString("MaPhong").trim());
                tableThuPhi.setNgayPS(rs.getDate("NgayPS"));
                tableThuPhi.setTenPS(rs.getString("TenPS").trim());
                tableThuPhi.setTongTien(rs.getString("TongTien").trim());
                tableThuPhi.setMaPS_Phong(rs.getString("MaPS_Phong").trim());

                list.add(tableThuPhi);

                modelBills.addRow(new Object[]{
                    i++,
                    //                    rs.getString("MaHD").trim(),
                    rs.getString("MaPhong").trim(),
                    rs.getString("TenPS").trim(),
                    format.format(rs.getDate("NgayPS")),
                    formatter.format(Integer.parseInt(rs.getString("TongTien"))),});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void getListBillsByIdRoom(DefaultTableModel modelBills, String phong) {
        String sql = "SELECT HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS, SUM(GiaTienPS* SL) AS TongTien "
                + "FROM HoaDon, PhatSinh, PS_Phong "
                + "WHERE "
                + "HoaDon.MaPhong ='" + phong.trim() + "' "
                + "AND HoaDon.MaHD = PS_Phong.MaHD "
                + "AND PS_Phong.MaPS = PhatSinh.MaPS "
                + "GROUP BY HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS "
                + "ORDER BY  PS_Phong.NgayPS DESC";
        int i = 1;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            modelBills.setRowCount(0);
            while (rs.next()) {
                //updateTongTienToBill(rs.getString("MaHD").trim(), Integer.parseInt(rs.getString("TongTien")));

                modelBills.addRow(new Object[]{
                    i++,
                    //rs.getString("MaHD").trim(),
                    rs.getString("MaPhong").trim(),
                    rs.getString("TenPS").trim(),
                    format.format(rs.getDate("NgayPS")),
                    formatter.format(Integer.parseInt(rs.getString("TongTien"))),});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getListBillsByIdRoomWithMouth(DefaultTableModel modelBills, String phong, String nam, String thang, JLabel txtTongTien) {
        String sql = "SELECT HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS, SUM(GiaTienPS* SL) AS TongTien "
                + "FROM HoaDon, PhatSinh, PS_Phong "
                + "WHERE "
                + "MONTH(PS_Phong.NgayPS) ='" + thang.trim() + "' "
                + "AND YEAR(PS_Phong.NgayPS) ='" + nam.trim() + "' "
                + "AND HoaDon.MaPhong ='" + phong.trim() + "' "
                + "AND HoaDon.MaHD = PS_Phong.MaHD "
                + "AND PS_Phong.MaPS = PhatSinh.MaPS "
                + "GROUP BY HoaDon.MaHD, PS_Phong.NgayPS, HoaDon.MaPhong, PhatSinh.TenPS "
                + "ORDER BY  PS_Phong.NgayPS DESC";
        int i = 1;
        int tongTien = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            modelBills.setRowCount(0);
            while (rs.next()) {
                //updateTongTienToBill(rs.getString("MaHD").trim(), Integer.parseInt(rs.getString("TongTien")));
                tongTien += Integer.parseInt(rs.getString("TongTien"));
                modelBills.addRow(new Object[]{
                    i++,
                    //rs.getString("MaHD").trim(),
                    rs.getString("MaPhong").trim(),
                    rs.getString("TenPS").trim(),
                    format.format(rs.getDate("NgayPS")),
                    formatter.format(Integer.parseInt(rs.getString("TongTien"))),});
            }
            txtTongTien.setText(formatter.format(tongTien) + " vnđ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public boolean updateTongTienToBill(String maHD, int tongTien) {
//        String sql = "UPDATE HoaDon "
//                + "SET TongTien = " + tongTien + " "
//                + "WHERE MaHD = '" + maHD + "'";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    public boolean addServices(PhatSinh p) {
        String sql = "INSERT INTO PhatSinh(MaPS,TenPS,GiaTienPS,DonViTinh) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getMaPS());
            ps.setString(2, p.getTenPS());

            ps.setInt(3, p.getGiaTienPS());
            ps.setString(4, p.getDonViTinh());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePhatSinh(PhatSinh ps) {
        String sql = "UPDATE PhatSinh SET "
                + "TenPS = N'" + ps.getTenPS() + "',"
                + "DonViTinh = N'" + ps.getDonViTinh() + "',"
                + "GiaTienPS = " + ps.getGiaTienPS()
                + " WHERE MaPS = '" + ps.getMaPS() + "'";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            return p.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePhatSinh(String maPS) {
        String sql = "DELETE FROM PhatSinh WHERE MaPS = '" + maPS + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addBill(HoaDon hd) {
        String sql = "INSERT INTO HoaDon(MaHD,MaPhong,NgayTaoHD) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hd.getMaHD());
            ps.setString(2, hd.getMaPhong());

            ps.setDate(3, (java.sql.Date) new java.sql.Date(hd.getNgayTaoHD().getTime()));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPSPhong(PS_Phong pS_Phong) {
        String sql = "INSERT INTO PS_Phong(MaPS_Phong,MaHD,MaPS,NgayPS,SL) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pS_Phong.getMaPS_Phong().trim());
            ps.setString(2, pS_Phong.getMaHD().trim());

            ps.setString(3, pS_Phong.getMaPS().trim());
            ps.setDate(4, (java.sql.Date) new java.sql.Date(pS_Phong.getNgayPS().getTime()));
            ps.setInt(5, pS_Phong.getSL());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Integer> getYearPS() {
        String sql = "SELECT DISTINCT  YEAR(NgayPS) AS Nam FROM PS_Phong ORDER BY YEAR(NgayPS) DESC";
        List<Integer> years = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                years.add(rs.getInt("Nam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return years;
    }

    public PS_Phong getPSPhongByID(String maPSP) {
        String sql = "SELECT * FROM PS_Phong WHERE MaPS_Phong = '" + maPSP.trim() + "'";
        PS_Phong psp = new PS_Phong();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                psp.setMaPS_Phong(rs.getString("MaPS_Phong"));
                psp.setMaHD(rs.getString("MaHD"));
                psp.setMaPS("MaPS");
                psp.setNgayPS(rs.getDate("NgayPS"));
                psp.setSL(rs.getInt("SL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return psp;
    }

    public boolean updatePS_Phong(PS_Phong pS_Phong, String maHD) {
//        PS_Phong psp = getPSPhongByID(pS_Phong.getMaPS_Phong().trim());
//        int SL = psp.getSL() + pS_Phong.getSL();
        String sql = "UPDATE PS_Phong SET "
                + "SL = '" + pS_Phong.getSL() + "'"
                // + "MaPS = '" + pS_Phong.getMaPS()+"'"
                + " WHERE MaPS = '" + pS_Phong.getMaPS().trim() + "' AND MaHD = '" + pS_Phong.getMaHD().trim() + "'";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            return p.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<PS_Phong> getListRoomServices() {
        ArrayList<PS_Phong> list = new ArrayList<>();
        String sql = "SELECT * FROM PS_Phong ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PS_Phong pS_Phong = new PS_Phong();
                pS_Phong.setMaHD(rs.getString("MaHD"));
                pS_Phong.setMaPS_Phong(rs.getString("MaPS_Phong"));
                pS_Phong.setMaPS(rs.getString("MaPS"));
                pS_Phong.setNgayPS(rs.getDate("NgayPS"));
                pS_Phong.setSL(rs.getInt("SL"));

                list.add(pS_Phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
<<<<<<< HEAD

    public boolean deletePhatSinhPhong(TableThuPhi get) {
        String sql = "DELETE FROM PS_Phong "
                + "WHERE MaPS_Phong = '" + get.getMaPS_Phong().trim() + "' "
                + "AND MaHD = '" + get.getMaHD().trim() + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

=======
    
    public PS_Phong getPSPhongWithID(String maHD, String maPhong)
    {
        PS_Phong psp = new PS_Phong();
        String sql = "SELECT * FROM PS_Phong WHERE MaHD = '" + maHD + "' AND MaPhong = '" + maPhong + "'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                psp.setMaHD(rs.getString("MaHD"));
                psp.setMaPS_Phong(rs.getString("MaPS_Phong"));
                psp.setMaPS(rs.getString("MaPS"));
                psp.setNgayPS(rs.getDate("NgayPS"));
                psp.setSL(rs.getInt("SL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return psp;
    }
    
>>>>>>> 3bd25eb8636d9291230d40117ea6b22b0cc43864
//>>>>>>> 5f0ff9ff387a965095caf454e79d0d0e0c68c264
    public static void main(String[] args) {
        new DAO();
    }

}
