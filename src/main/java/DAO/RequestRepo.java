package DAO;

import Model.customerInformation;
import Model.warrantyInformation;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestRepo {
    Connection conn = ConnectionUtil.getConnection();

    public void addCustomerInformation(customerInformation ci) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into CustomerInformation(name, email, phone) " +
                    "values " +
                    "(?," +
                    "?," +
                    "?)");
            statement.setString(1, ci.getName());
            statement.setString(2, ci.getEmail());
            statement.setString(3, (ci.getPhone()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public customerInformation getCustomerByEmail(String email) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from CustomerInformation where email = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                customerInformation ci = new customerInformation(rs.getInt("id"),rs.getString("name"), rs.getString(
                        "email"),
                        rs.getString("phone"));
                return ci;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retrieve CustomerID and Auto Insert

    public int getCustomerIdByEmail(String email) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT ID from customerinformation WHERE Email = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int customerID = rs.getInt("ID");
                return customerID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addWarrantyInformation(warrantyInformation wi) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement("INSERT INTO warrantyinformation (customerID,brandID,genderID,productTypeID,productName,productIssue,status) VALUES (?,?,?,?,?,?,?)");
            statement.setInt(1, wi.customerID);
            statement.setInt(2, wi.brandID);
            statement.setInt(3, wi.genderID);
            statement.setInt(4, wi.productTypeID);
            statement.setString(5, wi.productName);
            statement.setString(6, wi.productIssue);
            statement.setString(7, wi.status);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
