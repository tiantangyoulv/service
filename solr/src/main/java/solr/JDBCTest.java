package solr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renming.cheng on 2017/1/12.
 */
public class JDBCTest {
    public static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.27.54:3328/DB_WZP";
        String username = "dj_t";
        String password = "da@jie.123";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static List<MsgPic> getAll() {
        Connection conn = getConn();
        String sql = "SELECT id,NAME,ad_title FROM tb_wzp_message_pic";
        PreparedStatement pstmt;
        List<MsgPic> msgPics = new ArrayList<MsgPic>();
        try {

             pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MsgPic msgPic = new MsgPic();
                msgPic.setId(rs.getInt(1));
                msgPic.setName(rs.getString(2));
                msgPic.setAd_link(rs.getString(3));
                msgPics.add(msgPic);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msgPics;
    }
}
