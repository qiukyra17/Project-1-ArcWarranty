package DAO;

import Model.WarrantyInformation;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRepo {
    Connection conn = ConnectionUtil.getConnection();

    public String updateWarrantyInformation(String status, int warrantyNo) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE warrantyinformation SET status = ? WHERE " +
                    "warrantyid = ?;");

            statement.setString(1, status);
            statement.setInt(2, warrantyNo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    //NEW
    public WarrantyInformation getWarrantyByWarrantyID(int warrantyID) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM warrantyInformation WHERE warrantyID =" +
                    " ?");
            statement.setInt(1, warrantyID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new WarrantyInformation(rs.getInt("customerID"), rs.getInt(
                        "warrantyID"), rs.getInt(
                        "brandID"), rs.getInt("genderID"), rs.getInt("productTypeID"), rs.getString("productName"),
                        rs.getString("productIssue"), rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
