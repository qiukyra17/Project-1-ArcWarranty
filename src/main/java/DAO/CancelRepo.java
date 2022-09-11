package DAO;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelRepo {
    Connection conn = ConnectionUtil.getConnection();

    //instructions to Cancel your Request
    public void deleteWarrantyRequestByWarrantyNo(int warrantyNo) {
        try {
            PreparedStatement statement = conn.prepareStatement("Delete from WarrantyInformation where " +
                    "warrantyID=?");
            statement.setInt(1, warrantyNo);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}