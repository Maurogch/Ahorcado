package UTN.Database;

import org.apache.commons.dbutils.DbUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class WordDAO {
    private static final String TABLE = "words";
    private Statement stmt = null;
    private PreparedStatement pStmt = null;
    private Connection conn = null;
    private ResultSet rs = null;

    public String getWord(){
        String word = null;

        try {
            conn = JDBCConnection.getInstance().getConnection();

            //Get max number of idWord (previously getting number of rows, but its not compatible if there are gaps in id)
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT max(idWord) FROM " + TABLE;
            rs = stmt.executeQuery(sql);
            rs.next();
            int numberOfWords = rs.getInt("max(idWord)");

            //Get a random word from table, using random with top as max id (previously number of rows)
            //Inside of a loop in case there are gaps in idWord from removing words from database
            while (Objects.isNull(word)){
                sql = "SELECT word FROM " + TABLE +
                        " WHERE idWord = ?";
                pStmt = conn.prepareStatement(sql);
                pStmt.setInt(1, ThreadLocalRandom.current().nextInt(1, numberOfWords));
                rs = pStmt.executeQuery();
                rs.next();
                word = rs.getString("word");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(pStmt);
            DbUtils.closeQuietly(conn);
        }

        return word;
    }
}
