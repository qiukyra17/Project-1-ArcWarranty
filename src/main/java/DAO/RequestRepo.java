package DAO;

import DTO.WarrantyRequest;
import Model.CustomerInformation;
import Util.ConnectionUtil;

import java.sql.*;

public class RequestRepo {
    Connection conn = ConnectionUtil.getConnection();

    public void addCustomerInformation(CustomerInformation ci) {
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

    public CustomerInformation getCustomerByEmail(String email) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM customerInformation WHERE email = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new CustomerInformation(rs.getInt("id"),rs.getString("name"),
                        rs.getString(
                        "email"),
                        rs.getString("phone"));
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

    public int addWarrantyInformation(WarrantyRequest wi) {
        int warrantyID = 0;
        try {
            PreparedStatement statement =
                    conn.prepareStatement("INSERT INTO warrantyinformation (customerID,brandID,genderID," +
                            "productTypeID,productName,productIssue,status) VALUES (?,?,?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, wi.customerID());
            statement.setInt(2, wi.brandID());
            statement.setInt(3, wi.genderID());
            statement.setInt(4, wi.productTypeID());
            statement.setString(5, wi.productName());
            statement.setString(6, wi.productIssue());
            statement.setString(7, wi.status());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                warrantyID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(warrantyID);
        return warrantyID;
    }


}
