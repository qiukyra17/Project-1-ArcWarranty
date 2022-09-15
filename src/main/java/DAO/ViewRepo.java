package DAO;

import Model.warrantyInformation;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewRepo {
    Connection conn = ConnectionUtil.getConnection();

    public List<String> getAllWarrantyInformation() {
        List<String> allWarranties = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM warrantyStatusLog");
                while (rs.next()) {
                    String customerName = rs.getString("name");
                    int warrantyID = rs.getInt("warrantyid");
                    String brand_name = rs.getString("brand_name");
                    String genderType = rs.getString("gender");
                    String productType = rs.getString("productType");
                    String productName = rs.getString("productName");
                    String productIssue = rs.getString(
                            "productIssue");
                    String status = rs.getString("status");
                    String message =
                            ("Name: " + customerName + " - Warranty Number: " + warrantyID + " - Brand: " + brand_name +
                            " - Gender: " + genderType +
                            " - Product Type: " + productType + " - Product Name: " + productName + " - Product Issue: " + productIssue +
                            " - " +
                            "Current " +
                            "Status:" +
                            " " + status);
                    allWarranties.add(message);
                }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return allWarranties;
    }

    public int getWarrantyIDFromWarrantyInfo(int customerID, int brandID, int productTypeID, String productIssue,
                                             String status) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement("SELECT warrantyID FROM warrantyinformation WHERE customerID = ? AND " +
                            "brandID = ? AND productTypeID = ? AND productIssue =? AND status =?");
            statement.setInt(1, customerID);
            statement.setInt(2, brandID);
            statement.setInt(3, productTypeID);
            statement.setString(4, productIssue);
            statement.setString(5, status);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int warrantyID = rs.getInt("warrantyID");
                return warrantyID;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM warrantyStatusLog WHERE warrantyID =?");
            statement.setInt(1, warrantyNo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String customerName = rs.getString("name");
                int warrantyID = rs.getInt("warrantyid");
                String brand_name = rs.getString("brand_name");
                String gender = rs.getString("gender");
                String productType = rs.getString("productType");
                String productName = rs.getString("productName");
                String productIssue = rs.getString(
                        "productIssue");
                String status = rs.getString("status");
                return "Customer's Name: " + customerName + " - Warranty Number: " + warrantyID + " - Brand: " + brand_name +
                        " - Product Type: " + productType + " - Product Name: " + productName + " - Product Issue: " + productIssue +
                        " " +
                        "- Current " +
                        "Status:" +
                        " " + status;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
