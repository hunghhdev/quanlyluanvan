
package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhanCong {
    public Connect cn = new Connect();

    //Truy van tat ca du lieu trong Table
    public ResultSet ShowPhanCong() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM tPhanCong";
        return cn.LoadData(sql);
    }

    //Truy van cac dong du lieu trong Table
    public ResultSet ShowPhanCong(String id) throws SQLException {
        String sql = "SELECT * FROM tPhanCong where MaSV='" + id + "'";
        return cn.LoadData(sql);
    }

    //Theo moi 1 dong du lieu vao table
    public void InsertData(String MaSinhVien, int STTDeTai, String MaGVHuongDan, String MaGVPhanBien, int DiemGVHuongDan, int DiemGVPhanBien, String NhanXetGVHuongDan, String NhanXetGVPhanBien) throws SQLException {
        String sql = "INSERT INTO tPhanCong values('" + MaSinhVien + "',N'" + STTDeTai + "',N'" + MaGVHuongDan + "','"+ MaGVPhanBien +"','" + DiemGVHuongDan +"','"+ DiemGVPhanBien +"','"+ NhanXetGVHuongDan +"','"+ NhanXetGVPhanBien +"')";
        System.out.println(sql);
        cn.UpdateData(sql);
    }

    //Dieu chinh 1 dong du lieu vao table
    public void EditData(String MaSinhVien, int STTDeTai, String MaGVHuongDan, String MaGVPhanBien, int DiemGVHuongDan, int DiemGVPhanBien, String NhanXetGVHuongDan, String NhanXetGVPhanBien) throws SQLException {
        String sql = "Update tPhanCong set MaGVHuongDan=N'" + MaGVHuongDan
                + "',MaGVPhanBien=N'" + MaGVPhanBien 
                + "', DiemGVHuongDan='" + DiemGVHuongDan 
                + "', DiemGVPhanBien='"+ DiemGVPhanBien
                +"', NhanXetGVHuongDan='"+ NhanXetGVHuongDan
                +"', NhanXetGVPhanBien='"+ NhanXetGVPhanBien
                +"' where MaSinhVien='" + MaSinhVien 
                +"' and STTDeTai='" + STTDeTai 
                + "'";
        System.out.println(sql);
        cn.UpdateData(sql);
    }

    //Xoa 1 dong du lieu vao table
    public void DeleteData(String MaSinhVien, int STTDeTai) throws SQLException {
        String sql = "Delete from tPhanCong where MaSinhVien='" + MaSinhVien + "' and STTDeTai='"+STTDeTai+"'";
        cn.UpdateData(sql);
    }

    public boolean tontaima(String MaSinhVien, int STTDeTai) throws SQLException {
        String sql = "select * from tPhanCong where MaSinhVien='" + MaSinhVien + "' and STTDeTai='"+STTDeTai+"'";
        ResultSet rs = cn.LoadData(sql);
        rs.last();
        if (rs.getRow() > 0) {
            return false;
        }
        return true;
    }
}
