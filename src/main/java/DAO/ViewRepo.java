package DAO;

import Model.*;
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

    //NEW
    public List<warrantyInformation> getAllWarranty(){
        List<warrantyInformation> allWarranty = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();;
            ResultSet rs = statement.executeQuery("SELECT * FROM warrantyInformation");
            while (rs.next()){
                warrantyInformation loadWarranty = new warrantyInformation(rs.getInt("customerID"),rs.getInt(
                        "warrantyID"),rs.getInt(
                                "brandID"),rs.getInt("genderID"),rs.getInt("productTypeID"),rs.getString("productName"),rs.getString("productIssue"),rs.getString("status"));
                allWarranty.add(loadWarranty);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return allWarranty;
    }
    // NEW LOOK UP
    public List<warrantyInformation> getWarrantyFromWarrantyNo(int warrantyID){
        List<warrantyInformation> allWarranty = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM warrantyInformation WHERE warrantyID =" +
                    " ?");;
            statement.setInt(1,warrantyID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                warrantyInformation loadWarranty = new warrantyInformation(rs.getInt("customerID"),rs.getInt(
                        "warrantyID"),rs.getInt(
                        "brandID"),rs.getInt("genderID"),rs.getInt("productTypeID"),rs.getString("productName"),rs.getString("productIssue"),rs.getString("status"));
                allWarranty.add(loadWarranty);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return allWarranty;
    }
    //NEW GET CUSTOMER NAME FROM ID
    public customerInformation getCustomerNameFromID(int customerID){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM customerinformation WHERE id = ?");
            statement.setInt(1,customerID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return new customerInformation (rs.getInt("id"),rs.getString("name"),rs.getString("email"),
                        rs.getString("phone"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //NEW GET BRAND NAME FROM ID

    public brand getBrandNameFromID(int brandID){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM brand WHERE id=?");
            statement.setInt(1,brandID);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return new brand (rs.getInt("id"),rs.getString("brand_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //NEW GET GENDER FROM ID

    public gender getGenderFromID(int genderID){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM gender WHERE id=?");
            statement.setInt(1,genderID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new gender(rs.getInt("id"),rs.getString("gender"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // NEW GET PRODUCT TYPE FROM ID
    public productType getProductTypeFromID(int productTypeID){
         try{
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM productType WHERE id = ?");
             statement.setInt(1,productTypeID);
             ResultSet rs = statement.executeQuery();
             while (rs.next()){
                 return new productType(rs.getInt("id"),rs.getString("productType"));
             }
         } catch (SQLException e){
             e.printStackTrace();
         }
         return null;
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
