package dao;

import java.sql.*;

import model.User;


/**
 * @author dunant
 */
public class UserDao {
    /**
     * 登录验证
     * @param con
     * @param user
     * @return
     * @throws Exception
     */
    public User login(Connection con,User user)throws Exception{
        User resultUser=null;
        String sql="select * from users where name=? and password=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,user.getName());
        pstmt.setString(2,user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if (rs.next()){
            resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setName(rs.getString("name"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
}



