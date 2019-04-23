package UTN.Database;

import UTN.Models.Winner;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WinnerDAO {
    private static final String TABLE = "winners";
    private PreparedStatement pStmt = null;
    private Connection conn = null;

    public int setWinner(Winner winner){
        int affectedRows = 0;

        try {
            conn = JDBCConnection.getInstance().getConnection();
            String sql;
            sql = "INSERT INTO " + TABLE + " (name, winDate, word)" +
                    "VALUES (?, ?, ?)";
            pStmt = conn.prepareStatement(sql);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            pStmt.setString(1,winner.getName());
            pStmt.setObject(2, winner.getDate());
            pStmt.setString(3,winner.getWord());

            affectedRows = pStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(pStmt);
            DbUtils.closeQuietly(conn);
        }

        return affectedRows;
    }
}
