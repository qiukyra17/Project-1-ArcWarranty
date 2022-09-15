package DAO;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
