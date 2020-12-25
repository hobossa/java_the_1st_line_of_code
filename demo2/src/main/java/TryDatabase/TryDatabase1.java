package TryDatabase;

import java.sql.*;

// use sqlite instead of oracle. so we do not need to have access to an oracle database.
// what's better is sqlite is easy to use, 0 configuration.
// https://www.sqlitetutorial.net/sqlite-java/
public class TryDatabase1 {

    private static final String DB_URL = "jdbc:sqlite:demo2.db";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection to SQLite has been established.");
            System.out.println("The driver name is " + conn.getMetaData().getDriverName());
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS member (\n" +
                    "    mid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name TEXT,\n" +
                    "    birthday TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                    "    age INTEGER,\n" +
                    "    note TEXT" +
                    ");";
            stmt.execute(sqlCreateTable);
            String sqlInsert = "INSERT INTO member(name, birthday, age, note) VALUES" +
                    "    ('Jackson', DATE('1987-09-15'), 17, 'The Jackson');";
            stmt.executeUpdate(sqlInsert);
            String sqlInsertEx = "INSERT INTO member(name, birthday, age, note) VALUES" +
                    "    (?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsertEx);
            pstmt.setString(1, "Junior Jackson");
            pstmt.setString(2, "2020-10-10");
            // pstmt.setDate(2, java.sql.Date.valueOf("2013-09-04"));
            // pstmt.setTimestamp(2, java.sql.Timestamp.valueOf("2011-11-11 00:00:00"));
            pstmt.setInt(3, 20);
            pstmt.setString(4, "I am young.");
            pstmt.executeUpdate();
            // transaction
            // Statement.addBatch Statement.executeBatch
            // PreparedStatement.addBatch
            // Connection.commit() Connection.rollback()
            // try {
            //    addBatch;
            //    executeBatch;
            //    commit;
            // } catch {
            //    rollback;
            // }
            String sqlSelect = "SELECT mid, name, birthday, age, note FROM member;";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            while (rs.next()) {
                // getXXX 's argument can be a string or an index.
                System.out.println(rs.getInt("mid") + " "
                        + rs.getString(2) + " "
                        + rs.getString("birthday") + " "
                        + rs.getInt("age") + " "
                        + rs.getString("note"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
