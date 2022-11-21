package DAO;

import Model.AdminInformation;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminLoginRepo {
    Connection connection = ConnectionUtil.getConnection();


    //FOR LOGIN - JS
    public List<AdminInformation> getLoginInfo(String userName, String password){
        List<AdminInformation> allLogins = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM adminInformation");
            while (rs.next()){
                AdminInformation loadLogin = new AdminInformation(rs.getString(userName), rs.getString(password));
                allLogins.add(loadLogin);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return allLogins;
    }

    //  WE USED THIS ONE
        public AdminInformation getUserByUsername(String userName){

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM adminInformation WHERE userName = ?");
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return new AdminInformation(rs.getString("userName"), rs.getString("userPassword"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }



   // THIS WAS USED FOR PROJECT 0
//    public String getUserPswByUserName(String userName) {
//        try {
//            PreparedStatement statement = conn.prepareStatement("SELECT userPassword FROM adminInformation WHERE " +
//                    "userName = ?");
//            statement.setString(1, userName);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                String userPassword = rs.getString("userPassword");
//                return userPassword;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }



}
