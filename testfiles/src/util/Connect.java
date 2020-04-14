package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author dunant
 */
public class Connect {
    private static String url = "jdbc:mysql://localhost:3306/wei";

    private static String dbUserName = "root";

    private static String dbPassword = "Dunant";

    private static String jdbcName = "com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(url, dbUserName, dbPassword);
        return null;
    }

    /**
     * 关闭数据库
     * @param con
     * @throws Exception
     */
    public void close(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }


    public static void main(String[] args) {
        Connect dbUtil = new Connect();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }
    }
}