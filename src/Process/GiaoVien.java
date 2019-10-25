package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GiaoVien {

    public Connect cn = new Connect();

    //Truy van tat ca du lieu trong Table
    public ResultSet ShowGiaoVien() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM tGiaoVien";
        return cn.LoadData(sql);
    }

    //Truy van cac dong du lieu trong Table
    public ResultSet ShowGiaoVien(String id) throws SQLException {
        String sql = "SELECT * FROM tGiaoVien where MaGiaoVien='" + id + "'";
        return cn.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table
    public void InsertData(String MaGiaoVien, String TenGiaoVien, String HocVi, String SoDT, String Khoa) throws SQLException {
        String sql = "INSERT INTO tGiaoVien values('" + MaGiaoVien + "',N'" + TenGiaoVien + "',N'" + HocVi + "','"+SoDT+"','" + Khoa + "')";
        cn.UpdateData(sql);
    }

    //Dieu chinh 1 dong du lieu vao table
    public void EditData(String MaGiaoVien, String TenGiaoVien, String HocVi, String SoDT, String Khoa) throws SQLException {
        String sql = "Update tGiaoVien set TenGiaoVien=N'" + TenGiaoVien
                + "',HocVi=N'" + HocVi + "', SoDT='" + SoDT + "', MaKhoa='"+Khoa+"' where MaGiaoVien='" + MaGiaoVien + "'";
        cn.UpdateData(sql);
    }

    //Xoa 1 dong du lieu vao table
    public void DeleteData(String id) throws SQLException {
        String sql = "Delete from tGiaoVien where MaGiaoVien='" + id + "'";
        cn.UpdateData(sql);
    }

    public boolean tontaima(String id) throws SQLException {
        String sql = "select * from tGiaoVien where MaGiaoVien='" + id + "'";
        ResultSet rs = cn.LoadData(sql);
        rs.last();
        if (rs.getRow() > 0) {
            return false;
        }
        return true;

    }
}
