package DAO;

import Util.ConnectionUtil;

import java.sql.*;

public class AdminLoginRepo {
    //Need to look up username psw from username
    Connection conn = ConnectionUtil.getConnection();

   // this generates the user password
    public String getUserPswByUserName(String userName) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT userPassword FROM adminInformation WHERE " +
                    "userName = ?");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String userPassword = rs.getString("userPassword");
                return userPassword;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public String getUserNameByUserPsw(String userPassword) {
//        try {
//            PreparedStatement statement = conn.prepareStatement("SELECT userName FROM adminInformation WHERE " +
//                    "userPassword = ?");
//            statement.setString(1, userPassword);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                String userName = rs.getString("userName");
//                return userName;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public boolean checkLogin(String userName, String userPassword){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM adminInformation WHERE userName=? AND " +
                    "userPassword = ?");
            statement.setString(1,userName);
            statement.setString(2,userPassword);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return true;
            } else return false;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
