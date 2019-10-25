package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeTai {

    public Connect cn = new Connect();

    //Truy van tat ca du lieu trong Table
    public ResultSet ShowDeTai() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM tDeTai";
        return cn.LoadData(sql);
    }

    //Truy van cac dong du lieu trong Table
    public ResultSet ShowDeTai(String id) throws SQLException {
        String sql = "SELECT * FROM tDeTai where STTDeTai='" + id + "'";
        return cn.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table
    public void InsertData(String STTDeTai, String tenDeTai, String yeuCauDeTai, String ghiChu) throws SQLException {
        String sql = "INSERT INTO tDeTai values('" + STTDeTai + "',N'" + tenDeTai + "',N'" + yeuCauDeTai + "','" + ghiChu + "')";
        cn.UpdateData(sql);
    }

    //Dieu chinh 1 dong du lieu vao table
    public void EditData(String STTDeTai, String tenDeTai, String yeuCauDeTai, String ghiChu) throws SQLException {
        String sql = "Update tDeTai set TenDeTai=N'" + tenDeTai
                + "',YeuCauDeTai=N'" + yeuCauDeTai + "', GhiChu='" + ghiChu + "' where STTDeTai='" + STTDeTai + "'";
        cn.UpdateData(sql);
    }

    //Xoa 1 dong du lieu vao table
    public void DeleteData(String id) throws SQLException {
        String sql = "Delete from tDeTai where STTDeTai='" + id + "'";
        cn.UpdateData(sql);
    }

    public boolean tontaima(String id) throws SQLException {
        String sql = "select * from tDeTai where STTDeTai='" + id + "'";
        ResultSet rs = cn.LoadData(sql);
        rs.last();
        if (rs.getRow() > 0) {
            return false;
        }
        return true;

    }
}
