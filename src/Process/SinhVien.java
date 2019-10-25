
package Process;

import Database.Connect;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class SinhVien {
    public Connect cn = new Connect();

    //Truy van tat ca du lieu trong Table
    public ResultSet ShowSinhVien() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM tSinhVien";
        return cn.LoadData(sql);
    }

    //Truy van cac dong du lieu trong Table
    public ResultSet ShowSinhVien(String id) throws SQLException {
        String sql = "SELECT * FROM tSinhVien where MaSV='" + id + "'";
        return cn.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table
    public void InsertData(String MaSV, String HoTenSV, String Phai, Date NgaySinh, String SoDT, String DiaChi, String khoa) throws SQLException {
        java.sql.Date dateDB = new java.sql.Date(NgaySinh.getTime());
        String sql = "INSERT INTO tSinhVien values('" + MaSV + "',N'" + HoTenSV + "',N'" + Phai + "','"+dateDB+"','" + SoDT +"','"+ DiaChi +"','"+ khoa +"')";
        System.out.println(sql);
        cn.UpdateData(sql);
    }

    //Dieu chinh 1 dong du lieu vao table
    public void EditData(String MaSV, String HoTenSV, String Phai, Date NgaySinh, String SoDT, String DiaChi, String khoa) throws SQLException {
        java.sql.Date dateDB = new java.sql.Date(NgaySinh.getTime());
        String sql = "Update tSinhVien set HoTenSV=N'" + HoTenSV
                + "',Phai=N'" + Phai + "', NgaySinh='" + dateDB + "', SoDT='"+SoDT+"', DiaChi='"+DiaChi+"', MaKhoa='"+khoa+"' where MaSV='" + MaSV + "'";
        System.out.println(sql);
        cn.UpdateData(sql);
    }

    //Xoa 1 dong du lieu vao table
    public void DeleteData(String id) throws SQLException {
        String sql = "Delete from tSinhVien where MaSV='" + id + "'";
        cn.UpdateData(sql);
    }

    public boolean tontaima(String id) throws SQLException {
        String sql = "select * from tSinhVien where MaSV='" + id + "'";
        ResultSet rs = cn.LoadData(sql);
        rs.last();
        if (rs.getRow() > 0) {
            return false;
        }
        return true;
    }
}
