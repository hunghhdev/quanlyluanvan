package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connect {

    public static Connection Conn;

    public void connectSQL() throws SQLException {
        try {
            String userName = "root";
            String password = "";
            //String url = "jdbc:mysql://localhost:3306/qlLuanVan?useUnicode=yes&characterEncoding=UTF-8";
            String url="jdbc:sqlserver://localhost;databaseName=Ql_Dean;user=sa;password=dzoanthanh";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.mysql.jdbc.Driver");
            Conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ket noi CSDL that bai", "Thong bao", 1);
        }
    }
    //Phuong thuc dung de truy van CSDL
    public ResultSet LoadData(String sql) {
        ResultSet result = null;
        try {
            Statement statement = Conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //Phuong thuc thuc hien Them, Xoa, Sua du lieu
    public void UpdateData(String sql) {
        try {
            Statement statement = Conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public boolean isKey(String sql) {
        try {
            Statement statement = Conn.createStatement();
            int rs = statement.executeUpdate(sql);
            return rs >= 1;
        } catch (SQLException e) {           
            e.printStackTrace(); 
            return false;
            
        }
    }
}
