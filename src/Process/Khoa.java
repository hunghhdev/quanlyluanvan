package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Khoa {

    public Connect cn = new Connect();

    //Truy van tat ca du lieu trong Table Khoa
    public ResultSet ShowKhoa() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM tKhoa";
        return cn.LoadData(sql);
    }
    
    //Truy van cac dong du lieu trong Table Khoa
    public ResultSet ShowKhoa(String id) throws SQLException {
        String sql = "SELECT * FROM tKhoa where MaKhoa='" + id + "'";
        return cn.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table  Khoa
    public void InsertData(String MaKhoa, String tenKhoa, String diaChi, String soDT) throws SQLException {
        String sql = "INSERT INTO tKhoa values('" + MaKhoa + "',N'" + tenKhoa + "',N'" + diaChi + "','" + soDT + "')";
        cn.UpdateData(sql);
    }

    //Dieu chinh 1 dong du lieu vao table  Khoa
    public void EditData(String MaKhoa, String tenKhoa, String diaChi, String soDT) throws SQLException {
        String sql = "Update tKhoa set TenKhoa=N'" + tenKhoa
                + "',DiaChi=N'" + diaChi + "', SoDT='" + soDT + "' where MaKhoa='" + MaKhoa + "'";
        cn.UpdateData(sql);
    }
    
    public void DeleteData(String id) throws SQLException {
        String sql = "Delete from tKhoa where MaKhoa='" + id + "'";
        cn.UpdateData(sql);
    }

    public boolean tontaima(String id) throws SQLException {
        String sql = "select * from tKhoa where MaKhoa='" + id + "'";
        ResultSet rs = cn.LoadData(sql);
        rs.last();
        if (rs.getRow() > 0) {
            return false;
        }
        return true;

    }

}
